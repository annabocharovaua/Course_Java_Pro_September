package Task12.src.NaiveSingletonMultithreaded;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoMultiThread {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            DatabaseConnectionMulti dbConnection1 = DatabaseConnectionMulti.getInstance("jdbc:mysql://127.0.0.1:3306/cinemadb?user=anna", "anna", "1234");
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

        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            DatabaseConnectionMulti dbConnection2 = DatabaseConnectionMulti.getInstance("jdbc:mysql://127.0.0.1:3306/cinemadb1?user=user2", "user2", "user2");

            String sqlQuery = "SELECT * FROM users";
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

}

