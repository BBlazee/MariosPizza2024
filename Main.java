/**
 * Main - The main entry point for the application.
 *
 * This class provides an interactive console-based menu to manage pizzas and orders. 
 * Users can view the pizza menu, add/remove pizzas, place new orders, view orders, 
 * and edit or cancel existing ones. The main loop presents options to the user 
 * and calls relevant methods to handle each option.
 *
 * How to Use:
 *  - Run the main method to start the application.
 *  - Choose options in the menu to perform actions, such as:
 *      - Viewing or modifying the pizza menu
 *      - Placing, viewing, or editing orders
 *  - Uses `InputHelper` to validate inputs and `DatabaseOrderManager` to manage 
 *    order data in the database.
 *
 * Dependencies:
 *  - PizzaMenu: Manages available pizzas.
 *  - DatabaseOrderManager: Handles loading, saving, and updating orders in the database.
 *  - InputHelper: Gathers and validates user input.
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initialize();  // Initialize database connection
        DatabaseOrderManager orderManager = new DatabaseOrderManager();  // Database manager for orders
        PizzaMenu pizzaMenu = new PizzaMenu();
        InputHelper inputHelper = new InputHelper();
        List<Order> orders = orderManager.loadOrders();  // Load orders from the database
        boolean exit = false;

        System.out.println("Loaded Orders:");
        for (Order order : orders) {
            order.displayOrder();
            System.out.println("----------");
        }

        while (!exit) {
            displayMainMenu();
            int choice = inputHelper.getInt("Choose an option: ");

            switch (choice) {
                case 0 -> {
                    exit = true;
                    System.out.println("Exiting menu system.");
                }
                case 1 -> pizzaMenu.displayMenu();
                case 2 -> addPizzaToMenu(inputHelper, pizzaMenu);
                case 3 -> removePizzaFromMenu(inputHelper, pizzaMenu);
                case 4 -> placeNewOrder(inputHelper, pizzaMenu, orders, orderManager);
                case 5 -> viewAllOrders(orders);
                case 6 -> editOrder(inputHelper, pizzaMenu, orders, orderManager);
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        inputHelper.close();
        DatabaseManager.close();  // Close the database connection at the end
    }

    private static void displayMainMenu() {
        System.out.println("---------------------");
        System.out.println("\nMenu System:");
        System.out.println("1. Display Pizza Menu");
        System.out.println("2. Add Pizza to Menu");
        System.out.println("3. Remove Pizza from Menu");
        System.out.println("4. Place a New Order");
        System.out.println("5. View All Orders");
        System.out.println("6. Edit an Order");
        System.out.println("0. Exit");
    }

    private static void addPizzaToMenu(InputHelper inputHelper, PizzaMenu pizzaMenu) {
        String pizzaName = inputHelper.getString("Enter pizza name to add: ");
        int price = inputHelper.getInt("Enter price for " + pizzaName + ": ");
        List<String> ingredients = getIngredientsFromUser(inputHelper);

        Pizza newPizza = new Pizza(pizzaMenu.getPizzas().size() + 1, pizzaName, ingredients, price);
        pizzaMenu.addPizza(newPizza);
        System.out.println("Added " + pizzaName + " with price " + price + " and ingredients " + ingredients);
    }

    private static List<String> getIngredientsFromUser(InputHelper inputHelper) {
        List<String> ingredients = new ArrayList<>();
        System.out.println("Enter ingredients one by one (type 'done' when finished):");
        while (true) {
            String ingredient = inputHelper.getString("Ingredient: ");
            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    private static void removePizzaFromMenu(InputHelper inputHelper, PizzaMenu pizzaMenu) {
        int pizzaId = inputHelper.getInt("Enter pizza ID to remove: ");
        Pizza pizzaToRemove = findPizzaById(pizzaId, pizzaMenu);

        if (pizzaToRemove != null) {
            pizzaMenu.removePizza(pizzaToRemove);
            System.out.println("Pizza removed from the menu.");
        } else {
            System.out.println("Pizza not found.");
        }
    }

    private static Pizza findPizzaById(int pizzaId, PizzaMenu pizzaMenu) {
        return pizzaMenu.getPizzas().stream()
                .filter(pizza -> pizza.getId() == pizzaId)
                .findFirst()
                .orElse(null);
    }

    private static void placeNewOrder(InputHelper inputHelper, PizzaMenu pizzaMenu, List<Order> orders, DatabaseOrderManager orderManager) {
        System.out.println("Placing a new order.");
        String customerName = inputHelper.getString("Enter customer name: ");
        String phoneNumber = inputHelper.getString("Enter phone number: ");
        boolean isVip = inputHelper.getString("Is the customer a VIP? (yes/no): ").equalsIgnoreCase("yes");

        LocalDateTime orderTime = LocalDateTime.now();
        LocalDateTime pickupTime = orderTime.plusHours(1);

        Order newOrder = new Order(customerName, phoneNumber, isVip, orderTime, pickupTime, OrderStatus.PENDING);
        addPizzasToOrder(inputHelper, pizzaMenu, newOrder);

        orders.add(newOrder);
        orderManager.saveOrder(newOrder);  // Save the new order to the database
        System.out.println("Order placed successfully.");
        newOrder.displayOrder();
    }

    private static void addPizzasToOrder(InputHelper inputHelper, PizzaMenu pizzaMenu, Order order) {
        while (true) {
            pizzaMenu.displayMenu();
            int pizzaChoice = inputHelper.getInt("Enter pizza ID to add to the order (or type 0 to finish): ");
            if (pizzaChoice == 0) break;

            Pizza selectedPizza = findPizzaById(pizzaChoice, pizzaMenu);
            if (selectedPizza != null) {
                order.addPizza(selectedPizza);
                System.out.println("Added " + selectedPizza.getName() + " to the order.");
            } else {
                System.out.println("Invalid pizza ID.");
            }
        }
    }

    private static void viewAllOrders(List<Order> orders) {
        List<Order> activeOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus() != OrderStatus.COMPLETED && order.getStatus() != OrderStatus.CANCELED) {
                activeOrders.add(order);
            }
        }

        // Sort active orders by pickup time (closest to furthest)
        activeOrders.sort(Comparator.comparing(Order::getPickupTime));

        if (activeOrders.isEmpty()) {
            System.out.println("No active orders have been placed yet.");
        } else {
            System.out.println("Active Orders (sorted by closest pickup time):");
            for (Order order : activeOrders) {
                order.displayOrder();
                System.out.println("----------");
            }
        }
    }

    private static void editOrder(InputHelper inputHelper, PizzaMenu pizzaMenu, List<Order> orders, DatabaseOrderManager orderManager) {
        int orderIdToEdit = inputHelper.getInt("Enter the Order ID to edit: ");
        Order orderToEdit = findOrderById(orderIdToEdit, orders);

        if (orderToEdit != null) {
            System.out.println("Editing Order:");
            orderToEdit.displayOrder();

            System.out.println("---------------------");
            System.out.println("1. Add Pizza to Order");
            System.out.println("2. Mark Order as Completed");
            System.out.println("3. Mark Order as Cancelled");
            System.out.println("0. Exit");
            int editChoice = inputHelper.getInt("Choose an option: ");

            switch (editChoice) {
                case 1 -> addPizzasToOrder(inputHelper, pizzaMenu, orderToEdit);
                case 2 -> {
                    orderToEdit.setStatus(OrderStatus.COMPLETED);
                    System.out.println("Order marked as completed.");
                }
                case 3 -> {
                    orderToEdit.setStatus(OrderStatus.CANCELED);
                    System.out.println("Order marked as cancelled.");
                }
                default -> System.out.println("Invalid choice.");
            }
            orderManager.updateOrderStatus(orderToEdit.getId(), orderToEdit.getStatus());  // Update order status in the database
        } else {
            System.out.println("Order not found.");
        }
    }

    private static Order findOrderById(int orderId, List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }
}
