/**
 * @ Anton
 * @ 21.september
 */

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizza> pizzas;

// constructor der initialiserer menuen med en tom ArrayList [pizzas]
    public Menu() {
        this.pizzas = new ArrayList<>();
    }

    // metoder til at tilføje og fjerne [Pizza]'er fra [pizzas]
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
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