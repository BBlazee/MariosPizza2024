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

    @Override
    public String toString() {
        return ingredientName;
    }
}