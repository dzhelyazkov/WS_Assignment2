var dataObject = null;
var errorObject = null;
var method = null;
var logged = 0;
var registerFlag = 0;
var statusString;

$(document).ready(function(){ 
	checkUI();
	$("#reg_link").click(function(){
		registerFlag = 1;
		checkUI();
	});
});

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
		alert("Wrong username!");
		return -1;
	}
	if(account.password.match(/\n|,/)){
		alert("Wrong password!");
		return -2;
	}
	return 0;
}

function isFieldsEmpty(account){
	if(account.name.length == 0 || account.password.length == 0){
		alert("Epty fields");
		return 1;
	}
	return 0;
}

function sendAJAXREST(operation, account){
	var status = 0;
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
    	console.log("DONE");
    	status = 1;
    	processResponse(status,operation);
  	}).fail(function( msg ){
  		dataObject = null;
  		alert(msg.responseJSON.error);
  		processResponse(status,operation);
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

	}
	else{
		sendAJAXREST(operation, account)
	}
}