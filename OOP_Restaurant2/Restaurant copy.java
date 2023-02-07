public class Restaurant {
    public static void main(String[] args){
        Food padthai = new Food(1, "padthai",49, 200, (short) 4);

        System.out.println(padthai.toString());
        padthai.setCategory("noodle");
        padthai.addIngredient("shrimp");
        padthai.addIngredient("noodle");
        padthai.addIngredient("bean");
        padthai.addIngredient("egg");
        padthai.addIngredient("sugar");
        System.out.println(padthai.ingredients.elementAt(0)+ " "+ padthai.ingredients.elementAt(2)
        );

        Food tomyum = new Food(2, "Tomyum", 249.50, 500, (short) 5);

        tomyum.addIngredient("seafood");
        tomyum.addIngredient("shrimp");
        tomyum.addIngredient("lemon");
        tomyum.addIngredient("chill pepper");

        Food coke = new Food(3, "coke", 20, 150, (short) 3);

        Food pepsi = new Food(4, "pepsi", 20, 150, (short) 3);

        Food fanta = new Food(2, "fanta", 20, 150, (short) 2);

        Menu menu = new Menu();
        // menu.addNewFood(padthai);
        // menu.addNewFood(tomyum);
        // menu.addNewFood(pepsi);
        // menu.addNewFood(coke);
        // menu.addNewFood(fanta);
        // menu.showAllFood();
        //menu.removeFood(3);
         menu.showAllFood();
        menu.readAllRecord();

       boolean x =  menu.serchByName("Pepsi");
       System.out.println(x);

       menu.showNamePrice((short)3);

    }
}
