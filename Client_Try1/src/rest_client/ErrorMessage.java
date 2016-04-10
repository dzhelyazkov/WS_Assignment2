package rest_client;

/**
 * Created by Arkadiy on 4/9/2016.
 */
public class ErrorMessage {
    protected String error;

    public ErrorMessage(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String msg){
        this.error = msg;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "error='" + error + '\'' +
                '}';
    }
}
