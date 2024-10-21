import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test Pizza objekter
        List<String> vesuvioIngredients = new ArrayList<>();
        vesuvioIngredients.add("Tomatsauce");
        vesuvioIngredients.add("Ost");
        vesuvioIngredients.add("Skinke");
        vesuvioIngredients.add("Oregano");

        Pizza vesuvio = new Pizza(1, "Vesuvio", 57, vesuvioIngredients);

        List<String> amerikanerIngredients = new ArrayList<>();
        amerikanerIngredients.add("Tomatsauce");
        amerikanerIngredients.add("Ost");
        amerikanerIngredients.add("Oksefars");
        amerikanerIngredients.add("Oregano");

        Pizza amerikaner = new Pizza(2,"Amerikaner", 53, amerikanerIngredients);

        // tilføj pizzaer til en menu
        Menu pizzaMenu = new Menu();

        pizzaMenu.addPizza(vesuvio);
        pizzaMenu.addPizza(amerikaner);

        // vis menu
        pizzaMenu.displayMenu();
    }
}