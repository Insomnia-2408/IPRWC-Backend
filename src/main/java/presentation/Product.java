package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Product {

    private long id;
    private ProductType productType;
    private long amount;

    @JsonCreator
    public Product(
            @JsonProperty("id") long id,
            @JsonProperty("product_type") ProductType productType,
            @JsonProperty("amount") long amount
    )
    {
        this.id = id;
        this.productType = productType;
        this.amount = amount;
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

}
