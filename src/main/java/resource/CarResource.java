package resource;

import presentation.Car;
import presentation.CarService;

import javax.inject.Inject;
import java.util.List;

public class CarResource implements Resource {

    private final CarService service;

    @Inject
    public CarResource(CarService service) {
        this.service = service;
    }

    public List index() {
        return null;
    }

    public Car post() {
        return null;
    }

    public Car get() {
        return null;
    }

    public Car put() {
        return null;
    }

    public Car delete() {
        return null;
    }
}
