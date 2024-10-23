/**
 * @ Anton
 * @ 22.september
 */

public class Ingredient {
    private int ingredientID;
    private String ingredientName;
    private int ingredientPrice;


    public Ingredient(int ingredientID, String name, int price) {
        this.ingredientID = ingredientID;
        this.ingredientName = name;
        this.ingredientPrice = price;
    }

    // getters
    public int getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getIngredientPrice() {
        return ingredientPrice;
    }

    // Overrider toString(), som er en metode alle klasser nedarver fra Java (Object klassen), til at return ingrediensens navn i stedet for dens hash code.
    // dette betyder, at f.eks. System.out.println(tomatsauce) vil output "Tomatsauce", i stedet for volapyk som "Ingredient@5e91993f".
    @Override
    public String toString() {
        return ingredientName;
    }
}