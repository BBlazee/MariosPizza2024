/**
 * @ Anton
 * @ 21.september
 */

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private List<Pizza> pizzas;

// constructor der initialiserer menuen med en tom ArrayList [pizzas]
public Menu() {
    this.pizzas = new ArrayList<>() 
    }

    // metode med et for-each loop der viser hver [Pizza] i [pizzas]-listen
public void displayMenu() {
    System.out.println("Menu:");
    for (Pizza pizza : pizzas) {
        pizza.displayPizza();
    }
}
   // get metode
public List<Pizza> getPizzas() {
    return pizzas;
}

}