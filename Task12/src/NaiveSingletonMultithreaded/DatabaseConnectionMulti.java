package Task12.src.NaiveSingletonMultithreaded;

import java.sql.*;

public final class DatabaseConnectionMulti {
    private static DatabaseConnectionMulti instance;
    private Connection connection;

    private DatabaseConnectionMulti(String jdbcUrl, String username, String password) {
        try {
            Thread.sleep(1000);
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnectionMulti getInstance(String jdbcUrl, String username, String password) {
        DatabaseConnectionMulti result = instance;
        if (result != null) {
            return result;
        }
        synchronized (DatabaseConnectionMulti.class) {
            if (instance == null) {
                instance = new DatabaseConnectionMulti(jdbcUrl, username, password);
            }
            return instance;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet query(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
