/**
 * @ Anton
 * @ 21.september
 */

import java.util.List;

public class Pizza {
    private int pizzaID
    private String pizzaName
    private double price
    private List<String> ingredients

    // contstructor
    public Pizza(int pizzaID, String pizzaName, int price, String ingredients) {
        this.pizzaID = pizzaID;
        this.pizzaName = pizzaName;
        this.price = price;
        this.ingredients = ingredients
    }
    
    // get metoder
    public int getPizzaID() {
        return pizzaID;
    }

    public String getName() {
        return pizzaName;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    // Viser en given pizza, kaldes i Menu klassen
    public void displayPizza() {
        System.out.println("Nummer: " + pizzaID);
        System.out.println("Pizza: " + pizzaName);
        System.out.println("Pris: " + price);
        System.out.println("Ingredienser: " + String.join(", ", ingredients));
        System.out.println();
    }
}