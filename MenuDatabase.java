import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuDatabase {

    private static final String MENU_FILE = "menu.txt";

    // Initialize default pizzas if the menu file does not exist
    public static void initializeMenuFile(Map<Integer, Ingredient> ingredientMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE))) {
            // If menu.txt exists, just return (no need to initialize)
            System.out.println("menu.txt file found, no initialization needed.");
        } catch (FileNotFoundException e) {
            // File does not exist, so create it with default data
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(MENU_FILE))) {
                writer.write("1,Vesuvio,1\n");
                writer.write("2,Amerikaner,2\n");
                writer.write("3,Cacciatore,3\n");
                writer.write("4,Carbonara,4;5;6\n");
                writer.write("5,Dennis,1;3;6\n");
                writer.write("6,Bertil,7\n");
                writer.write("7,Silvia,3;8;9;10\n");
                writer.write("8,Victoria,11;12;9\n");
                writer.write("9,Toronfo,1;7;14;15\n");
                writer.write("10,Capricciosa,1;12\n");
                writer.write("11,Hawaii,1;11\n");
                writer.write("12,Le Blissola,1;13\n");
                writer.write("13,Venezia,1;7\n");
                writer.write("14,Mafia,3;7;9\n");
                System.out.println("menu.txt file created with default pizzas.");
            } catch (IOException ioException) {
                System.out.println("Error creating menu file: " + ioException.getMessage());
            }
        } catch (IOException e) {
            // Handles other IOExceptions that may occur during reading
            System.out.println("Error reading menu file: " + e.getMessage());
        }
    }

    // Load menu from file
    public static void loadMenu(Menu menu, Map<Integer, Ingredient> ingredientMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 3);

                int pizzaID = Integer.parseInt(data[0]);
                String pizzaName = data[1];
                
                // Parse ingredient IDs and lookup in ingredientMap
                List<Ingredient> ingredients = new ArrayList<>();
                String[] ingredientIDs = data[2].split(";");
                for (String idString : ingredientIDs) {
                    if (!idString.isEmpty()) {
                        int ingredientID = Integer.parseInt(idString);
                        Ingredient ingredient = ingredientMap.get(ingredientID);
                        if (ingredient != null) {
                            ingredients.add(ingredient);
                        }
                    }
                }

                // Create and add pizza to the menu
                Pizza pizza = new Pizza(pizzaID, pizzaName, ingredients);
                menu.addPizza(pizza);
            }
        } catch (IOException e) {
            System.out.println("Error loading menu: " + e.getMessage());
        }
    }
}