package service;

import persistence.CarDAO;
import presentation.Car;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class CarService implements Service<Car> {

    private final CarDAO carDAO;

    @Inject
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List list() {
        return carDAO.list();
    }

    public Car getByID(long id) {
        return carDAO.getByID(id);
    }

    public Response create(Car car) {
        long id = carDAO.getHighestID() + 1;
        car.setId(id);

        if(carDAO.create(car)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response update(Car car) {
        if(carDAO.update(car)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response deleteByID(long id) {
        if(carDAO.deleteByID(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}