package model;

/**
 * Created by XRC_7331 on 4/9/2016.
 */
public class AccountManagerFactory {
    private static AccountManagerFactory ourInstance = new AccountManagerFactory();

    public static AccountManagerFactory getInstance() {
        return ourInstance;
    }

    private AccountManagerFactory() {
    }

    public AccountManager getAccountManager(AccountManagerType managerType) {
        AccountManager result = null;
        switch (managerType) {

            case MEMORY:
                result = new BaseAccountManager();
                break;
            case PERSISTENT:
                result = CSVBaseAccountManager.getInstance();
                break;
        }
        return result;
    }

    public enum AccountManagerType {
        MEMORY,
        PERSISTENT
    }
}
