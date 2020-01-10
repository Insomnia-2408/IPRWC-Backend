package persistence;

import presentation.Shoppingcart;
import util.DatabaseConnector;
import util.ResultSetMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingcartDAO {

    private PreparedStatement statement;
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    public Object getCart(long id) {

        Shoppingcart cart = null;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT * FROM shoppingcart WHERE client_id=?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                cart = ResultSetMapper.mapToCart(rs);
            }

            conn.close();

        } catch (SQLException e) {
            e.getMessage();
        }
        return cart;
    }

    public boolean delete(long id, Class<?> object) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("INSERT INTO shoppingcart VALUES (?, ?, ?)");
            statement.setLong(1, id);

        } catch (SQLException e) {
            e.getMessage();
        }
        return succes;
    }

    public boolean add(long id, Class<?> object) {

        boolean succes = false;

        //TODO: FIX YOUR SHIT

        return succes;

    }

}
