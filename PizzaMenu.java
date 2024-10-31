/**
 * PizzaMenu - Manages the available pizzas.
 *
 * The PizzaMenu class holds the list of available pizzas and provides methods 
 * to add, remove, and display pizzas. This menu is used when placing orders 
 * to show available pizza options.
 *
 * Core Methods:
 *  - `displayMenu()`: Shows the list of available pizzas.
 *  - `addPizza(Pizza pizza)`: Adds a new pizza to the menu.
 *  - `removePizza(Pizza pizza)`: Removes a pizza from the menu.
 *
 * Example Usage:
 *  - Create an instance of PizzaMenu to access available pizzas.
 *  - Use `displayMenu` to show the current list of pizzas, `addPizza` to add a new pizza, 
 *    and `removePizza` to delete one.
 *
 * Dependencies:
 *  - Pizza: Represents each pizza with details like name, price, and ingredients.
 */

import java.util.ArrayList;
import java.util.List;

public class PizzaMenu {
    private List<Pizza> pizzas;

    // Constructor initializes the menu with predefined pizzas
    public PizzaMenu() {
        this.pizzas = new ArrayList<>();
        initializeMenu();
    }

    // Initialize menu with a static set of pizzas
    private void initializeMenu() {
        pizzas.add(new Pizza(1, "Vesuvio", List.of("Ham"), 80));
        pizzas.add(new Pizza(2, "Amerikaner", List.of("Beef"), 75));
        pizzas.add(new Pizza(3, "Cacciatore", List.of("Pepperoni"), 85));
        pizzas.add(new Pizza(4, "Carbonara", List.of("Meat sauce", "Spaghetti", "Cocktail sausages"), 90));
        pizzas.add(new Pizza(5, "Dennis", List.of("Ham", "Pepperoni", "Cocktail sausages"), 85));
        pizzas.add(new Pizza(6, "Bertil", List.of("Bacon"), 80));
        pizzas.add(new Pizza(7, "Silvia", List.of("Pepperoni", "Red Pepper", "Onion", "Olives"), 95));
        pizzas.add(new Pizza(8, "Victoria", List.of("Pineapple", "Mushrooms", "Onion"), 85));
        pizzas.add(new Pizza(9, "Toronfo", List.of("Ham", "Bacon", "Kebab", "Chili"), 100));
        pizzas.add(new Pizza(10, "Capricciosa", List.of("Ham", "Mushrooms"), 90));
        pizzas.add(new Pizza(11, "Hawaii", List.of("Ham", "Pineapple"), 85));
        pizzas.add(new Pizza(12, "Le Blissola", List.of("Ham", "Shrimp"), 95));
        pizzas.add(new Pizza(13, "Venezia", List.of("Ham", "Bacon"), 90));
        pizzas.add(new Pizza(14, "Mafia", List.of("Pepperoni", "Bacon", "Onion"), 100));
    }

    // Methods to add and remove pizzas from the menu
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    // Display the menu
    public void displayMenu() {
        System.out.println("Menu:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
    }

    // Getter for pizzas list
    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
