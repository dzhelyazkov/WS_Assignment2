package tests;

import org.junit.Test;
import soap_client.Account;
import soap_client.AccountDoesNotExistFault;
import soap_client.AccountNameExistsFault;
import soap_client.InvalidAccountParameterFault;

/**
 * Created by XRC_7331 on 4/9/2016.
 */
public class SaveTest extends AbstractAccountServiceTest {

    @Test
    public void testSave() throws Exception {
        if (RANDOM.nextBoolean()) {
            registeredAccount.setName(super.generateValidString());
            if (RANDOM.nextBoolean())
                registeredAccount.setPassword(super.generateValidString());
        } else {
            registeredAccount.setPassword(super.generateValidString());
        }

        ACCOUNT_SERVICE.save(registeredAccount);
    }

    @Test(expected = InvalidAccountParameterFault.class)
    public void testSaveWithInvalidParameter() throws Exception {
        if (RANDOM.nextBoolean()) {
            registeredAccount.setName(super.generateInvalidString());
            if (RANDOM.nextBoolean())
                registeredAccount.setPassword(super.generateInvalidString());
        } else {
            registeredAccount.setPassword(super.generateInvalidString());
        }

        ACCOUNT_SERVICE.save(registeredAccount);
    }

    @Test(expected = AccountNameExistsFault.class)
    public void testSaveWithExistingName() throws Exception {
        Account existingAccount = super.registerAccount();
        registeredAccount.setName(existingAccount.getName());
        try {
            ACCOUNT_SERVICE.save(registeredAccount);
        } finally {
            ACCOUNT_SERVICE.delete(existingAccount);
        }
    }

    @Test(expected = AccountDoesNotExistFault.class)
    public void testSaveOnNonExistingAccount() throws Exception {
        Account account = new Account();
        account.setName(super.generateValidString());
        account.setPassword(super.generateValidString());
        ACCOUNT_SERVICE.save(account);
    }
}
