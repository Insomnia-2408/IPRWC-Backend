package persistence;

import presentation.User;
import util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDAO {

    private PreparedStatement statement;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public long getUserIDByToken(String token) {

        long id = 0;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT client_id FROM session WHERE token=?");
            statement.setString(1, token);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id = rs.getLong("client_id");
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void createFirstToken(long id, String token) {
        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("INSERT INTO session VALUES (?, ?)");
            statement.setLong(1, id);
            statement.setString(2, token);
            statement.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean setToken(long id, String token) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("UPDATE session SET token=? WHERE client_id=?");
            statement.setString(1, token);
            statement.setLong(2, id);
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

    public boolean deleteToken(String token) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("DELETE * FROM session WHERE token=?");
            statement.setString(1, token);
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
}
