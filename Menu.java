/**
 * @ Anton
 * @ 21.september
 */

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private List<Pizza> pizzas;


public Menu() {
    this.pizzas = new ArrayList<>() 
    }

public void displayMenu() {
    System.out.println("Menu:");
    for (Pizza pizza : pizzas) {
        pizza.displayPizza();
    }
}

public List<Pizza> getPizzas() {
    return pizzas;
}

}