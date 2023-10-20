package Task12.src.NaiveSingletonSingleThread;

import java.sql.*;

public final class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(String jdbcUrl, String username, String password) {
        try {
            Thread.sleep(1000);
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance(String jdbcUrl, String username, String password) {
        if (instance == null) {
            instance = new DatabaseConnection(jdbcUrl, username, password);
        }

        return instance;
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
