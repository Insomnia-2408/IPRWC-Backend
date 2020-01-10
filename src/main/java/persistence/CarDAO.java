package persistence;

import presentation.Car;
import util.DatabaseConnector;
import util.ResultSetMapper;

import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Car> {

    private PreparedStatement statement;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public List list() {

        List<Car> carList = new ArrayList<>();

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM car");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                carList.add(ResultSetMapper.mapToCar(rs));
            }

            conn.close();
            return carList;

        } catch (SQLException e) {
            e.getMessage();
        }
        return carList;
    }

    public Car getByID(long id) {

        Car car = null;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM car WHERE car_id=?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                car = ResultSetMapper.mapToCar(rs);
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return car;
    }

    public boolean deleteByID(long id) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("DELETE FROM car WHERE car_id=?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                succes = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return succes;
    }

    public boolean update(Car car) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("UPDATE car " +
                    "SET "+ "carType=? " + "brand=? " + "mileage=? " + "options=? " + "transmission=? " +
                    "fuelType=? " + "buildYear=? " + "doors=? " + "model=? " + "numberplate=? " + "bodyType=? " +
                    "motorType=? " + "horsepower=? " + "seats=? " + "gears=? " + "energyLabel=? " + "APK=? " +
                    "imagePath=? " + "WHERE car_id=?");

            statement.setString(1, car.getCarType().toString());
            statement.setString(2, car.getBrand());
            statement.setInt(3, car.getMileage());
            statement.setArray(4, (Array) car.getOptions());
            statement.setString(5, car.getTransmission().toString());
            statement.setString(6, car.getFuelType().toString());
            statement.setInt(7, car.getBuildYear());
            statement.setInt(8, car.getDoors());
            statement.setString(9, car.getModel());
            statement.setString(10, car.getNumberplate());
            statement.setString(11, car.getBodyType().toString());
            statement.setString(12, car.getMotorType());
            statement.setInt(13, car.getHorsepower());
            statement.setInt(14, car.getSeats());
            statement.setInt(15, car.getGears());
            statement.setString(16, car.getEnergyLabel().toString());
            statement.setTimestamp(17, (Timestamp) car.getAPK());
            statement.setString(18, car.getImagePath());
            statement.setLong(19, car.getID());

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                succes = true;
            }

            conn.close();

        }catch (SQLException e) {
            e.getMessage();
        }
        return succes;
    }

    public boolean create(Car car) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("INSERT INTO car VALUES (" +
                    "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " +
                    "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + ")");
            statement.setLong(1, car.getID());
            statement.setString(2, car.getCarType().toString());
            statement.setString(3, car.getBrand());
            statement.setInt(4, car.getMileage());
            statement.setArray(5, (Array) car.getOptions());
            statement.setString(6, car.getTransmission().toString());
            statement.setString(7, car.getFuelType().toString());
            statement.setInt(8, car.getBuildYear());
            statement.setInt(9, car.getDoors());
            statement.setString(10, car.getModel());
            statement.setString(11, car.getNumberplate());
            statement.setString(12, car.getBodyType().toString());
            statement.setString(13, car.getMotorType());
            statement.setInt(14, car.getHorsepower());
            statement.setInt(15, car.getSeats());
            statement.setInt(16, car.getGears());
            statement.setString(17, car.getEnergyLabel().toString());
            statement.setDate(18, (Date) car.getAPK());
            statement.setString(19, car.getImagePath());

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                succes = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return succes;
    }

    public long getHighestID() {

        long id = 0;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT MAX(car_id) FROM car");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return id;
    }
}
