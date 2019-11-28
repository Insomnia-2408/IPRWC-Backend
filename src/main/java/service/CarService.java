package service;

import persistence.CarDAO;
import presentation.Car;

import javax.inject.Inject;
import java.util.List;

public class CarService implements Service {

    private final CarDAO carDAO;

    @Inject
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List list() {
        return null;
    }

    public Car getByID(long id) {
        return null;
    }

    public Car deleteByID() {
        return null;
    }

    public Car update() {
        return null;
    }
}
