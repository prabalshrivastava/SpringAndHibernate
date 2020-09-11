package demo01;

import java.sql.*;

import static demo01.DBUtil.*;

public class Jdbc01Main {
    public static void main(String[] args) {
        System.out.println("hello jdbc");
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "Select id,name,author,subject,price from books";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("author");
                        String subject = resultSet.getString("subject");
                        double price = resultSet.getDouble("price");
                        System.out.printf("%d | %s | %s | %s | %f%n",id,name,author,subject,price);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
