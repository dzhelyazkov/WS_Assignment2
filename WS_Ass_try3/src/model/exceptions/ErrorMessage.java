package model.exceptions;

/**
 * Created by Arkadiy on 4/9/2016.
 */
public class ErrorMessage {
    private String error;

    public ErrorMessage(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }
}
