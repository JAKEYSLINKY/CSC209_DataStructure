/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs209;

/**
 *
 * @author Student
 */
public class Cs209 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        pet p1 = new pet("Leub",111,"female");
        System.out.println(p1.name + " " + p1.getGender());      
        pet p2 = new pet("Deng",112,"Mixing");
        System.out.println(p2.name + " " + p2.getGender());
        p2.setGender("Mixer");
    System.out.println(p2.name + " " + p2.getGender());
    p1.setType("crocodile");
        System.out.println(p1.name + " " + p1.getType());
    
    vaccine v1 = new vaccine("Gk26", "coVid", "Pfisu", 5);
    vaccine v2 = new vaccine("GT11", "cancer", "Moderne", 100);
        System.out.println(v2.getCompany() + " " + v2.getDose());
        p1.vaccinate(v2);
        p1.vaccinate(v1);
        System.out.println(p1.getVaccineCount());
        System.out.println(p2.getVaccineCount());
        p1.showAllPreventDisease();
        p2.showAllPreventDisease();
        
            }
