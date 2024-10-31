import java.util.Map;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

 IngredientDatabase.initializeIngredientsFile();

        // Load ingredients into a map
        Map<Integer, Ingredient> ingredientMap = IngredientDatabase.loadIngredients();

        // Initialize menu file with default pizzas if needed
        MenuDatabase.initializeMenuFile(ingredientMap);

        // Load menu using the ingredients map
        Menu pizzaMenu = new Menu();
        MenuDatabase.loadMenu(pizzaMenu, ingredientMap);

        // Display the loaded menu
        pizzaMenu.displayMenu();

        // create a string representation of the menu for the popup
StringBuilder menuString = new StringBuilder("Menu:\n");
for (Pizza pizza : pizzaMenu.getPizzas()) {
    menuString.append("Nummer ").append(pizza.getPizzaID())
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
     
// customer test

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
