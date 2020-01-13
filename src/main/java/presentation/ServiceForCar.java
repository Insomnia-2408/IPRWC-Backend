package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ServiceForCar {

    //Variables
    private long carServiceID;
    private String description;
    private double price;

    //JsonCreator
    @JsonCreator
    public ServiceForCar(
            @JsonProperty("car_service_id") long carServiceID,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price
    ) {

        this.carServiceID = carServiceID;
        this.description = description;
        this.price = price;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public long getCarServiceID() {
        return carServiceID;
    }

    public void setCarServiceID(long carServiceID) {
        this.carServiceID = carServiceID;
    }

    @JsonProperty
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
