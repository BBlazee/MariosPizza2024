/**
 * DatabaseManager - Manages the SQLite database connection.
 *
 * This class establishes and manages the connection to the SQLite database, 
 * creating the necessary tables for Orders and OrderItems if they don’t exist.
 * It provides methods to initialize and close the connection.
 *
 * Core Methods:
 *  - `initialize()`: Sets up the database connection and creates tables if needed.
 *  - `close()`: Closes the connection when the application ends.
 *
 * Example Usage:
 *  - Call `DatabaseManager.initialize()` at the start of the application to 
 *    establish a database connection and set up tables.
 *  - Call `DatabaseManager.close()` at the end of the application to safely 
 *    close the connection.
 *
 * Dependencies:
 *  - SQLite JDBC: Connects and manages the SQLite database.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:Database.db";
    private static Connection connection;

    // Initialize database connection and create tables
    public static void initialize() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            createTables();
            System.out.println("Connected to the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database: " + e.getMessage());
        }
    }

    // Close the database connection
    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing SQLite connection: " + e.getMessage());
        }
    }

    // Create necessary tables
    private static void createTables() {
        String ordersTable = """
                CREATE TABLE IF NOT EXISTS Orders (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    customerName TEXT NOT NULL,
                    phoneNumber TEXT,
                    isVip INTEGER,
                    orderTime TEXT,
                    pickupTime TEXT,
                    status TEXT
                );
                """;

        String pizzasTable = """
                CREATE TABLE IF NOT EXISTS Pizzas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    price REAL NOT NULL
                );
                """;

        String orderItemsTable = """
                CREATE TABLE IF NOT EXISTS OrderItems (
                    orderId INTEGER,
                    pizzaId INTEGER,
                    FOREIGN KEY (orderId) REFERENCES Orders(id),
                    FOREIGN KEY (pizzaId) REFERENCES Pizzas(id)
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(ordersTable);
            statement.execute(pizzasTable);
            statement.execute(orderItemsTable);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    // Getter for database connection
    public static Connection getConnection() {
        return connection;
    }
}
