package model.exceptions;

import java.io.Serializable;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class AccountVerificationException extends Exception implements Serializable {

    public AccountVerificationException() {
        super();
    }

    public AccountVerificationException(String msg) {
        super(msg);
    }

    public AccountVerificationException(String msg, Exception e) {
        super(msg, e);
    }

}
