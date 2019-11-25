package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CarService {

    //Variables
    private int carServiceID;
    private String description;
    private double price;

    //JsonCreator
    @JsonCreator
    public CarService(
            @JsonProperty("carServiceID") int carServiceID,
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
    public int getCarServiceID() {
        return carServiceID;
    }

    public void setCarServiceID(int carServiceID) {
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
