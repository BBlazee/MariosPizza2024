import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test Pizza objekter
        List<String> margheritaIngredients = new ArrayList<>();
        margheritaIngredients.add("Tomato Sauce");
        margheritaIngredients.add("Mozzarella");
        margheritaIngredients.add("Basil");

        Pizza margherita = new Pizza(1, "Margherita", 8.99, margheritaIngredients);

        List<String> pepperoniIngredients = new ArrayList<>();
        pepperoniIngredients.add("Tomato Sauce");
        pepperoniIngredients.add("Mozzarella");
        pepperoniIngredients.add("Pepperoni");

        Pizza pepperoni = new Pizza(2,"Pepperoni", 9.99, pepperoniIngredients);
    }
}