package persistence;

import presentation.Product;
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

    public Shoppingcart getCart(long id) {

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
            e.printStackTrace();
        }
        return cart;
    }

    public boolean delete(long id, Product product) {

        boolean succes = false;

        try {

            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("INSERT INTO shoppingcart VALUES (?, ?, ?, ?)");
            statement.setLong(1, id);
            statement.setLong(2, product.getId());
            statement.setString(3, product.getProductType().toString());
            statement.setLong(4, product.getAmount());
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

    public boolean add(long id, Product product) {

        boolean succes = false;
        long found = checkIfAlreadyAdded(id, product);

        if(found != 0) {

            try {
                Connection conn = databaseConnector.getConnection();
                statement = conn.prepareStatement("UPDATE shoppingcart SET amount=? WHERE client_id=? AND id=?");
                long total = found + product.getAmount();
                statement.setLong(1, total);
                statement.setLong(2, id);
                statement.setLong(3, product.getId());
                int rs = statement.executeUpdate();

                if (rs == 1 || rs == 2) {
                    succes = true;
                }

                conn.close();;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {

            try {
                Connection conn = databaseConnector.getConnection();
                statement = conn.prepareStatement("INSERT INTO shoppingcart VALUES ?, ?, ?, ?");
                statement.setLong(1, id);
                statement.setLong(2, product.getId());
                statement.setString(3, product.getProductType().toString());
                statement.setLong(4, product.getAmount());
                int rs = statement.executeUpdate();

                if (rs == 1 || rs == 2) {
                    succes = true;
                }

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return succes;

    }

    private long checkIfAlreadyAdded(long id, Product product) {

        long found = 0;

        try {
            Connection conn = databaseConnector.getConnection();
            statement = conn.prepareStatement("SELECT amount FROM shoppingcart " +
                    "WHERE client_id=? AND product_type=? AND id=?");
            statement.setLong(1, id);
            statement.setString(2, product.getProductType().toString());
            statement.setLong(3, product.getId());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                found = rs.getLong("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }

}
