package tests;

import org.junit.After;
import org.junit.Assert;
import soap_client.*;

import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public abstract class AbstractAccountServiceTest {

    protected static final AccountService ACCOUNT_SERVICE = new AccountServiceService().getPort(AccountService.class);
    private static final String[] INVALID_STRINGS = {",", "\n"};
    protected static final Random RANDOM = new Random();
    private static final Iterator<Integer> INVALID_STRs_IXs = RANDOM.ints(0, INVALID_STRINGS.length).iterator();

    protected final Account registeredAccount = this.registerAccount();

    @After
    public void tearDown(){
        try {
            ACCOUNT_SERVICE.delete(registeredAccount);
        } catch (AccountDoesNotExistFault accountDoesNotExistFault) {
            //accountDoesNotExistFault.printStackTrace();
        }
    }

    protected static String generateInvalidString() {
        if (RANDOM.nextBoolean())
            return null;
        if (RANDOM.nextBoolean())
            return "";

        String str = generateRandomString();
        str += INVALID_STRINGS[INVALID_STRs_IXs.next()];
        return str;
    }

    protected static String generateValidString() {
        String str = generateRandomString();
        for (String invalidStr : INVALID_STRINGS)
            str = str.replaceAll(invalidStr, "");

        return str;
    }

    protected static String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    protected Account registerAccount() {
        Account account = new Account();
        account.setName(generateValidString());
        account.setPassword(generateValidString());
        try {
            account = ACCOUNT_SERVICE.register(account);
        } catch (AccountNameExistsFault accountNameExistsFault) {
            accountNameExistsFault.printStackTrace();
        } catch (InvalidAccountParameterFault invalidAccountParameterFault) {
            invalidAccountParameterFault.printStackTrace();
        }
        Assert.assertNotNull(account);
        return account;
    }
}
