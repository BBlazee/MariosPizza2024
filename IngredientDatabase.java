
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IngredientDatabase {
    private static final String INGREDIENT_FILE = "ingredients.txt";

    // Initialize predefined ingredients if the file is missing
    public static void initializeIngredientsFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INGREDIENT_FILE))) {
            // If ingredients.txt exists, the method completes without doing anything
            System.out.println("ingredients.txt file found, no initialization needed.");
        } catch (FileNotFoundException e) {
            // File does not exist, so create it with default ingredients data
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(INGREDIENT_FILE))) {
                writer.write("1,Skinke,7\n");
                writer.write("2,Oksefars,5\n");
                writer.write("3,Pepperoni,7\n");
                writer.write("4,Koedsauce,6\n");
                writer.write("5,Spaghetti,3\n");
                writer.write("6,Cocktailpoelser,4\n");
                writer.write("7,Bacon,7\n");
                writer.write("8,Roed Peber,3\n");
                writer.write("9,Loeg,3\n");
                writer.write("10,Oliven,4\n");
                writer.write("11,Ananas,6\n");
                writer.write("12,Champignon,4\n");
                writer.write("13,Rejer,8\n");
                writer.write("14,Kebab,6\n");
                writer.write("15,Chili,4\n");
                System.out.println("ingredients.txt file created with default ingredients.");
            } catch (IOException ioException) {
                System.out.println("Error creating ingredients file: " + ioException.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading ingredients file: " + e.getMessage());
        }
    }

    // Load ingredients from file
    public static Map<Integer, Ingredient> loadIngredients() {
        Map<Integer, Ingredient> ingredients = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INGREDIENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int ingredientID = Integer.parseInt(data[0]);
                String name = data[1];
                int price = Integer.parseInt(data[2]);
                ingredients.put(ingredientID, new Ingredient(ingredientID, name, price));
            }
        } catch (IOException e) {
            System.out.println("Error loading ingredients: " + e.getMessage());
        }
        return ingredients;
    }
}