package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Order {

    //Variables
    private int orderID;
    private List<Object> products;
    private int billID;
    private int clientID;
    private Date orderDate;
    private Date deliverDate;

    //JsonCreator
    @JsonCreator
    public Order(
            @JsonProperty("orderID") int orderID,
            @JsonProperty("products") List<Object> products,
            @JsonProperty("billID") int billID,
            @JsonProperty("clientID") int clientID,
            @JsonProperty("orderDate") Date orderDate,
            @JsonProperty("deliverDate") Date deliverDate
    ) {

        this.orderID = orderID;
        this.products = products;
        this.billID = billID;
        this.clientID = clientID;
        this.orderDate = orderDate;
        this.deliverDate = deliverDate;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @JsonProperty
    @NotNull
    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }

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
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    @JsonProperty
    @NotNull
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @JsonProperty
    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
}
