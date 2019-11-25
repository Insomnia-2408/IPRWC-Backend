package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Rim {

    //Variables
    private int rimID;
    private String size;
    private List<String> compatibleWith;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Rim(
            @JsonProperty("rimID") int rimID,
            @JsonProperty("size") String size,
            @JsonProperty("compatibleWith") List<String> compatibleWith,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("imagePath") String imagePath
    ) {

        this.rimID = rimID;
        this.size = size;
        this.compatibleWith = compatibleWith;
        this.stock = stock;
        this.price = price;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getRimID() {
        return rimID;
    }

    public void setRimID(int rimID) {
        this.rimID = rimID;
    }

    @JsonProperty
    @NotNull
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
