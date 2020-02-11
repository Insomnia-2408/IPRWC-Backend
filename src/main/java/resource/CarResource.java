package resource;

import presentation.Car;
import presentation.UserRole;
import service.AuthenticationService;
import service.CarService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cars")
public class CarResource implements Resource<Car> {

    private final CarService service;
    private final AuthenticationService authentication;

    @Inject
    public CarResource(CarService carService, AuthenticationService authentication) {
        this.service = carService;
        this.authentication = authentication;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List index() {
        return service.list();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Car getByID(@HeaderParam("token") String token, @PathParam("id") long id) {
        return service.getByID(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(@HeaderParam("token") String token, Car car) {
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.create(car);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@HeaderParam("token") String token, Car car) {
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.update(car);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@HeaderParam("token") String token, @PathParam("id") long id) {
        System.out.println(token);
        if(authentication.isAuthorized(token, UserRole.ADMIN)) {
            return service.deleteByID(id);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
