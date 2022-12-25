package ua.edu.ucu.apps.task2.database;

import java.sql.*;
import java.util.List;

public class HomeSourceDatabase {
    private static final String DB_URL = "jdbc:sqlite:cache.sqlite";

    private static Connection prepareConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        PreparedStatement statement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS cache (id INTEGER PRIMARY KEY, location TEXT, data TEXT)");
        statement.execute();
        statement.close();

        return connection;
    }

    public static List<String> getCache(String location) throws SQLException {
        String parsedString;

        Connection connection = prepareConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT data FROM cache WHERE location = ?");
        statement.setString(1, location);

        ResultSet response = statement.executeQuery();

        if (response.next()) {
            parsedString = response.getString("data");
            connection.close();
        } else {
            return List.of();
        }

        return List.of(parsedString.split(", "));
    }

    public static void setCache(String location, List<String> data) throws SQLException {
        String parsedString = String.join(", ", data);

        Connection connection = prepareConnection();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cache (location, data) VALUES (?, ?)");

        statement.setString(1, location);
        statement.setString(2, parsedString);
        statement.execute();

        statement.close();
        connection.close();
    }
}
