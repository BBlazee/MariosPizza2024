/**
 * @ Anton
 * @ 21.september
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class Pizza {
     private int pizzaID;
     private String pizzaName;
     private static final int BASE_PRICE = 50;
     private List<Ingredient> ingredients;
 
     // constructor
     public Pizza(int pizzaID, String pizzaName, List<Ingredient> specificIngredients) {
         this.pizzaID = pizzaID;
         this.pizzaName = pizzaName;
         this.ingredients = new ArrayList<>(specificIngredients);
     }
 
     // beregn pris total (base + specifikke ingredienser)
     public int calculatePrice() {
         int totalPrice = BASE_PRICE;
         for (Ingredient ingredient : ingredients) {
             totalPrice += ingredient.getIngredientPrice();
         }
         return totalPrice;
     }
     
     // getters
     public int getPizzaID() {
         return pizzaID;
     }
 
     public String getName() {
         return pizzaName;
     }
 
     public List<Ingredient> getIngredients() {
         return ingredients;
     }
    
     // missing for Order class functionality
     public int getPrice() {
        return calculatePrice();
    }
 
     // vis en given pizza, kaldes i Menu klassen
     public void displayPizza() {
         System.out.println("Nummer: " + pizzaID);
         System.out.println("Pizza: " + pizzaName);
         System.out.println("Pris: " + calculatePrice());
         System.out.println("Ingredienser: Tomatsauce, Ost, Oregano, " + ingredients);
         System.out.println();
     }
 }
 