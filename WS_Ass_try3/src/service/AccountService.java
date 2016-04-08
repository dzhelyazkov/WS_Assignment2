package service;

import com.sun.istack.internal.NotNull;
import model.Account;
import model.AccountManager;
import model.exceptions.AccountNameExistsException;
import model.exceptions.InvalidAccountParameterException;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
@WebService()
public class AccountService {
    @WebMethod
    public Account register(@NotNull Account account) throws InvalidAccountParameterException, AccountNameExistsException {
        AccountManager accountManager = AccountManager.getInstance();
        return accountManager.createAccount(account);
    }
}
