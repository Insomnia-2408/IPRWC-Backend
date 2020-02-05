package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Product {

    private String name;
    private long id;
    private ProductType productType;
    private long amount;
    private String imagePath;

    @JsonCreator
    public Product(
            @JsonProperty("name") String name,
            @JsonProperty("id") long id,
            @JsonProperty("product_type") ProductType productType,
            @JsonProperty("amount") long amount,
            @JsonProperty("image_path") String imagePath
    )
    {
        this.name = name;
        this.id = id;
        this.productType = productType;
        this.amount = amount;
        this.imagePath = imagePath;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }

    @JsonProperty
    @NotNull
    public long getId() {
        return this.id;
    }

    @JsonProperty
    @NotNull
    public ProductType getProductType() {
        return this.productType;
    }

    @JsonProperty
    public long getAmount() {
        return this.amount;
    }

    @JsonProperty
    public String getImagePath() { return this. imagePath; }

}
