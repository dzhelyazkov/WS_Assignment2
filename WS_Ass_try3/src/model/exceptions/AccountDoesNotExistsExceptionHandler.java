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
public class AccountDoesNotExistsExceptionHandler implements ExceptionMapper<AccountDoesNotExistException> {

    @Override
    public Response toResponse(AccountDoesNotExistException e) {
        return Response.status(ClientResponse.Status.BAD_REQUEST).entity(new ErrorMessage(e.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }
}
