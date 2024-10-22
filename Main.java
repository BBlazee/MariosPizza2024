import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test Pizza objekter
        List<String> vesuvioIngredients = new ArrayList<>();
        vesuvioIngredients.add("Skinke");

        Pizza vesuvio = new Pizza(1, "Vesuvio", 57, vesuvioIngredients);

        List<String> amerikanerIngredients = new ArrayList<>();
        amerikanerIngredients.add("Oksefars");

        Pizza amerikaner = new Pizza(2, "Amerikaner", 53, amerikanerIngredients);

        List<String> cacciatoreIngredients = new ArrayList<>();
        cacciatoreIngredients.add("Pepperoni");

        Pizza cacciatore = new Pizza(3, "Cacciatore", 57, cacciatoreIngredients);

        List<String> carbonaraIngredients = new ArrayList<>();
        carbonaraIngredients.add("Koedsauce");
        carbonaraIngredients.add("Spaghetti");
        carbonaraIngredients.add("Cocktailpoelser");

        Pizza carbonara = new Pizza(4, "Carbonara", 63, carbonaraIngredients);

        List<String> dennisIngredients = new ArrayList<>();
        dennisIngredients.add("Skinke");
        dennisIngredients.add("Pepperoni");
        dennisIngredients.add("Cocktailpoelser");

        Pizza dennis = new Pizza(5, "Dennis", 65, dennisIngredients);

        List<String> bertilIngredients = new ArrayList<>();
        bertilIngredients.add("Bacon");

        Pizza bertil = new Pizza(6, "Bertil", 57, bertilIngredients);

        List<String> silviaIngredients = new ArrayList<>();
        silviaIngredients.add("Pepperoni");
        silviaIngredients.add("Roed peber");
        silviaIngredients.add("Loeg");
        silviaIngredients.add("Oliven");

        Pizza silvia = new Pizza(7, "Silvia", 61, silviaIngredients);

        List<String> victoriaIngredients = new ArrayList<>();
        victoriaIngredients.add("Ananas");
        victoriaIngredients.add("Champignon");
        victoriaIngredients.add("Loeg");

        Pizza victoria = new Pizza(8, "Victoria", 61, victoriaIngredients);

        List<String> toronfoIngredients = new ArrayList<>();
        toronfoIngredients.add("Bacon");
        toronfoIngredients.add("Kebab");
        toronfoIngredients.add("Chili");

        Pizza toronfo = new Pizza(9, "Toronfo", 61, toronfoIngredients);

        List<String> capricciosaIngredients = new ArrayList<>();
        capricciosaIngredients.add("Skinke");
        capricciosaIngredients.add("Champignon");

        Pizza capricciosa = new Pizza(10, "Capricciosa", 61, capricciosaIngredients);

        List<String> hawaiiIngredients = new ArrayList<>();
        hawaiiIngredients.add("Ananas");

        Pizza hawaii = new Pizza(11, "Hawaii", 61, hawaiiIngredients);

        List<String> leblissolaIngredients = new ArrayList<>();
        leblissolaIngredients.add("Skinke");
        leblissolaIngredients.add("Rejer");

        Pizza leblissola = new Pizza(12, "Le Blissola", 61, leblissolaIngredients);

        List<String> veneziaIngredients = new ArrayList<>();
        veneziaIngredients.add("Skinke");
        veneziaIngredients.add("Bacon");

        Pizza venezia = new Pizza(13, "Venezia", 61, veneziaIngredients);

        List<String> mafiaIngredients = new ArrayList<>();
        mafiaIngredients.add("Pepperoni");
        mafiaIngredients.add("Bacon");
        mafiaIngredients.add("Loeg");

        Pizza mafia = new Pizza(14, "Mafia", 61, mafiaIngredients);

        // tilføj pizzaer til en menu
        Menu pizzaMenu = new Menu();

        pizzaMenu.addPizza(vesuvio);
        pizzaMenu.addPizza(amerikaner);
        pizzaMenu.addPizza(cacciatore);
        pizzaMenu.addPizza(carbonara);
        pizzaMenu.addPizza(dennis);
        pizzaMenu.addPizza(bertil);
        pizzaMenu.addPizza(silvia);
        pizzaMenu.addPizza(victoria);
        pizzaMenu.addPizza(toronfo);
        pizzaMenu.addPizza(capricciosa);
        pizzaMenu.addPizza(hawaii);
        pizzaMenu.addPizza(leblissola);
        pizzaMenu.addPizza(venezia);
        pizzaMenu.addPizza(mafia);

        // vis menu
        pizzaMenu.displayMenu();
    }
}
