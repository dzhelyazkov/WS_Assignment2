package tests;

import org.junit.Test;
import soap_client.Account;
import soap_client.AccountNameExistsFault;
import soap_client.InvalidAccountParameterFault;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class RegisterTest extends AbstractAccountServiceTest {

    @Test
    public void testRegister() throws Exception {
        Account account = super.registerAccount();
        System.out.printf("Account registered: %s\n", account);
        ACCOUNT_SERVICE.delete(account);
    }

    @Test(expected = InvalidAccountParameterFault.class)
    public void testRegisterWithInvalidParameter() throws Exception {
        String name;
        String password;
        if (RANDOM.nextBoolean()) {
            name = super.generateInvalidString();
            password = super.generateValidString();
        } else {
            name = super.generateValidString();
            password = super.generateInvalidString();
        }

        Account account = new Account();
        account.setName(name);
        account.setPassword(password);
        ACCOUNT_SERVICE.register(account);
    }

    @Test(expected = AccountNameExistsFault.class)
    public void testRegisterWithExistingName() throws Exception {
        Account account = new Account();
        account.setName(registeredAccount.getName());
        account.setPassword(super.generateValidString());
        ACCOUNT_SERVICE.register(account);
    }


}