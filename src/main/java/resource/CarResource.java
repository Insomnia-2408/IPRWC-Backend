package resource;

import presentation.Car;
import service.CarService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public class CarResource implements Resource {

    private final CarService service;

    @Inject
    public CarResource(CarService service) {
        this.service = service;
    }

    @GET
    public List index() {
        return service.list();
    }

    @PUT
    public Car post() {
        return service.update();
    }

    @GET
    @Path("/{id}")
    public Car getByID(@PathParam("id") long id) {
        return service.getByID(id);
    }

    public Car put() {
        return null;
    }

    public Car delete() {
        return null;
    }
}
