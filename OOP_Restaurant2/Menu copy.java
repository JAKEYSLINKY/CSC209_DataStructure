import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //  int ID; 4 bytes
    // String name; 20 bytes
    // String category; 20 bytes
    // double price; 8 bytes
    // int calories; 4 bytes
    // short star; 2 bytes
    // vector ingredients; 10*10(amount of ingredients) = 200 bytes
    // Therefore 1 recode = all combined = 258 bytes


    public boolean serchByName(String nameFood){
        try {
        RandomAccessFile fptr = new RandomAccessFile(filename,"r");
        //fptr is point to byte number 0;
        byte[] temp = new byte[20];
        // fptr.seek(4);
        // fptr.read(temp, 0, 20);
        // System.out.println(new String(temp)+ " ");

        // fptr.seek(fptr.getFilePointer()+258-20);
        // // mv the current location (end of first name)
        // //for 258 bytes (get us the end of second name)
        // //then mv back 20 bytes (get us the beginning of the second name )
        //     fptr.read(temp, 0, 20);
        //     System.out.println(new String(temp)+ " ");

        //     fptr.seek(258 + 4);
        //     //mv pointer to the end of first record
        //     //then move back 20 bytes
        //     fptr.read(temp, 0, 20);
        //     System.out.println(new String(temp)+ "");

        //     fptr.seek(258*2+4);
        //     fptr.read(temp, 0,20);
        //     System.out.println();



        ///
        int record = 0;
        while( fptr.getFilePointer() < fptr.length()){
            fptr.seek(258*record+4); //seek to position of the next record  skip to the one record at a time
            fptr.read(temp, 0, 20);
            String foodNameFromFile = new String(temp).trim();
            if(foodNameFromFile.equalsIgnoreCase(nameFood)){
               // fptr.seek(fptr.getFilePointer()+20);
                fptr.seek(258*record+4+20+20);
                double price = fptr.readDouble();
                System.out.println("Price of " + nameFood + " is " + price);
                return true;
            }
            record++;

            }

            ///


            fptr.close();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void showNamePrice(short fromStar){
        try {
            RandomAccessFile fpt = new RandomAccessFile(filename, "r");
            byte[] temp = new byte[20];

            for (int record = 0; fpt.getFilePointer()<fpt.length()-257; record++){
                fpt.seek(record*258+56); //get to star of the next record
                short starFromFile = fpt.readShort();
                if(starFromFile >= fromStar){
                    fpt.seek(record*258+4);
                    fpt.read(temp, 0, 20);
                    fpt.seek(record*258+44);
                    double price = fpt.readDouble();
                    System.out.println((new String(temp)).trim()+":"+ price);

                }
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void readAllRecord(){
        try {
            RandomAccessFile fptr = new RandomAccessFile(filename,"r");
            while(fptr.getFilePointer() < fptr.length() ){
                byte[] temp = new byte[20];
                int id = fptr.readInt();
                System.out.println(id + " ");
                fptr.read(temp, 0, 20);
                System.out.println( new String(temp) + " ");
                fptr.read(temp, 0, 20);
                System.out.print(new String(temp) + " ");
                double p = fptr.readDouble(); //price
                int cal = fptr.readInt(); //calories
                short star = fptr.readShort();
                //int star = fptr.readInt(); //error bc star is short not int
                System.out.println(p+" "+ cal+" "+ star+" ");
                //read10ingredients
                String ingredient=" ";
                for( int i = 0; i < 10; i++){
                    fptr.read(temp, 0, 20);
                    ingredient += new String(temp).trim()+", ";
                }
                System.out.println(ingredient);



            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public boolean writeOneFoodToFile(Food food){
        try {
            RandomAccessFile fpointer = new RandomAccessFile(filename, "rw");
            fpointer.seek(fpointer.length());


            //writename+ ID
            byte[] temp = new byte[30];
            // String stName = "Suthasinee 65130500225";
            // temp = stName.concat("                                              ").getBytes();
            //fpointer.write(temp, 0, 30);


            fpointer.writeInt(food.ID);
            temp = food.name.concat("                           ").getBytes();
            fpointer.write(temp, 0, 20);
            //temp = food.category.concat("                                ").getBytes();
            if (food.category != null){
                temp = food.category.concat("                          ").getBytes();
            }
            else{
                temp = "".concat("                                 ").getBytes();
            }
            fpointer.write(temp,0,20);
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


