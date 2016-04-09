package tests;

import org.junit.Test;
import rest_client.RestClient;
import soap_client.Account;

/**
 * Created by Arkadiy on 4/9/2016.
 */
public class RestTestRegister{
    private Account account;

    public void testRegister() throws Exception{
        account = new Account();
        account.setId(1);
        account.setName(AbstractAccountServiceTest.generateValidString());
        account.setPassword(AbstractAccountServiceTest.generateValidString());
        RestClient rest = new RestClient(1);
        rest.runClient(account);
        account = rest.getResponse();
        System.out.println(account.toString());
    }

    public void testLogin() throws Exception{
        RestClient rest = new RestClient(3);
        rest.runClient(account);
        account = rest.getResponse();
        System.out.println(account.toString());
    }

    public void testEdit() throws Exception{
        account.setName(AbstractAccountServiceTest.generateValidString());
        RestClient rest = new RestClient(2);
        rest.runClient(account);
        System.out.println(account.toString());
    }

    public void testDelete() throws Exception{
        RestClient rest = new RestClient(4);
        rest.runClient(account);
        System.out.println(account.toString());
    }

    @Test
    public void testNormalFlow() throws Exception{
        testRegister();
        testLogin();
        testEdit();
        testDelete();
    }
}
