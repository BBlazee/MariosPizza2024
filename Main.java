import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

         // definer ingredienserne som Ingredient objekter
         Ingredient skinke = new Ingredient(1, "Skinke", 7);
         Ingredient oksefars = new Ingredient(2, "Oksefars", 5);
         Ingredient pepperoni = new Ingredient(3, "Pepperoni", 7);
         Ingredient koedsauce = new Ingredient(4, "Koedsauce", 6);
         Ingredient spaghetti = new Ingredient(5, "Spaghetti", 3);
         Ingredient cocktailpoelser = new Ingredient(6, "Cocktailpoelser", 4);
         Ingredient bacon = new Ingredient(7, "Bacon", 7);
         Ingredient roedPeber = new Ingredient(8, "Roed Peber", 3);
         Ingredient loeg = new Ingredient(9, "Loeg", 3);
         Ingredient oliven = new Ingredient(10, "Oliven", 4);
         Ingredient ananas = new Ingredient(11, "Ananas", 6);
         Ingredient champignon = new Ingredient(12, "Champignon", 4);
         Ingredient rejer = new Ingredient(13, "Rejer", 8);
         Ingredient kebab = new Ingredient(14, "Kebab", 8);
         Ingredient chili = new Ingredient(15, "Chili", 4);
 
         // definer de forskellige Pizza objekter med Ingredient'er. der er meget kode duplikation her, som formentlig kan forsimples paa en eller anden maade...
         List<Ingredient> vesuvioIngredients = new ArrayList<>();
         vesuvioIngredients.add(skinke);
 
         Pizza vesuvio = new Pizza(1, "Vesuvio", vesuvioIngredients);
 
         List<Ingredient> amerikanerIngredients = new ArrayList<>();
         amerikanerIngredients.add(oksefars);
 
         Pizza amerikaner = new Pizza(2, "Amerikaner", amerikanerIngredients);
 
         List<Ingredient> cacciatoreIngredients = new ArrayList<>();
         cacciatoreIngredients.add(pepperoni);
 
         Pizza cacciatore = new Pizza(3, "Cacciatore", cacciatoreIngredients);
 
         List<Ingredient> carbonaraIngredients = new ArrayList<>();
         carbonaraIngredients.add(koedsauce);
         carbonaraIngredients.add(spaghetti);
         carbonaraIngredients.add(cocktailpoelser);
 
         Pizza carbonara = new Pizza(4, "Carbonara", carbonaraIngredients);
 
         List<Ingredient> dennisIngredients = new ArrayList<>();
         dennisIngredients.add(skinke);
         dennisIngredients.add(pepperoni);
         dennisIngredients.add(cocktailpoelser);
 
         Pizza dennis = new Pizza(5, "Dennis", dennisIngredients);
 
         List<Ingredient> bertilIngredients = new ArrayList<>();
         bertilIngredients.add(bacon);
 
         Pizza bertil = new Pizza(6, "Bertil", bertilIngredients);
 
         List<Ingredient> silviaIngredients = new ArrayList<>();
         silviaIngredients.add(pepperoni);
         silviaIngredients.add(roedPeber);
         silviaIngredients.add(loeg);
         silviaIngredients.add(oliven);
 
         Pizza silvia = new Pizza(7, "Silvia", silviaIngredients);
 
         List<Ingredient> victoriaIngredients = new ArrayList<>();
         victoriaIngredients.add(ananas);
         victoriaIngredients.add(champignon);
         victoriaIngredients.add(loeg);
 
         Pizza victoria = new Pizza(8, "Victoria", victoriaIngredients);
 
         List<Ingredient> toronfoIngredients = new ArrayList<>();
         toronfoIngredients.add(skinke);
         toronfoIngredients.add(bacon);
         toronfoIngredients.add(kebab);
         toronfoIngredients.add(chili);
 
         Pizza toronfo = new Pizza(9, "Toronfo", toronfoIngredients);
 
         List<Ingredient> capricciosaIngredients = new ArrayList<>();
         capricciosaIngredients.add(skinke);
         capricciosaIngredients.add(champignon);
 
         Pizza capricciosa = new Pizza(10, "Capricciosa", capricciosaIngredients);
 
         List<Ingredient> hawaiiIngredients = new ArrayList<>();
         hawaiiIngredients.add(skinke);
         hawaiiIngredients.add(ananas);
 
         Pizza hawaii = new Pizza(11, "Hawaii", hawaiiIngredients);
 
         List<Ingredient> leblissolaIngredients = new ArrayList<>();
         leblissolaIngredients.add(skinke);
         leblissolaIngredients.add(rejer);
 
         Pizza leblissola = new Pizza(12, "Le Blissola", leblissolaIngredients);
 
         List<Ingredient> veneziaIngredients = new ArrayList<>();
         veneziaIngredients.add(skinke);
         veneziaIngredients.add(bacon);
 
         Pizza venezia = new Pizza(13, "Venezia", veneziaIngredients);
 
         List<Ingredient> mafiaIngredients = new ArrayList<>();
         mafiaIngredients.add(pepperoni);
         mafiaIngredients.add(bacon);
         mafiaIngredients.add(loeg);
 
         Pizza mafia = new Pizza(14, "Mafia", mafiaIngredients);
 
         // tilføj Pizza'erne til en Menu pizzaMenu
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
 
        // create a string representation of the menu for the popup
StringBuilder menuString = new StringBuilder("Menu:\n");
for (Pizza pizza : pizzaMenu.getPizzas()) {
    menuString.append("Pizza ").append(pizza.getPizzaID())
              .append(": ").append(pizza.getName())
              .append(" - Pris: ").append(pizza.calculatePrice())
              .append("\nIngredienser: Tomatsauce, Ost, ");

    // Append each ingredient name from the list of ingredients
    for (Ingredient ingredient : pizza.getIngredients()) {
        menuString.append(ingredient.getIngredientName()).append(", ");
    }

    menuString.append("Oregano.");

    // spacing
    menuString.append("\n\n");
}

// display the menu in a popup window
JOptionPane.showMessageDialog(null, menuString.toString());


         // vis menuen i terminalen
         pizzaMenu.displayMenu();
     }

// customer test
{
    Customer customer1 = new Customer(1, "Cheese McDick", "123456969", true, "12 Cock st", 0);
    
    System.out.println("Customer ID: " + customer1.getId());
    System.out.println("Customer Name: " + customer1.getName());
    System.out.println("Customer Phone: " + customer1.getPhoneNumber());  
    System.out.println("Customer VIP: " + customer1.isVip()); 
    System.out.println("Customer Address: " + customer1.getAddress());
    System.out.println("Customer Order Count: " + customer1.getOrderCount());
    
    customer1.setName("Klaus Cockberg");
    customer1.setPhoneNumber("987654321");
    customer1.setVip(false);
    customer1.setAddress("456 Balls Ave");
    
    System.out.println("\nAfter updating customer details:");
    System.out.println("Updated Name: " + customer1.getName());  // Should print "Klaus Cockberg"
    System.out.println("Updated Phone: " + customer1.getPhoneNumber());  // Should print "987654321"
    System.out.println("Updated VIP: " + customer1.isVip());  // Should print false
    System.out.println("Updated Address: " + customer1.getAddress());  // Should print "456 Balls Ave"
    
    double originalPrice = 100.0;
    double discountedPrice = customer1.applyDiscount(originalPrice);
    System.out.println("\nPrice after discount: " + discountedPrice);  // Should print 100.0 (since VIP is false)
    
    customer1.setVip(true);
    discountedPrice = customer1.applyDiscount(originalPrice);
    System.out.println("Price after VIP discount: " + discountedPrice);
}

}
