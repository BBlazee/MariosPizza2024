/**
 * Attributes:
 * - LocalDateTime orderTime: The timestamp when the order was placed.
 * - LocalDateTime pickupTime: The timestamp when the customer is expected to pick up the order.
 * - Customer customer: The customer who placed the order.
 * - List<Pizza> pizzas: The list of pizzas included in the order.
 * - OrderStatus status: Enum representing the current status of the order (PENDING, ACTIVE, COMPLETED, CANCELED).
 * - int orderID: A unique identifier for the order.
 * - static int nextOrderID: A static counter used to generate unique order IDs.
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Enum to represent different statuses for order
enum OrderStatus {
    PENDING,   
    ACTIVE,    
    COMPLETED, 
    CANCELED   
}

// Order class
public class Order {
    // Attributes
    private LocalDateTime orderTime;
    private LocalDateTime pickupTime;
    private Customer customer;
    private List<Pizza> pizzas;
    private OrderStatus status;
    private int orderID;
    private static int nextOrderID = 1; // Static counter for ID

    // Constructor
    public Order(Customer customer, LocalDateTime orderTime, LocalDateTime pickupTime) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        this.customer = customer;
        this.pizzas = new ArrayList<>();
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.status = OrderStatus.PENDING; // Defaultas to PENDING
        this.orderID = nextOrderID++; // Assign unique order ID
    }

    // Calculate total price of the order
    public double calculateTotal() {
        if (pizzas.isEmpty()) {
            System.out.println("No pizzas in the order.");
            return 0;
        }
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice(); // Get the price of each pizza
        }
        return total;
    }

    // Add pizza to the order, only if the order is not completed or canceled
    public void addPizza(Pizza pizza) {
        if (status == OrderStatus.COMPLETED || status == OrderStatus.CANCELED) {
            System.out.println("Cannot add pizza to a completed or canceled order.");
        } else {
            pizzas.add(pizza);
        }
    }

    // Complete the order (change status to COMPLETED)
    public void completeOrder() {
        if (status == OrderStatus.ACTIVE) {
            this.status = OrderStatus.COMPLETED;
        } else {
            System.out.println("Order cannot be completed because it is either not active or already completed.");
        }
    }

    // Cancel the order (change status to CANCELED)
    public void cancelOrder() {
        if (status != OrderStatus.COMPLETED) {
            this.status = OrderStatus.CANCELED;
        } else {
            System.out.println("Cannot cancel a completed order.");
        }
    }

    // Activate the order (change status to ACTIVE)
    public void activateOrder() {
        if (status == OrderStatus.PENDING) {
            this.status = OrderStatus.ACTIVE;
        } else {
            System.out.println("Order cannot be activated. It may already be active, completed, or canceled.");
        }
    }

    // Display the order details
    public void displayOrder() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Time: " + orderTime);
        System.out.println("Pickup Time: " + pickupTime);
        System.out.println("Order Status: " + status);
        System.out.println("Pizzas in Order:");
        for (Pizza pizza : pizzas) {
            pizza.displayPizza();
        }
        System.out.println("Total Price: $" + calculateTotal());
    }

    // Getters and Setters
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        this.customer = customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // For easy display
    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Customer: " + customer.getName() + ", Total Price: $" + calculateTotal() + ", Status: " + status;
    }
}


