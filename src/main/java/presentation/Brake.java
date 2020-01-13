package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Brake {

    //Variables
    private long brakeID;
    private String description;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Brake(
            @JsonProperty("brake_id") long brakeID,
            @JsonProperty("description") String description,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("image_path") String imagePath
    ) {

        this.brakeID = brakeID;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public long getBrakeID() {
        return brakeID;
    }

    public void setBrakeID(long brakeID) {
        this.brakeID = brakeID;
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
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @JsonProperty
    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
