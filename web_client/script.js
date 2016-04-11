var dataObject = new Object();
var errorObject = null;
var method = null;
var logged = 0;
var registerFlag = 0;
var statusString;
var showMessages = 0;

$(document).ready(function(){ 
	checkUI();
	$("#reg_link").click(function(){
		registerFlag = 1;
		checkUI();
	});
	//testXML();
});

function testXML(){
	var account = new Object();
	account.id = -1;
	account.name = "user1";
	account.password = "user1";
	console.log(createXMLMessage("register", account));
	console.log(createXMLMessage("login", account));
	console.log(createXMLMessage("save", account));
	console.log(createXMLMessage("delete", account));
}

function processAction(type){
	var account = new Object();
	account.id = -1;
	account.name = $("#login_field").val();
	account.password = $("#pass_field").val();
	method = $('input[name=method]:checked').val();
	var error = validateInputData(account);

	if(error == 0){
		if(logged == 0){
			if(isFieldsEmpty(account) == 0){
				if(registerFlag == 1){
					sendAJAX("register",account);
				}
				else{
					sendAJAX("login",account);
				}
			}
		}
		else{
			if(type == 1){
				dataObject.name = ((account.name.length != 0)?account.name:dataObject.name);
				dataObject.password = ((account.password.length != 0)?account.password:dataObject.password);
				sendAJAX("save",dataObject);
			}
			else{
				sendAJAX("delete",dataObject);
			}
		}
	}
}

function checkUI(){
	$("#login_field").val("");
	$("#pass_field").val("");
	if(logged == 0){
		if(registerFlag == 1){
			statusString = "Register Page";
			$("#text_container").html(statusString);
			$("#register_link").css("display","none");
			$("#first_button").val("Register");
		}
		else{
			statusString = "Login Page";
			$("#text_container").html(statusString);
			$("#register_link").css("display","block");
			$("#second_button").css("display","none");
			$("#first_button").val("Login");
		}
	}
	else{
		statusString = "Welcome " + dataObject.name;
		$("#text_container").html(statusString);
		$("#register_link").css("display","none");
		$("#second_button").css("display","inline-block");
		$("#first_button").val("Edit");
	}
}

function validateInputData(account){
	if(account.name.match(/\n|,/)){
		alert("Wrong username's format!");
		return -1;
	}
	if(account.password.match(/\n|,/)){
		alert("Wrong password's format!");
		return -2;
	}
	return 0;
}

function isFieldsEmpty(account){
	if(account.name.length == 0 || account.password.length == 0){
		alert("Empty fields");
		return 1;
	}
	return 0;
}

function sendAJAXREST(operation, account){
	if(showMessages == 1){
		console.log("REST request: " + JSON.stringify(account));
	}
	$.ajax({
	  method: "POST",
	  url: "http://localhost:8080/WS_Ass_try3_war_exploded/restService/rest/"+operation,
	  contentType: "application/json; charset=utf-8",
	  dataType: "json",
	  data: JSON.stringify(account),
	}).done(function( msg ) {
		if(operation == 'save'){
			dataObject.name = account.name;
			dataObject.password = account.password;
		}else{
			dataObject = msg;
		}
		errorObject = null;
    	//console.log("DONE");
    	processResponse(1,operation);
  	}).fail(function( msg ){
  		dataObject = null;
  		alert(msg.responseJSON.error);
  		processResponse(0,operation);
  	}).always(function(msg){
  		if(showMessages == 1){
			console.log("REST response: ");
			console.log(msg);
		}
  	});
}

function processResponse(status,operation){
	if(status === 1){
		switch(operation){
			case "register":
				registerFlag = 0;
				console.log("reg");
			break;
			case "save":
				console.log("save");
			break;
			case "login":
				logged = 1;
				console.log("login");
			break;
			case "delete":
				console.log("delete");
				logged = 0;
			break;
		}
		checkUI();
	}
}

function sendAJAX(operation, account){
	if(method == 'soap'){
		sendAJAXSOAP(operation, account);
	}
	else{
		sendAJAXREST(operation, account);
	}
}  

function sendAJAXSOAP(operation, account){
	var xmlMes = createXMLMessage(operation, account);
	if(showMessages == 1){
		console.log("SOAP response: " + xmlMes);
	}
	$.ajax({
	  method: "POST",
	  url: "http://localhost:8080/WS_Ass_try3_war_exploded/AccountServiceService",
	  contentType: "text/xml; charset=utf-8",
	  dataType: "xml",
	  data: xmlMes,
	}).done(function( msg ) {
    	//console.log(msg);
    	parseResponse(msg, operation, account);
    	processResponse(1,operation);
  	}).fail(function( msg ){
  		//console.log(msg);
  		parseResponseError(msg.responseText);
  		processResponse(0,operation);
  	}).always(function(msg){
  		if(showMessages == 1){
			console.log("SOAP response: ");
			console.log(msg);
		}
  	});;
}

function parseResponse(xml, operation, account){
	if(xml != null && xml.nodeName != 'return'){
		parseResponse(xml.firstChild,operation, account);
	}
	else{	
		switch(operation){
			case "save":
				dataObject.name = account.name;
				dataObject.password = account.password;
			break;
			case "delete":
				dataObject = new Object();
			break;
			default:
				dataObject.id = xml.childNodes[0].firstChild.data;
				dataObject.name = xml.childNodes[1].firstChild.data;
				dataObject.password = xml.childNodes[2].firstChild.data;
			break;
		}
		//console.log(dataObject);
	}
}

function parseResponseError(msg){
	var arrBuf1 = msg.split("<faultstring>");
	var error = arrBuf1[1].split("</faultstring>");
	switch(error[0]){
		case "model.exceptions.AccountDoesNotExistException":
			alert("Account does not exist");
		break;
		case "model.exceptions.AccountNameExistsException":
			alert("This username is taken");
		break;
		case "model.exceptions.AccountVerificationException":
			alert("Wrong username or password");
		break;
		case "model.exceptions.InvalidAccountParameterException":
			alert("Wrong account parameter");
		break;
		default:
			alert(error[0]);
		break;
	}
}

function createXMLMessage(operation, account){
	var id = -1;
	var name = "user1";
	var password = "user1";

	var start = "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
				"<S:Body><ns2:"+operation+" xmlns:ns2=\"http://service/\">";

	var args ="<arg0><id>"+account.id+"</id><name>"+account.name+"</name><password>"+account.password+"</password></arg0>";

	var end = "</ns2:"+operation+"></S:Body></S:Envelope>";
	return start + args + end;
}  