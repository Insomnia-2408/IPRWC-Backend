package util;

import presentation.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ResultSetMapper {

    public static Car mapToCar(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String carType = rs.getString("car_type");
        String brand = rs.getString("brand");
        int mileage = rs.getInt("mileage");
        List<String> options = (List<String>) rs.getArray("options");
        String transmission = rs.getString("transmission");
        String fuelType = rs.getString("fuel_type");
        int buildYear = rs.getInt("build_year");
        int doors = rs.getInt("doors");
        String model = rs.getString("model");
        String numberplate = rs.getString("number_plate");
        String bodyType = rs.getString("body_type");
        String motorType = rs.getString("motor_type");
        int horsepower = rs.getInt("horsepower");
        int seats = rs.getInt("seats");
        int gears = rs.getInt("gears");
        String energyLabel = rs.getString("energy_label");
        Date APK = rs.getDate("APK");
        String imagePath = rs.getString("image_path");

        return new Car(id, Car.CarType.valueOf(carType), brand, mileage, options, Car.Transmission.valueOf(transmission),
                Car.FuelType.valueOf(fuelType), buildYear, doors, model, numberplate, Car.BodyType.valueOf(bodyType),
                motorType, horsepower, seats, gears, Car.EnergyLabel.valueOf(energyLabel), APK, imagePath);
    }

}