/**
 * Pizza - Represents a pizza with an ID, name, ingredients, and price.
 *
 * The Pizza class models a pizza in the application, storing its ID, name, list
 * of ingredients, and price. Ingredients are mostly for display purposes here.
 *
 * How to Use:
 *  - Create a Pizza by giving an ID, name, ingredients, and price.
 *  - Access details with getId(), getName(), getIngredients(), and getPrice().
 *  - toString() gives a readable summary with name, price, and ingredients.
 *
 * Example:
 *  ```
 *  Pizza margherita = new Pizza(1, "Margherita", List.of("Tomato", "Cheese"), 50);
 *  ```
 */

import java.util.List;

public class Pizza {
    private int id;
    private String name;
    private List<String> ingredients;
    private int price;

    public Pizza(int id, String name, List<String> ingredients, int price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + " (Price: " + price + ") Ingredients: " + ingredients;
    }
    
}
