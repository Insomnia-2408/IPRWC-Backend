package resource;

import presentation.UserRole;
import service.AuthenticationService;
import service.ShoppingcartService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Path("/shoppingcart")
public class ShoppingcartResource {

    private final ShoppingcartService service;
    private final AuthenticationService authentication;

    @Inject
    public ShoppingcartResource(ShoppingcartService service, AuthenticationService authentication) {
        this.service = service;
        this.authentication = authentication;
    }

    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getByID(@PathParam("token") String token) {
        if(authentication.isAuthorized(token, UserRole.CUSTOMER)) {
            return service.getCart(authentication.checkToken(token));
        } else {
            return null;
        }
    }

    @PUT
    @Path("/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@PathParam("token") String token, Object object) {
        if(authentication.isAuthorized(token, UserRole.CUSTOMER)) {
            return service.add(object);
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Path("/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("token") String token, Object object) {
        if(authentication.isAuthorized(token, UserRole.CUSTOMER)) {
            return service.delete(object);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
