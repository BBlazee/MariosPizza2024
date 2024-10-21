import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test Pizza objekter
        List<String> margheritaIngredients = new ArrayList<>();
        margheritaIngredients.add("Tomato Sauce");
        margheritaIngredients.add("Mozzarella");
        margheritaIngredients.add("Basil");

        Pizza margherita = new Pizza("Margherita", 8.99, margheritaIngredients);

        List<String> pepperoniIngredients = new ArrayList<>();
        pepperoniIngredients.add("Tomato Sauce");
        pepperoniIngredients.add("Mozzarella");
        pepperoniIngredients.add("Pepperoni");

        Pizza pepperoni = new Pizza("Pepperoni", 9.99, pepperoniIngredients);

        // Test Menu
        Menu pizzaMenu = new Menu();
        pizzaMenu.addPizza(margherita);
        pizzaMenu.addPizza(pepperoni);

        // Vis Menuen
        pizzaMenu.displayMenu();
    }
}