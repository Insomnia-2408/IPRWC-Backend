package persistence;

import presentation.User;
import util.DatabaseConnector;
import util.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {

    private PreparedStatement statement;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public User getByEmailAddress(String email) {

        User user = null;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM user WHERE email=?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                user = ResultSetMapper.mapToUser(rs);
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return user;
    }

    public List list() {

        List<User> userList = new ArrayList<>();

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM user");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                userList.add(ResultSetMapper.mapToUser(rs));
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return userList;
    }

    public User getByID(long id) {

        User user = null;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM user WHERE id=?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                user = ResultSetMapper.mapToUser(rs);
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return user;
    }

    public boolean deleteByID(long id) {

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("DELETE * FROM user WHERE id=?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean update(User user) {

        try{

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("UPDATE user SET name=?, email=?, address=?, orders=?, " +
                    "services=?, bills=? WHERE id=?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setArray(4, (Array) user.getOrders());
            statement.setArray(5, (Array) user.getCarServices());
            statement.setArray(6, (Array) user.getBills());
            statement.setLong(7, user.getClientID());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean create(User user) {

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setLong(1, user.getClientID());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setArray(5, (Array) user.getOrders());
            statement.setArray(6, (Array) user.getCarServices());
            statement.setArray(7, (Array) user.getBills());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }

        return false;
    }

    public long getHighestID() {

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT MAX(id) FROM user");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return rs.getInt("id");
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return 0;
    }
}