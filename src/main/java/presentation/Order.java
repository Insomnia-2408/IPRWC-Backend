package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Order {

    //Variables
    private long orderID;
    private List<Object> products;
    private long billID;
    private long clientID;
    private Date orderDate;
    private Date deliverDate;

    //JsonCreator
    @JsonCreator
    public Order(
            @JsonProperty("order_id") long orderID,
            @JsonProperty("products") List<Object> products,
            @JsonProperty("bill_id") long billID,
            @JsonProperty("client_id") long clientID,
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
    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
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
    public long getBillID() {
        return billID;
    }

    public void setBillID(long billID) {
        this.billID = billID;
    }

    @JsonProperty
    @NotNull
    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
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
