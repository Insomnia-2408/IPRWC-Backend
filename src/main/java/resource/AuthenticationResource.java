package resource;

import presentation.Credentials;
import service.AuthenticationService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthenticationResource {

    private final AuthenticationService service;

    @Inject
    public AuthenticationResource(AuthenticationService authenticationService) {
        this.service = authenticationService;
    }

    @GET
    @Path("/login/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response onLogin(@NotNull Credentials credentials) {
        return service.onLogin(credentials);
    }

}
