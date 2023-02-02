/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs209;

/**
 *
 * @author Student
 */
public class vaccine {
    private String name;
    private String preventedDisease;
    private String company;
    private double dose;

    public vaccine(String name, String preventedDisease) {
        this.name = name;
        this.preventedDisease = preventedDisease;
    }

    public vaccine(String name, String preventedDisease, String company, double dose) {
        this.name = name;
        this.preventedDisease = preventedDisease;
        this.company = company;
        this.dose = dose;
    }

    public vaccine(String name, String preventedDisease, String company) {
        this.name = name;
        this.preventedDisease = preventedDisease;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreventedDisease() {
        return preventedDisease;
    }
