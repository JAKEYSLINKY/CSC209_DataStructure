import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.*;

public class Menu{
    Food[] foods;
    int amoutOfFood;
    String filename;

    /**
     * 
     */
    public Menu(){
        foods = new Food[30];
        var amoutOfFood = 0;
        filename = "menu.dat";
    }

    public int addNewFood(Food newFood){
        foods[amoutOfFood] = newFood;
        amoutOfFood++;
        writeOneFoodToFile(newFood);
        return amoutOfFood;
    }

    public boolean removeFood(int foodID){
        for(int i = 0; i < amoutOfFood; i++){
            if(foods[i].ID == foodID ){
                for( int j = i; j < amoutOfFood; j++){
                    foods[j] = foods[j+1];
                }
                return true;

            }
        }
        return false;
    }
    public void showAllFood(){
        for (int i = 0; i < amoutOfFood; i++){
            System.out.print(foods[i].ID+")" + foods[i].name+" ");
        }
        System.out.println("");
    }

     // int ID; 4 bytes
    //String name; 20 bytes
    //String category; 20 bytes
    //double price; 8 bytes
    //int calories; 4 bytes
    //short star; 2 bytes
    //vector ingredients; 10*10(amount of ingredients) = 200 bytes
    //Therefore 1 recode = all combined = 258 bytes

    public boolean writeOneFoodToFile(Food food){
        try {
            RandomAccessFile fpointer = new RandomAccessFile(filename, "rw");
            fpointer.writeInt(food.ID);
            fpointer.seek(fpointer.length());
            
            
            //writename+ ID
            byte[] temp = new byte[30];
            String stName = "Suthasinee 65130500225";
            temp = stName.concat("                                              ").getBytes();
            fpointer.write(temp, 0, 30);



            temp = food.name.concat("                           ").getBytes();
            fpointer.write(temp, 0, 20);
            temp = food.category.concat("                                ").getBytes();
            fpointer.write(temp,0,20);
            if (food.category != null){
                temp = food.category.concat("                          ").getBytes();
            }
            else{
                temp = "".concat("                                 ").getBytes();
            }
            fpointer.writeDouble(food.price);
            fpointer.writeInt(food.calories);
            fpointer.writeShort(food.star);
            int i = 0,j;
            for (j=0; j < food.ingredients.size(); j++){
                String t = ((String)food.ingredients.elementAt(j));
                temp = t.concat("                                       ").getBytes();
                fpointer.write(temp, 0, 20);
            }
            for (i += j; i < 10; i++){
                temp = "                                 ".getBytes();
                fpointer.write(temp, 0, 20);

            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

}