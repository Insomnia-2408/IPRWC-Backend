package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Radio {

    //Enums
    public enum RadioSize {

        SINGLE_DIN, ONE_AND_A_HALF_DIN, DOUBLE_DIN;

    }

    //Variables
    private int radioID;
    private RadioSize radioSize;
    private String features;
    private String description;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Radio(
            @JsonProperty("radio_id") int radioID,
            @JsonProperty("radio_size") RadioSize radioSize,
            @JsonProperty("features") String features,
            @JsonProperty("description") String description,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("image_path") String imagePath
    ) {

        this.radioID = radioID;
        this.radioSize = radioSize;
        this.features = features;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getRadioID() {
        return radioID;
    }

    public void setRadioID(int radioID) {
        this.radioID = radioID;
    }

    @JsonProperty
    @NotNull
    public RadioSize getRadioSize() {
        return radioSize;
    }

    public void setRadioSize(RadioSize radioSize) {
        this.radioSize = radioSize;
    }

    @JsonProperty
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
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
