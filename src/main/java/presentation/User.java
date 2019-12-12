package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

public class User implements Principal {

    //Variables
    private int clientID;
    private String name;
    private String email;
    private String password;
    private String address;
    private List<Order> orders;
    private List<ServiceForCar> carServices;
    private List<Bill> bills;
    private UserRole userRole;

    //JsonCreator
    @JsonCreator
    public User(
            @JsonProperty("client_ID") int clientID,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("address") String address,
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("carServices") List<ServiceForCar> carServices,
            @JsonProperty("bills") List<Bill> bills,
            @JsonProperty("user_role") UserRole userRole
    ) {

        this.clientID = clientID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.orders = orders;
        this.carServices = carServices;
        this.bills = bills;
        this.userRole = userRole;

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
    @NotNull
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public List<ServiceForCar> getCarServices() {
        return carServices;
    }

    public void setCarServices(List<ServiceForCar> carServices) {
        this.carServices = carServices;
    }

    @JsonProperty
    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @JsonProperty
    @NotNull
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
