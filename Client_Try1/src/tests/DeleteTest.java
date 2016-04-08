package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import soap_client.AccountDoesNotExistFault;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteTest extends AbstractAccountServiceTest {

    @Test
    public void testDelete() throws Exception {
        ACCOUNT_SERVICE.delete(registeredAccount);
    }

    @Test(expected = AccountDoesNotExistFault.class)
    public void testDeleteNonExistingAccount() throws Exception {
        ACCOUNT_SERVICE.delete(registeredAccount);
        ACCOUNT_SERVICE.delete(registeredAccount);
    }
}
