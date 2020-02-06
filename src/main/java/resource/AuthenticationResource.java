package resource;

import presentation.Credentials;
import service.AuthenticationService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;

@Path("/auth")
public class AuthenticationResource {

    private final AuthenticationService service;

    @Inject
    public AuthenticationResource(AuthenticationService authenticationService) {
        this.service = authenticationService;
    }

    @GET
    @Path("/getThisUser")
    public Response getThisUser(@HeaderParam("token") String token) {
        return service.getThisUser(token);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response onLogin(@NotNull Credentials credentials) throws NoSuchAlgorithmException {
        return service.onLogin(credentials);
    }

    @DELETE
    @Path("/logout")
    public Response onLogout(@HeaderParam("token") @NotNull String token) {
        return service.onLogout(token);
    }

}
