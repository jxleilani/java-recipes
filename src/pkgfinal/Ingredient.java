/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.Scanner;

/**
 * The Ingredient class stores information for ingredients
 * that will be included in recipes and stored as part of
 * a collection of recipes.
 * 
 * @author Joy Meredith
 */   
public class Ingredient {
    private String nameOfIngredient;
    private double numberCups;
    private int numberCaloriesPerCup;
    private double totalCalories;
    
    
    /**
     * @return the name of the ingredient
     */
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    /**
     * @param nameOfIngredient ingredient name
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    /**
     * @return the number of cups of the ingredient
     */
    public double getNumberCups() {
        return numberCups;
    }

    /**
     * @param numberCups number of cups
     */
    public void setNumberCups(float numberCups) {
        this.numberCups = numberCups;
    }

    /**
     * @return the number of calories per cup of the ingredient
     */
    public int getNumberCaloriesPerCup() {
        return numberCaloriesPerCup;
    }

    /**
     * @param numberCaloriesPerCup number of calories per cup
     */
    public void setNumberCaloriesPerCup(int numberCaloriesPerCup) {
        this.numberCaloriesPerCup = numberCaloriesPerCup;
    }

    /**
     * @return the total calories for the ingredient
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    /**
     * @param totalCalories total calories
     */
    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
    
    /**
     * Default constructor for an Ingredient
     */
    public Ingredient() {
        this.nameOfIngredient = "";
        this.numberCups = 0;
        this.numberCaloriesPerCup = 0;
        this.totalCalories = 0.0;
    }
    
    /**
     * Create an ingredient
     * 
     * @param nameOfIngredient name of the ingredient
     * @param numberCups number of cups of ingredient
     * @param numberCaloriesPerCup number of calories per cup
     * @param totalCalories total calories
     */
    public Ingredient(String nameOfIngredient, double numberCups, 
        int numberCaloriesPerCup, double totalCalories) {
        this.nameOfIngredient = nameOfIngredient;
        this.numberCups = numberCups;
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.totalCalories = totalCalories;
    }
    
    /**
     * Creates a new ingredient by prompting the user to enter the name,
     * number of cups, and calories per cup of the ingredient.
     * 
     * @param tempNameOfIngredient name of ingredient
     * @return new ingredient
     */
    public Ingredient addIngredient(String tempNameOfIngredient) {
       nameOfIngredient = tempNameOfIngredient;
       double tempNumberCups;
       int tempNumberCaloriesPerCup;
       double tempTotalCalories; 
       Scanner scnr = new Scanner(System.in);
       
       System.out.println("Please enter the name of the ingredient: ");
       tempNameOfIngredient = scnr.next();
       
       System.out.println("Please enter the number of cups of " + tempNameOfIngredient + " we'll need: ");
       tempNumberCups = scnr.nextDouble();
       
       System.out.println("Please enter the number of calories per cup: ");
       tempNumberCaloriesPerCup = scnr.nextInt();
       
       tempTotalCalories = tempNumberCups * tempNumberCaloriesPerCup;
       
       totalCalories = tempTotalCalories;
       
       Ingredient tempNewIngredient = 
               new Ingredient(tempNameOfIngredient,
                       tempNumberCups, tempNumberCaloriesPerCup,
                       tempTotalCalories);
        return tempNewIngredient;
    }
    
}
    
    