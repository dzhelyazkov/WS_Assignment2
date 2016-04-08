package model;

import model.exceptions.AccountDoesNotExistException;
import model.exceptions.AccountNameExistsException;
import model.exceptions.AccountInvalidException;
import model.exceptions.AccountVerificationException;
import tools.CSVTool;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class AccountManager {
    private static final Pattern NOT_EMPTY_STRING = Pattern.compile(".*\\S.*");
    private static final Path ACCOUNTS_FILE = Paths.get("accounts.csv");
    private static final int SAVE_INTERVAL = 10000;

    private static AccountManager ourInstance = null;

    public static AccountManager getInstance() {
        if (ourInstance == null)
            ourInstance = new AccountManager(false);
        return ourInstance;
    }

    public static AccountManager getInstance(boolean memoryBase) {
        return new AccountManager(memoryBase);
    }

    private final CSVTool CSV_TOOL = CSVTool.getInstance();
    private final Map<Integer, Account> accounts = Collections.synchronizedMap(new LinkedHashMap<>());
    private final Map<String, Integer> accountIDs = Collections.synchronizedMap(new HashMap<>());
    private int lastID = 0;

    private AccountManager(boolean memoryBase) {
        if (!memoryBase) {
            loadAccounts();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        saveAccounts();

                        try {
                            Thread.sleep(SAVE_INTERVAL);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }).start();
        }
    }

    public Account createAccount(Account account) throws AccountInvalidException, AccountNameExistsException {
        validateAccountParameters(account);
        checkIfNameIsFree(account.getName());

        Account newAccount = account.clone();
        lastID++;
        newAccount.setId(lastID);

        addAccount(newAccount);
        return newAccount.clone();
    }

    public Account verifyAccount(Account account) throws
            AccountDoesNotExistException, AccountVerificationException {

        Account savedAccount = getAccountByName(account.getName());
        if (!savedAccount.getPassword().equals(account.getPassword()))
            throw new AccountVerificationException();

        return savedAccount.clone();
    }

    public void saveAccount(Account account) throws
            AccountDoesNotExistException,
            AccountInvalidException,
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

    private void validateAccountParameters(Account account) throws AccountInvalidException {
        String[] stringsForValidation = {account.getName(), account.getPassword()};
        for (String string : stringsForValidation)
            if ((string == null)
                    || !NOT_EMPTY_STRING.matcher(string).matches()
                    || !CSVTool.DATA_FORMAT.matcher(string).matches())
                throw new AccountInvalidException();

    }

    private void addAccount(Account account) {
        Integer id = account.getId();
        accounts.put(id, account);
        accountIDs.put(account.getName(), id);
    }

    private void loadAccounts() {
        try {
            List<String[]> data = CSV_TOOL.readCSV(ACCOUNTS_FILE);
            for (String[] dataLine : data) {
                lastID = Integer.parseInt(dataLine[0]);
                Account account = new Account(lastID, dataLine[1], dataLine[2]);
                addAccount(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAccounts() {
        List<String[]> data = new LinkedList<>();
        for (Account account : accounts.values()) {
            String[] dataLine = new String[]{account.getId().toString(), account.getName(), account.getPassword()};
            data.add(dataLine);
        }

        try {
            CSV_TOOL.writeCSV(ACCOUNTS_FILE, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
