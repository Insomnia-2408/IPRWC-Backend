package resource;

import presentation.Car;
import service.CarService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class CarResource implements Resource<Car> {

    private final CarService service;

    @Inject
    public CarResource(CarService service) {
        this.service = service;
    }

    @GET
    public List index() {
        return service.list();
    }

    @GET
    @Path("/{id}")
    public Car getByID(@PathParam("id") long id) {
        return service.getByID(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Car car) {
        return service.post(car);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(Car car) {
        return service.update(car);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        return service.deleteByID(id);
    }
}
