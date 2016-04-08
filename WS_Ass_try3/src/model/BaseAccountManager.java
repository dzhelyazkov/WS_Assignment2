package model;

import model.exceptions.AccountDoesNotExistException;
import model.exceptions.AccountNameExistsException;
import model.exceptions.AccountVerificationException;
import model.exceptions.InvalidAccountParameterException;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
class BaseAccountManager implements AccountManager {
    private static final Pattern NOT_EMPTY_STRING = Pattern.compile(".*\\S.*");

    protected final Map<Integer, Account> accounts = Collections.synchronizedMap(new LinkedHashMap<>());
    private final Map<String, Integer> accountIDs = Collections.synchronizedMap(new HashMap<>());
    protected int lastID = 0;

    @Override
    public Account createAccount(Account account) throws InvalidAccountParameterException, AccountNameExistsException {
        validateAccountParameters(account);
        checkIfNameIsFree(account.getName());

        Account newAccount = account.clone();
        lastID++;
        newAccount.setId(lastID);

        addAccount(newAccount);
        return newAccount.clone();
    }

    @Override
    public Account verifyAccount(Account account) throws
            AccountDoesNotExistException, AccountVerificationException {

        Account savedAccount = getAccountByName(account.getName());
        if (!savedAccount.getPassword().equals(account.getPassword()))
            throw new AccountVerificationException();

        return savedAccount.clone();
    }

    @Override
    public void saveAccount(Account account) throws
            AccountDoesNotExistException,
            InvalidAccountParameterException,
            AccountNameExistsException {

        validateAccountParameters(account);
        Integer id = account.getId();
        Account savedAccount = getAccountByID(id);

        String newName = account.getName();
        if (!savedAccount.getName().equals(newName)) {
            checkIfNameIsFree(newName);
            accountIDs.remove(savedAccount.getName());
            accountIDs.put(newName, id);
            savedAccount.setName(newName);
        }

        savedAccount.setPassword(account.getPassword());
    }

    @Override
    public void deleteAccount(Account account) throws AccountDoesNotExistException {

        Integer id = account.getId();
        Account savedAccount = getAccountByID(id);
        accounts.remove(id);
        accountIDs.remove(savedAccount.getName());
    }

    private void checkIfNameIsFree(String name) throws AccountNameExistsException {

        try {
            getAccountByName(name);
            throw new AccountNameExistsException();
        } catch (AccountDoesNotExistException e) {
        }
    }

    private Account getAccountByID(Integer id) throws AccountDoesNotExistException {
        Account account = null;
        try {
            account = accounts.get(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (account == null)
            throw new AccountDoesNotExistException();

        return account;
    }

    private Account getAccountByName(String name) throws AccountDoesNotExistException {
        Integer id = null;
        try {
            id = accountIDs.get(name);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (id == null)
            throw new AccountDoesNotExistException();
        return getAccountByID(id);
    }

    protected void validateAccountParameters(Account account) throws InvalidAccountParameterException {
        String[] stringsForValidation = {account.getName(), account.getPassword()};
        for (String string : stringsForValidation)
            if ((string == null) || !NOT_EMPTY_STRING.matcher(string).matches())
                throw new InvalidAccountParameterException(string);

    }

    protected void addAccount(Account account) {
        Integer id = account.getId();
        accounts.put(id, account);
        accountIDs.put(account.getName(), id);
    }

}
