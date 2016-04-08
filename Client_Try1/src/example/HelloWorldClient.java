package example;

import client.*;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
    AccountService service = new AccountServiceService().getPort(AccountService.class);
    //invoke business method
    //service.register();
    Account account = new Account();
    account.setName(",");
    account.setPassword("123");
    try {
      service.register(account);
    } catch (AccountNameExistsException_Exception e) {
      e.printStackTrace();
    } catch (InvalidAccountParameterException_Exception e) {
      e.printStackTrace();
    }
  }
}
