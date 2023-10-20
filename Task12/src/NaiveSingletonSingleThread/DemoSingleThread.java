package Task12.src.NaiveSingletonSingleThread;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoSingleThread {
    public static void main(String[] args) {
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance("jdbc:mysql://127.0.0.1:3306/cinemadb?user=anna", "anna", "1234");
        System.out.println(dbConnection1.toString());
        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance("jdbc:mysql://127.0.0.1:3306/cinemadb2?user=user2", "user2", "password2");

        if (dbConnection1 == dbConnection2) {
            System.out.println("Both connections are the same (Singleton was reused)");
        } else {
            System.out.println("Different connections (2 singletons were created)");
        }

        String sqlQuery = "SELECT * FROM users";

        try {
            ResultSet resultSet1 = dbConnection1.query(sqlQuery);
            while (resultSet1.next()) {
                int id = resultSet1.getInt("user_id");
                String name = resultSet1.getString("first_name");

                System.out.println("Result from connection 1 - ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet resultSet2 = dbConnection2.query(sqlQuery);
            while (resultSet2.next()) {
                int id = resultSet2.getInt("user_id");
                String name = resultSet2.getString("first_name");

                System.out.println("Result from connection 2 - ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}