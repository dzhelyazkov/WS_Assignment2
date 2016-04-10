package rest_client;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import soap_client.Account;
import soap_client.InvalidAccountParameterException;

/**
 * Created by Arkadiy on 4/9/2016.
 */
public class RestClient {

    private Client client;
    private WebResource webResource;
    private Account responseAccount;
    private int clientType;

    public RestClient(int type) {
        clientType = type;
        String name = "";
        switch (clientType) {
            case 1:
                name = "register";
                break;
            case 2:
                name = "save";
                break;
            case 3:
                name = "login";
                break;
            case 4:
                name = "delete";
                break;
        }
        this.client = Client.create();

        this.webResource = client
                .resource("http://localhost:8080/WS_Ass_try3_war_exploded/restService/rest/" + name);
    }

    public void runClient(Account account){

        try {
            Gson gson = new Gson();
            String input = gson.toJson(account);
            System.out.println(input);
            //"{\"id\":\"" + 1 + "\",\"name\":\"" + account.getName() + "\",\"password\":\"" + account.getPassword() + "\"}";

            ClientResponse response = this.webResource.type("application/json")
                    .post(ClientResponse.class, input);


            if (response.getStatus() != 200 && response.getStatus() != 204) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus() + "\n" + response.getEntity(String.class));
            }

            System.out.println("Output from Server .... ");
            if(clientType == 1 || clientType == 3) {
                this.responseAccount = response.getEntity(Account.class);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public Account getResponse() {
        return this.responseAccount;
    }

}
