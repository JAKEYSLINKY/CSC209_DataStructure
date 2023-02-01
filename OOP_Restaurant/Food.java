import java.util.Vector;

//package restuarant;

public class Food{
    int ID;
    String name;
    String category;
    double price;
    int calories;
    short star;
    Vector ingredients;
    public Food(int ID, String name, double price, int calories, short star){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.star = star;
        ingredients = new Vector(10);
    }
    public void setCategory(String category){
        String[] validCategory = {"noddle", "appertize", "beef", "pork", "vegatarian", "chicken", "seafood", "dessert", "drink"};
        for(String a: validCategory){
            if (category.equalsIgnoreCase(a)){
                this.category = category;
                return;
            }
        }
        System.out.println("Not valid category");
    }

    public int addIngredient(String newIngredients){
        ingredients.add(newIngredients);
        return ingredients.size();
    }

    public String toString(){
        return name+" of "+ price + "baht with "+ star +"*.";
    }
   

}