/**
 * DatabaseOrderManager - Manages order data in the SQLite database.
 *
 * The DatabaseOrderManager class is responsible for storing, loading, updating, 
 * and deleting orders and their associated pizzas in the database. 
 * Each order includes customer information, order details, and a list of pizzas.
 *
 * Core Methods:
 *  - `saveOrder(Order order)`: Saves a new order with all associated pizzas.
 *  - `loadOrders()`: Loads all orders from the database, including pizzas for each order.
 *  - `updateOrderStatus(int orderId, OrderStatus status)`: Updates the status of an order.
 *  - `deleteOrder(int orderId)`: Deletes an order by its ID, including all associated pizzas.
 * 
 * Example Usage:
 *  - Create an instance of DatabaseOrderManager to interact with the order data.
 *  - Use `saveOrder` to add new orders, `loadOrders` to retrieve existing orders, 
 *    and `updateOrderStatus` to update specific order statuses.
 * 
 * Dependencies:
 *  - DatabaseManager: Handles the database connection.
 *  - Order, Pizza: Represents order and pizza details in the application.
 */


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderManager {
    
    // Save a new order and its items to the database
    public void saveOrder(Order order) {
        String insertOrderSQL = "INSERT INTO Orders (customerName, phoneNumber, isVip, orderTime, pickupTime, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, order.getCustomerName());
            pstmt.setString(2, order.getPhoneNumber());
            pstmt.setBoolean(3, order.isVip());
            pstmt.setString(4, order.getOrderTime().toString());
            pstmt.setString(5, order.getPickupTime().toString());
            pstmt.setString(6, order.getStatus().toString());
            pstmt.executeUpdate();

            // Retrieve the generated order ID
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    int orderId = keys.getInt(1);
                    order.setId(orderId);  // Set the ID in the Order object
                    saveOrderItems(orderId, order.getPizzas());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }

    // Save order items (pizzas) in the OrderItems table
    private void saveOrderItems(int orderId, List<Pizza> pizzas) {
        String insertOrderItemSQL = "INSERT INTO OrderItems (orderId, pizzaId) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertOrderItemSQL)) {

            for (Pizza pizza : pizzas) {
                pstmt.setInt(1, orderId);
                pstmt.setInt(2, pizza.getId());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            System.out.println("Error saving order items: " + e.getMessage());
        }
    }

    // Load all orders from the database
    public List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();
        String selectOrdersSQL = "SELECT * FROM Orders";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectOrdersSQL)) {

            while (rs.next()) {
                Order order = new Order(
                    rs.getString("customerName"),
                    rs.getString("phoneNumber"),
                    rs.getBoolean("isVip"),
                    LocalDateTime.parse(rs.getString("orderTime")),
                    LocalDateTime.parse(rs.getString("pickupTime")),
                    OrderStatus.valueOf(rs.getString("status"))
                );
                order.setId(rs.getInt("id"));
                loadOrderItems(order);  // Load and set pizzas for each order
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }
        return orders;
    }

    // Load and set the list of pizzas in an order
    private void loadOrderItems(Order order) {
        String selectOrderItemsSQL = "SELECT pizzaId FROM OrderItems WHERE orderId = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectOrderItemsSQL)) {

            pstmt.setInt(1, order.getId());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int pizzaId = rs.getInt("pizzaId");
                    Pizza pizza = findPizzaById(pizzaId);
                    if (pizza != null) {
                        order.addPizza(pizza);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error loading order items: " + e.getMessage());
        }
    }

    // Retrieve a pizza by ID (this assumes a method or access to PizzaMenu)
    private Pizza findPizzaById(int pizzaId) {
        PizzaMenu pizzaMenu = new PizzaMenu();  // Assuming PizzaMenu has all available pizzas
        return pizzaMenu.getPizzas().stream()
                .filter(pizza -> pizza.getId() == pizzaId)
                .findFirst()
                .orElse(null);
    }

    // Update order status in the database
    public void updateOrderStatus(int orderId, OrderStatus status) {
        String updateStatusSQL = "UPDATE Orders SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateStatusSQL)) {

            pstmt.setString(1, status.toString());
            pstmt.setInt(2, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating order status: " + e.getMessage());
        }
    }

    // Delete an order by ID (optional functionality)
    public void deleteOrder(int orderId) {
        String deleteOrderSQL = "DELETE FROM Orders WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteOrderSQL)) {

            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting order: " + e.getMessage());
        }
    }
}
