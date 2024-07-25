package com.example.Makersmarkt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:postgresql://localhost:3000/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Methode om verbinding te maken met de database
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    // Methode om gegevens in te voegen
    public static void insertUsers() {
        String insertUserSQL = "INSERT INTO Users (name, photo, website_link, facebook_link, instagram_link, tiktok_link, user_type) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {

            // Voeg John Doe toe
            preparedStatement.setString(1, "John Doe");
            preparedStatement.setString(2, "johndoe.jpg");
            preparedStatement.setString(3, "http://johndoe.com");
            preparedStatement.setString(4, "http://facebook.com/johndoe");
            preparedStatement.setString(5, "http://instagram.com/johndoe");
            preparedStatement.setString(6, "http://tiktok.com/johndoe");
            preparedStatement.setString(7, "market");
            preparedStatement.executeUpdate();

            // Voeg Jane Smith toe
            preparedStatement.setString(1, "Jane Smith");
            preparedStatement.setString(2, "janesmith.jpg");
            preparedStatement.setString(3, "http://janesmith.com");
            preparedStatement.setString(4, "http://facebook.com/janesmith");
            preparedStatement.setString(5, "http://instagram.com/janesmith");
            preparedStatement.setString(6, "http://tiktok.com/janesmith");
            preparedStatement.setString(7, "product");
            preparedStatement.executeUpdate();

            System.out.println("Data has been inserted successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertUsers();
    }
}
