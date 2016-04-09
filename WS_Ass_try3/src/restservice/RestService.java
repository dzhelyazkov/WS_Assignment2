package restservice;

import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import model.Account;
import model.AccountManager;
import model.AccountManagerFactory;
import model.exceptions.AccountDoesNotExistException;
import model.exceptions.AccountNameExistsException;
import model.exceptions.AccountVerificationException;
import model.exceptions.InvalidAccountParameterException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by Arkadiy on 4/9/2016.
 */
@Path("/rest")
public class RestService {

    private static final AccountManager ACCOUNT_MANAGER = AccountManagerFactory.getInstance().getAccountManager(AccountManagerFactory.AccountManagerType.PERSISTENT);

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Account register(@NotNull String input) throws InvalidAccountParameterException, AccountNameExistsException {
        Gson gson = new Gson();
        System.out.println(input);
        Account account = gson.fromJson(input, Account.class);
        return ACCOUNT_MANAGER.createAccount(account);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(@NotNull String input) throws InvalidAccountParameterException, AccountNameExistsException, AccountDoesNotExistException {
        Gson gson = new Gson();
        System.out.println(input);
        Account account = gson.fromJson(input, Account.class);
        ACCOUNT_MANAGER.saveAccount(account);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Account login(@NotNull String input) throws AccountDoesNotExistException, AccountVerificationException {
        Gson gson = new Gson();
        System.out.println(input);
        Account account = gson.fromJson(input, Account.class);
        return ACCOUNT_MANAGER.verifyAccount(account);
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@NotNull String input) throws AccountDoesNotExistException {
        Gson gson = new Gson();
        System.out.println(input);
        Account account = gson.fromJson(input, Account.class);
        ACCOUNT_MANAGER.deleteAccount(account);
    }

}
