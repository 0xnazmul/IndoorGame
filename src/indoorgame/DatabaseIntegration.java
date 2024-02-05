package indoorgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseIntegration {
    private String URL = "jdbc:derby://localhost:1527/seunazmul";
    private String USERNAME = "root";
    private String PASSWORD = "root";

    // Default constructor
    public DatabaseIntegration() {
    }

    // Constructor with connection details
    public DatabaseIntegration(String url, String username, String password) {
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;
    }

    // Method to execute an update query (INSERT, UPDATE, DELETE)
    public void executeUpdate(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately
        }
    }

    // Method to execute a query and return a ResultSet
    public ResultSet executeQuery(String selectQuery) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately
            return null;
        }
    }

    // Add other methods for executing queries, retrieving data, etc.

    // Example: Method to close the database connection
    public void closeConnection() {
        try {
            DriverManager.getConnection(URL, USERNAME, PASSWORD).close();
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions appropriately
        }
    }
}
