package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Shoppingcart {

    //Variables
    private int clientID;
    private List<Object> products;
    private double price;

    //JsonCreator
    @JsonCreator
    public Shoppingcart(
            @JsonProperty("clientID") int clientID,
            @JsonProperty("products") List<Object> products,
            @JsonProperty("price") double price
    ) {

        this.clientID = clientID;
        this.products = products;
        this.price = price;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    @JsonProperty
    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }

    @JsonProperty
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
