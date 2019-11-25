package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class User {

    //Variables
    private int clientID;
    private String name;
    private String email;
    private String address;
    private List<Order> orders;
    private List<CarService> carServices;
    private List<Bill> bills;

    //JsonCreator
    @JsonCreator
    public User(
            @JsonProperty("clientID") int clientID,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("address") String address,
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("carServices") List<CarService> carServices,
            @JsonProperty("bills") List<Bill> bills
    ) {

        this.clientID = clientID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.orders = orders;
        this.carServices = carServices;
        this.bills = bills;

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
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @JsonProperty
    public List<CarService> getCarServices() {
        return carServices;
    }

    public void setCarServices(List<CarService> carServices) {
        this.carServices = carServices;
    }

    @JsonProperty
    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
