package model;

import model.exceptions.InvalidAccountParameterException;
import tools.CSVTool;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by XRC_7331 on 4/9/2016.
 */
class CSVBaseAccountManager extends BaseAccountManager {
    private static final Path ACCOUNTS_FILE = Paths.get("accounts.csv");
    private static final int SAVE_INTERVAL = 10000;

    private static CSVBaseAccountManager ourInstance = null;

    public static CSVBaseAccountManager getInstance() {
        if (ourInstance == null)
            ourInstance = new CSVBaseAccountManager();
        return ourInstance;
    }


    private final CSVTool CSV_TOOL = CSVTool.getInstance();

    private CSVBaseAccountManager() {
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

    @Override
    protected void validateAccountParameters(Account account) throws InvalidAccountParameterException {
        super.validateAccountParameters(account);
        String[] stringsForValidation = {account.getName(), account.getPassword()};
        for (String string : stringsForValidation) {
            if (!CSVTool.DATA_FORMAT.matcher(string).matches())
                throw new InvalidAccountParameterException(string);

        }
    }

    private void loadAccounts() {
        try {
            List<String[]> data = CSV_TOOL.readCSV(ACCOUNTS_FILE);
            for (String[] dataLine : data) {
                super.lastID = Integer.parseInt(dataLine[0]);
                Account account = new Account(super.lastID, dataLine[1], dataLine[2]);
                super.addAccount(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAccounts() {
        List<String[]> data = new LinkedList<>();
        for (Account account : super.accounts.values()) {
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
