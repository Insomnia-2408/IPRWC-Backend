package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Bill {

    //Variables
    private int billID;
    private double price;
    private double btw;
    private double totalPrice;

    //JsonCreator
    @JsonCreator
    public Bill(
            @JsonProperty("bill_id") int billID,
            @JsonProperty("price") double price,
            @JsonProperty("btw") double btw,
            @JsonProperty("total_price") double totalPrice
    ) {

        this.billID = billID;
        this.price = price;
        this.btw = btw;
        this.totalPrice = totalPrice;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
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
    @NotNull
    public double getBtw() {
        return btw;
    }

    public void setBtw(double btw) {
        this.btw = btw;
    }

    @JsonProperty
    @NotNull
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
