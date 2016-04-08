package model.exceptions;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class InvalidAccountParameterException extends Exception {

    public InvalidAccountParameterException(String string) {
        super("Invalid parameter value: " + string);
    }
}
