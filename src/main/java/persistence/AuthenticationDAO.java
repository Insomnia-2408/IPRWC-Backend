package persistence;

import util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDAO {

    private PreparedStatement statement;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public String getToken(long clientID) {

        String token = null;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT token FROM session WHERE client_id=?");
            statement.setLong(1, clientID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                token = rs.getString("token");
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return token;
    }

    public boolean setToken(long id, String token) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("UPDATE session SET token=? WHERE id=?");
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
