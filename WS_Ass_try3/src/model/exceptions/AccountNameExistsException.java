package model.exceptions;

import java.io.Serializable;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class AccountNameExistsException extends Exception implements Serializable {

    public AccountNameExistsException() {
        super();
    }

    public AccountNameExistsException(String msg) {
        super(msg);
    }

    public AccountNameExistsException(String msg, Exception e) {
        super(msg, e);
    }

}
