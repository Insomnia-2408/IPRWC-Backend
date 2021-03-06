package resource;

import presentation.Product;
import presentation.UserRole;
import service.AuthenticationService;
import service.ShoppingcartService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Object getByID(@HeaderParam("token") String token) {
        if(authentication.isAuthorized(token, UserRole.USER)) {
            return service.getCart(authentication.checkToken(token));
        } else {
            return null;
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@HeaderParam("token") String token, Product product) {
        if(authentication.isAuthorized(token, UserRole.USER)) {
            return service.add(authentication.checkToken(token), product);
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@HeaderParam("token") String token, Product product) {
        if(authentication.isAuthorized(token, UserRole.USER)) {
            return service.delete(authentication.checkToken(token), product);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
