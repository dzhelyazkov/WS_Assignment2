package service;

import com.sun.istack.internal.NotNull;
import model.Account;
import model.AccountManager;
import model.AccountManagerFactory;
import model.exceptions.AccountDoesNotExistException;
import model.exceptions.AccountNameExistsException;
import model.exceptions.AccountVerificationException;
import model.exceptions.InvalidAccountParameterException;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
@WebService()
public class AccountService {

private static final AccountManager ACCOUNT_MANAGER = AccountManagerFactory.getInstance().getAccountManager(AccountManagerFactory.AccountManagerType.PERSISTENT);

    @WebMethod
    public Account register(@NotNull Account account) throws InvalidAccountParameterException, AccountNameExistsException {
        return ACCOUNT_MANAGER.createAccount(account);
    }

    @WebMethod
    public void save(@NotNull Account account) throws InvalidAccountParameterException, AccountNameExistsException, AccountDoesNotExistException {
        ACCOUNT_MANAGER.saveAccount(account);
    }

    @WebMethod
    public Account login(@NotNull Account account) throws AccountDoesNotExistException, AccountVerificationException {
        return ACCOUNT_MANAGER.verifyAccount(account);
    }

    @WebMethod
    public void delete(@NotNull Account account) throws AccountDoesNotExistException {
        ACCOUNT_MANAGER.deleteAccount(account);
    }
}
