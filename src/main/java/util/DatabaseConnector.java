package util;

import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Logger;

public class DatabaseConnector {

    private static DatabaseConnector instance;
    private static final Object mutex = new Object();
    private DataSource datasource;

    private DatabaseConnector() {
    }

    public static DatabaseConnector getInstance() {
        DatabaseConnector singleton = instance;
        if (instance == null) {
            synchronized (mutex) {
                singleton = instance;
                if (singleton == null)
                    singleton = instance = new DatabaseConnector();
            }
        }
        return singleton;
    }

    public void setDataSource(DataSource dataSource) {
        this.datasource = dataSource;
    }

    public Connection getConnection() {
        if (datasource == null)
            throw new RuntimeException("DataSource not defined");
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean ping() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT 1");
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                rs.close();
                conn.close();
                statement.close();
            } catch (SQLException e) {
                return false;
            }
        }
    }

}
