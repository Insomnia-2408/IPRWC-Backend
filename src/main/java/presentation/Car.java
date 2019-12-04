package presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Car {

    //Enums
    public enum CarType {
        
        
        NEW("N"), OCCASION("O"), SHOWMODEL("S");
        
        private String carType;
        
        CarType(String carType) {
            this.carType = carType;
        }
        
        public String getCarType() {
            return carType;
        }
        
    }

    public enum Transmission {

        AUTOMATIC("A"), SEMI_AUTOMATIC("SA"), MANUAL("M");

        private String transmission;

        Transmission(String transmission) {
            this.transmission = transmission;
        }

        public String getTransmission() {
            return transmission;
        }

    }

    public enum FuelType {


        GASOLINE("G"), DIESEL("D"), ELECTRIC("E"), HYDROGEN("H");

        private String fuelType;

        FuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public String getFuelType() {
            return fuelType;
        }

    }

    public enum BodyType {

        HATCHBACK("H"), MPV("M"), SEDAN("S"), STATIONWAGON("SW"), COUPE("C"), CABRIOLET("CB"), SUV("SUV"), REMAINING("R");

        private String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }

    }

    public enum EnergyLabel {

        A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G");

        private String energyLabel;

        EnergyLabel(String energyLabel) {
            this.energyLabel = energyLabel;
        }

        public String getEnergyLabel() {
            return energyLabel;
        }

    }

    //Variables
    private long id;
    private CarType carType;
    private String brand;
    private int mileage;
    private List<String> options;
    private Transmission transmission;
    private FuelType fuelType;
    private int buildYear;
    private int doors;
    private String model;
    private String numberplate;
    private BodyType bodyType;
    private String motorType;
    private int horsepower;
    private int seats;
    private int gears;
    private EnergyLabel energyLabel;
    private Date APK;
    private String imagePath;

    //JsonCreator
    @JsonCreator
    public Car(
            @JsonProperty("id") long id,
            @JsonProperty("carType") CarType carType,
            @JsonProperty("brand") String brand,
            @JsonProperty("mileage") int mileage,
            @JsonProperty("options")List<String> options,
            @JsonProperty("transmission") Transmission transmission,
            @JsonProperty("fuelType") FuelType fuelType,
            @JsonProperty("buildYear") int buildYear,
            @JsonProperty("doors") int doors,
            @JsonProperty("model") String model,
            @JsonProperty("numberplate") String numberplate,
            @JsonProperty("bodyType") BodyType bodyType,
            @JsonProperty("motorType") String motorType,
            @JsonProperty("horsepower") int horsepower,
            @JsonProperty("seats") int seats,
            @JsonProperty("gears") int gears,
            @JsonProperty("energyLabel") EnergyLabel energyLabel,
            @JsonProperty("APK") Date APK,
            @JsonProperty("imagePath") String imagePath
            ) {

        this.id = id;
        this.carType = carType;
        this.brand = brand;
        this.mileage = mileage;
        this.options = options;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.buildYear = buildYear;
        this.doors = doors;
        this.model = model;
        this.numberplate = numberplate;
        this.bodyType = bodyType;
        this.motorType = motorType;
        this.horsepower = horsepower;
        this.seats = seats;
        this.gears = gears;
        this.energyLabel = energyLabel;
        this.APK = APK;
        this.imagePath = imagePath;

    }

    //Getters and setters
    @JsonProperty
    @NotNull
    public long getID() {
        return this.id;
    }

    @JsonProperty
    @NotNull
    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @JsonProperty
    @NotNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty
    @NotNull
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @JsonProperty
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @JsonProperty
    @NotNull
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @JsonProperty
    @NotNull
    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @JsonProperty
    @NotNull
    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    @JsonProperty
    @NotNull
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @JsonProperty
    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty
    @NotNull
    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    @JsonProperty
    @NotNull
    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @JsonProperty
    @NotNull
    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    @JsonProperty
    @NotNull
    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @JsonProperty
    @NotNull
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @JsonProperty
    @NotNull
    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @JsonProperty
    public EnergyLabel getEnergyLabel() {
        return energyLabel;
    }

    public void setEnergyLabel(EnergyLabel energyLabel) {
        this.energyLabel = energyLabel;
    }

    @JsonProperty
    public Date getAPK() {
        return APK;
    }

    public void setAPK(Date APK) {
        this.APK = APK;
    }

    @JsonProperty
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
