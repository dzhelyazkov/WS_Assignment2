package model.exceptions;

import java.io.Serializable;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class AccountDoesNotExistException extends Exception implements Serializable {

    public AccountDoesNotExistException() {
        super();
    }

    public AccountDoesNotExistException(String msg) {
        super(msg);
    }

    public AccountDoesNotExistException(String msg, Exception e) {
        super(msg, e);
    }
}
