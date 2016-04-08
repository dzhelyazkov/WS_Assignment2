package model;

import model.exceptions.AccountDoesNotExistException;
import model.exceptions.AccountNameExistsException;
import model.exceptions.AccountVerificationException;
import model.exceptions.InvalidAccountParameterException;

/**
 * Created by XRC_7331 on 4/9/2016.
 */
public interface AccountManager {
    Account createAccount(Account account) throws InvalidAccountParameterException, AccountNameExistsException;

    Account verifyAccount(Account account) throws
            AccountDoesNotExistException, AccountVerificationException;

    public void saveAccount(Account account) throws
            AccountDoesNotExistException,
            InvalidAccountParameterException,
            AccountNameExistsException;

    public void deleteAccount(Account account) throws AccountDoesNotExistException;
}
