package model.exceptions;

import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Arkadiy on 4/9/2016.
 */
@Provider
public class AccountVerificationExceptionHandler implements ExceptionMapper<AccountVerificationException> {
    @Override
    public Response toResponse(AccountVerificationException e) {
        return Response.status(ClientResponse.Status.BAD_REQUEST).entity(new ErrorMessage("Verification problems")).type(MediaType.APPLICATION_JSON).build();
    }
}
