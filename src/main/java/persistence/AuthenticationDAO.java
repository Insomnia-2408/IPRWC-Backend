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

    public long getTokenUser(String token) {

        long id = 0;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT client_id FROM session WHERE token=?");
            statement.setString(1, token);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id = rs.getLong("id");
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return id;
    }

    public boolean setToken(long id, String token) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("UPDATE session SET token=? WHERE client_id=?");
            statement.setString(1, token);
            statement.setLong(2, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                succes = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return succes;
    }

}
