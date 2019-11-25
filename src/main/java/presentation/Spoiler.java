package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Spoiler {

    //Variables
    private int spoilerID;
    private List<String> compatibleWith;
    private String description;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Spoiler(
            @JsonProperty("spoilerID") int spoilerID,
            @JsonProperty("compatibleWith") List<String> compatibleWith,
            @JsonProperty("description") String description,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("imagePath") String imagePath
    ) {

        this.spoilerID = spoilerID;
        this.compatibleWith = compatibleWith;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getSpoilerID() {
        return spoilerID;
    }

    public void setSpoilerID(int spoilerID) {
        this.spoilerID = spoilerID;
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
