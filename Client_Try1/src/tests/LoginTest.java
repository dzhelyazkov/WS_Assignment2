package tests;

import org.junit.Assert;
import org.junit.Test;
import soap_client.Account;
import soap_client.AccountDoesNotExistFault;
import soap_client.AccountVerificationFault;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class LoginTest extends AbstractAccountServiceTest {
    @Test
    public void testLogin() throws Exception {
        Account account = new Account();
        account.setName(registeredAccount.getName());
        account.setPassword(registeredAccount.getPassword());
        account = ACCOUNT_SERVICE.login(account);
        Assert.assertEquals(account, registeredAccount);
    }

    @Test(expected = AccountVerificationFault.class)
    public void testLoginWithWrongPassword() throws Exception {
        Account account = new Account();
        account.setName(registeredAccount.getName());
        account.setPassword(super.generateInvalidString());
        ACCOUNT_SERVICE.login(account);
    }

    @Test(expected = AccountDoesNotExistFault.class)
    public void testLoginNotExistingUser() throws Exception {
        Account account = new Account();
        account.setName(super.generateInvalidString());
        account.setPassword(super.generateRandomString());
        ACCOUNT_SERVICE.login(account);
    }

}
