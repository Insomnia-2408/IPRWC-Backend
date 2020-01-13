package persistence;

import presentation.Credentials;
import presentation.User;
import util.DatabaseConnector;
import util.Hash;
import util.ResultSetMapper;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {

    private PreparedStatement statement;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public User getAuthorization(Credentials credentials) throws NoSuchAlgorithmException {

        User user = null;
        String hashedPassword = Hash.hash(credentials.getPassword());

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            statement.setString(1, credentials.getEmail());
            statement.setString(2, hashedPassword);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                user = ResultSetMapper.mapToUser(rs);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List list() {

        List<User> userList = new ArrayList<>();

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                userList.add(ResultSetMapper.mapToUser(rs));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User getByID(long id) {

        User user = null;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM users WHERE client_id=?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                user = ResultSetMapper.mapToUser(rs);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean deleteByID(long id) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("DELETE * FROM users WHERE client_id=?");
            statement.setLong(1, id);
            int rs = statement.executeUpdate();

            if (rs == 1 || rs == 2) {
                succes = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return succes;
    }

    public boolean update(User user) {

        boolean succes = false;

        try{

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("UPDATE users SET name=?, email=?, address=?, user_role=?::user_role "
                    + "WHERE client_id=?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getUserRole().name());
            statement.setLong(5, user.getClientID());
            int rs = statement.executeUpdate();

            if (rs == 1 || rs == 2) {
                succes = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return succes;
    }

    public boolean create(User user) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("INSERT INTO users " +
                    " (client_id, name, email, password, address, user_role) " +
                    "VALUES (?, ?, ?, ?, ?, ?::user_role )");
            statement.setLong(1, user.getClientID());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getUserRole().name());
            System.out.println(statement);
            int rs = statement.executeUpdate();

            if (rs == 1 || rs == 2) {
                succes = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return succes;
    }

    public long getHighestID() {

        long id = 0;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT MAX(client_id) client_id FROM users");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id = rs.getInt("client_id");
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean checkIfEmailExists(String email) {

        boolean found = false;

        try {
            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * from users WHERE email=?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                found = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return found;

    }

}