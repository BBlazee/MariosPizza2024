/**
 * Order - Represents a customer's order.
 *
 * The Order class holds details about each order, such as customer info, 
 * the list of pizzas, and timestamps for order and pickup. It also calculates 
 * the total price, applying a discount if the customer is a VIP.
 *
 * Core Features:
 *  - Store customer details like name, phone number, and VIP status.
 *  - Manage order details including list of pizzas, order time, pickup time, and status.
 *  - Calculate the total price with an optional VIP discount.
 *
 * Example Usage:
 *  - Create a new Order by providing customer information and order/pickup times.
 *  - Add pizzas to the order using `addPizza`.
 *  - Calculate the total with `calculateTotal`, displaying order details with `displayOrder`.
 *
 * Attributes:
 *  - customerName, phoneNumber, isVip: Customer details.
 *  - orderTime, pickupTime: Order timestamps.
 *  - status: Current order status (e.g., PENDING, ACTIVE).
 *  - pizzas: List of pizzas in the order.
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

enum OrderStatus {
    PENDING,
    ACTIVE,
    COMPLETED,
    CANCELED
}

public class Order {
    private int id;
    private String customerName;
    private String phoneNumber;
    private boolean isVip;
    private LocalDateTime orderTime;
    private LocalDateTime pickupTime;
    private OrderStatus status;
    private List<Pizza> pizzas;

    // Constructor for creating new orders and loading existing orders from the database
    public Order(String customerName, String phoneNumber, boolean isVip, LocalDateTime orderTime, LocalDateTime pickupTime, OrderStatus pending) {
        this.customerName = validateString(customerName, "Customer name cannot be null or empty");
        this.phoneNumber = validateString(phoneNumber, "Phone number cannot be null or empty");
        this.isVip = isVip;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.status = status;
        this.pizzas = new ArrayList<>();
    }


    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = validateString(customerName, "Customer name cannot be null or empty"); }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = validateString(phoneNumber, "Phone number cannot be null or empty"); }

    public boolean isVip() { return isVip; }
    public void setVip(boolean isVip) { this.isVip = isVip; }

    public LocalDateTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }

    public LocalDateTime getPickupTime() { return pickupTime; }
    public void setPickupTime(LocalDateTime pickupTime) { this.pickupTime = pickupTime; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public List<Pizza> getPizzas() { return pizzas; }
    public void addPizza(Pizza pizza) { pizzas.add(pizza); }

    // Calculate the total price, applying a VIP discount if applicable
    public double calculateTotal() {
        double total = pizzas.stream().mapToDouble(Pizza::getPrice).sum();
        return isVip ? total * 0.9 : total;  // Apply a 10% discount for VIPs
    }

    // Display order details
    public void displayOrder() {
        System.out.printf("Order ID: %d%n", id);
        System.out.printf("Customer: %s (VIP: %s)%n", customerName, isVip ? "Yes" : "No");
        System.out.printf("Phone: %s%n", phoneNumber);
        System.out.printf("Order Time: %s%n", orderTime);
        System.out.printf("Pickup Time: %s%n", pickupTime);
        System.out.printf("Order Status: %s%n", status);
        System.out.println("Pizzas in Order:");
        pizzas.forEach(pizza -> System.out.println("  - " + pizza));
        System.out.printf("Total Price: %.2f%n", calculateTotal());
    }

    // Helper method to validate and trim strings
    private String validateString(String value, String errorMessage) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return String.format("Order ID: %d, Customer: %s, Total: %.2f, Status: %s", id, customerName, calculateTotal(), status);
    }
}
