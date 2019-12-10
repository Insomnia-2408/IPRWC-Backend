package persistence;

import presentation.User;
import util.DatabaseConnector;
import util.ResultSetMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    public User getByID(long id) {
        return null;
    }

    public boolean deleteByID(long id) {
        return false;
    }

    public boolean update(User object) {
        return false;
    }

    public boolean post(User object) {
        return false;
    }
}
