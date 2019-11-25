package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Lamp {

    //Variables
    private int lampID;
    private List<String> compatibleWith;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Lamp(
            @JsonProperty("lampID") int lampID,
            @JsonProperty("compatibleWith") List<String> compatibleWith,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("imagePath") String imagePath
    ) {

        this.lampID = lampID;
        this.compatibleWith = compatibleWith;
        this.stock = stock;
        this.price = price;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getLampID() {
        return lampID;
    }

    public void setLampID(int lampID) {
        this.lampID = lampID;
    }

    @JsonProperty
    @NotNull
    public List<String> getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(List<String> compatibleWith) {
        this.compatibleWith = compatibleWith;
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
