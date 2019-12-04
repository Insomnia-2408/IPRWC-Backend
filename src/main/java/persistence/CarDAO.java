package persistence;

import presentation.Car;
import util.DatabaseConnector;
import util.ResultSetMapper;

import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Car> {

    private PreparedStatement list;
    private PreparedStatement getById;
    private PreparedStatement deleteById;
    private PreparedStatement update;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public List list() {

        List<Car> carList = new ArrayList<>();

        try {

            Connection conn = databaseConnector.getConnection();
            list = conn.prepareStatement("SELECT * FROM car");
            ResultSet rs = list.executeQuery();

            while (rs.next()) {
                carList.add(ResultSetMapper.mapToCar(rs));
            }

            conn.close();
            return carList;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public Car getByID(long id) {

        Car car = null;

        try {

            Connection conn = databaseConnector.getConnection();
            getById = conn.prepareStatement("SELECT * FROM car WHERE id=?");
            getById.setLong(1, id);
            ResultSet rs = getById.executeQuery();

            while (rs.next()) {
                car = ResultSetMapper.mapToCar(rs);
            }

            conn.close();
            return car;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public boolean deleteByID(long id) {

        try {

            Connection conn = databaseConnector.getConnection();
            deleteById = conn.prepareStatement("DELETE FROM car WHERE id=?");
            deleteById.setLong(1, id);
            ResultSet rs = deleteById.executeQuery();

            while (rs.next()) {
                return true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean update(Car car) {

        try {

            Connection conn = databaseConnector.getConnection();
            update = conn.prepareStatement("UPDATE car " +
                    "SET "+ "carType=? " + "brand=? " + "mileage=? " + "options=? " + "transmission=? " +
                    "fuelType=? " + "buildYear=? " + "doors=? " + "model=? " + "numberplate=? " + "bodyType=? " +
                    "motorType=? " + "horsepower=? " + "seats=? " + "gears=? " + "energyLabel=? " + "APK=? " +
                    "imagePath=? " + "WHERE id=?");

            update.setString(1, car.getCarType().toString());
            update.setString(2, car.getBrand());
            update.setInt(3, car.getMileage());
            update.setArray(4, (Array) car.getOptions());
            update.setString(5, car.getTransmission().toString());
            update.setString(6, car.getFuelType().toString());
            update.setInt(7, car.getBuildYear());
            update.setInt(8, car.getDoors());
            update.setString(9, car.getModel());
            update.setString(10, car.getNumberplate());
            update.setString(11, car.getBodyType().toString());
            update.setString(12, car.getMotorType());
            update.setInt(13, car.getHorsepower());
            update.setInt(14, car.getSeats());
            update.setInt(15, car.getGears());
            update.setString(16, car.getEnergyLabel().toString());
            update.setTimestamp(17, (Timestamp) car.getAPK());
            update.setString(18, car.getImagePath());
            update.setLong(19, car.getID());

            conn.close();
            return true;

        }catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean post(Car car) {
        return false;
    }
}
