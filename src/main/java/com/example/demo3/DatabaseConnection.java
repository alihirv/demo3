package com.example.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

public class DatabaseConnection {
    private static String DB_URL;
    private static String USER;
    private static String PASS;
    private Connection conn;
    public DatabaseConnection() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    private void loadConfig() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        DB_URL = properties.getProperty("db.url");
        USER = properties.getProperty("db.user");
        PASS = properties.getProperty("db.password");
    }
    public void saveReservation(String cabin, LocalDate arrivalDate, LocalDate departureDate, String arrivalTime,
                                String firstName, String lastName,String phoneNumber, String email, String message) throws SQLException {
        String query = "INSERT INTO reservations (cabin, arrival_date, departure_date, arrival_time, first_name, last_name, phone_number, email, message) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, cabin);
        stmt.setString(2, arrivalDate.toString());
        stmt.setString(3, departureDate.toString());
        stmt.setString(4, arrivalTime);
        stmt.setString(5, firstName);
        stmt.setString(6, lastName);
        stmt.setString(7, phoneNumber);
        stmt.setString(8, email);
        stmt.setString(9, message);
        stmt.executeUpdate();
    }
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}

