package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Tire {

    //Enums
    public enum TireType {

        ALL_SEASON("AS"), TOURING("T"), PERFORMANCE("P"), SUMMER("S"), TRACK_COMPETITION("TC"), ALL_TERRAIN("AT"), WINTER("W");

        private String tireType;

        TireType(String tireType) {
            this.tireType = tireType;
        }

        public String getTireType() {
            return tireType;
        }

    }

    //Variables
    private int tireID;
    private TireType tireType;
    private String description;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Tire(
            @JsonProperty("tireID") int tireID,
            @JsonProperty("tireType") TireType tireType,
            @JsonProperty("description") String description,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("imagePath") String imagePath
    ) {

        this.tireID = tireID;
        this.tireType = tireType;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getTireID() {
        return tireID;
    }

    public void setTireID(int tireID) {
        this.tireID = tireID;
    }

    @JsonProperty
    @NotNull
    public TireType getTireType() {
        return tireType;
    }

    public void setTireType(TireType tireType) {
        this.tireType = tireType;
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
