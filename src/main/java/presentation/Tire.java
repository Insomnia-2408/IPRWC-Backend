package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Tire {

    //Enums
    public enum TireType {

        ALL_SEASON, TOURING, PERFORMANCE, SUMMER, TRACK_COMPETITION, ALL_TERRAIN, WINTER

    }

    //Variables
    private long tireID;
    private ProductType productType = ProductType.TIRE;
    private TireType tireType;
    private String description;
    private int stock;
    private double price;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Tire(
            @JsonProperty("tire_id") long tireID,
            @JsonProperty("tire_type") TireType tireType,
            @JsonProperty("description") String description,
            @JsonProperty("stock") int stock,
            @JsonProperty("price") double price,
            @JsonProperty("image_path") String imagePath
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
    public long getTireID() {
        return tireID;
    }

    public void setTireID(long tireID) {
        this.tireID = tireID;
    }

    public ProductType getProductType() {
        return this.productType;
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
