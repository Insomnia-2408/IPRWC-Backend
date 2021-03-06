package util;

import presentation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ResultSetMapper {

    public static Car mapToCar(ResultSet rs) throws SQLException {

        long id = rs.getLong("car_id");
        String carType = rs.getString("car_type");
        String brand = rs.getString("brand");
        int mileage = rs.getInt("mileage");
        String options = rs.getString("options");
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
        Timestamp APK = rs.getTimestamp("APK");
        String imagePath = rs.getString("image_path");
        double price = rs.getDouble("price");

        return new Car(id, Car.CarType.valueOf(carType), brand, mileage, options, Car.Transmission.valueOf(transmission),
                Car.FuelType.valueOf(fuelType), buildYear, doors, model, numberplate, Car.BodyType.valueOf(bodyType),
                motorType, horsepower, seats, gears, Car.EnergyLabel.valueOf(energyLabel), APK, imagePath, price);

    }

    public static User mapToUser(ResultSet rs) throws SQLException {

        long id = rs.getLong("client_id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String address = rs.getString("address");
        String userRole = rs.getString("user_role");

        return new User(id, name, email, address, UserRole.valueOf(userRole));

    }

}