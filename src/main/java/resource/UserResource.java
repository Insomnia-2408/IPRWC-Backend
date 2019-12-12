package resource;

import presentation.User;
import presentation.UserRole;
import service.AuthenticationService;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Path("/users")
public class UserResource implements Resource<User> {

    private final UserService service;
    private final AuthenticationService authentication;

    @Inject
    public UserResource(UserService userService, AuthenticationService authentication) {
        this.service = userService;
        this.authentication = authentication;
    }

    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public List index(@PathParam("token") String token) {
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.list();
        } else {
            return null;
        }
    }

    @GET
    @Path("/{token}/{client_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getByID(@PathParam("token") String token, @PathParam("client_id") long id) {
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.getByID(id);
        } else {
            return null;
        }
    }

    @POST
    @Path("/{token}")
    public Response post(@PathParam("token") String token, User user) throws NoSuchAlgorithmException {
        return service.create(user);
    }

    @PUT
    @Path("/{token}")
    public Response put(@PathParam("token") String token, User user) {
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.update(user);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @DELETE
    @Path("/{token}")
    public Response delete(@PathParam("token") String token, long id) {
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.deleteByID(id);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}