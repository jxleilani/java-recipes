/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Recipe class is used to create recipes to be stored 
 * in the recipe collection.
 * 
 * @author joyle
 */
public class Recipe {
     
    protected String recipeName; 
    //protected variables can be accessed by derived classes and other classes in same package
    private int servings;
    private ArrayList<Ingredient> recipeIngredients;
    private double totalRecipeCalories;
    private ArrayList<String> recipeInstructions;

    /**
     * @return recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName recipe name
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return amount of servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return recipe ingredients
     */
    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients 
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return total recipe calories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories 
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
   

    /**
     * Default constructor for a Recipe
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<Ingredient>();
        this.totalRecipeCalories = 0;
        this.recipeInstructions = new ArrayList<String>();
    }
    /**
    * Constructor for a Recipe with parameters
    * @param recipeName recipe name
    * @param servings recipe servings
    * @param recipeIngredients recipe ingredients
     * @param recipeInstructions recipe instruction steps
    * @param totalRecipeCalories total recipe calories
    */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, ArrayList<String> recipeInstructions, double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.recipeInstructions = recipeInstructions;
    }
    
    /**
     * Prints the full recipe including name, servings, list of ingredients,
     * list of instructions, total calories, and total calories per serving.
     */
    public void printRecipe() {
        double singleServingCalories = 0;
        System.out.println("Recipe: " + recipeName);
        System.out.println("Yield: " + servings + " servings");
        System.out.println("Ingredients:");
        
         for (int i = 0; i < recipeIngredients.size(); i++) {
            Ingredient currentIngredient = recipeIngredients.get(i);
            String currentIngredientName = currentIngredient.getNameOfIngredient();
            System.out.println(currentIngredientName);
        }
        
         /* System.out.println("Total Calories per Ingredient: ");
           for (int i = 0; i < recipeIngredients.size(); i++) {
            Ingredient currentIngredient = recipeIngredients.get(i);
            double currentIngredientAmt = currentIngredient.getTotalCalories();
            System.out.println(currentIngredientAmt);
        } //I used this to figure out how to do Total Calories per serving
         */

        
        System.out.println("Instructions: ");
        for (int j = 0; j < recipeInstructions.size(); j++) {
            String instructions = recipeInstructions.get(j);
            System.out.println((j+1) +". " + instructions);
	}
            
            for (int i = 0; i < recipeIngredients.size(); i++) {
            Ingredient currentIngredient = recipeIngredients.get(i);
            double ingredientAmount = currentIngredient.getNumberCups();
            int ingredientCalories = currentIngredient.getNumberCaloriesPerCup();
            double ingredientTotalCalories = (ingredientAmount * ingredientCalories);
            totalRecipeCalories += ingredientTotalCalories;
            singleServingCalories = (totalRecipeCalories / servings);
                 
            }
            System.out.println("Total Calories: " + totalRecipeCalories);
            System.out.println("Total Calories Per Serving: " + singleServingCalories);
            System.out.println(""); //an extra blank space in between lines
    }

    /**
     * Prompts user to create a recipe.
     * 
     * @return new recipe
     */
    public Recipe createNewRecipe() { 
        double totalRecipeCalories = 0;
        ArrayList<Ingredient> recipeIngredients = new ArrayList();
        boolean addMoreIngredients = true;
        boolean addMoreInstructions = true;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter the recipe name: ");
        this.recipeName = scnr.nextLine();

        System.out.println("Please enter number of servings: ");
        this.servings = scnr.nextInt();
        
        //Prompt user with option to enter ingredients
        do {
            System.out.println("Do you want to enter a new ingredient? Please type yes or no: ");
            String ingredientName = scnr.next();
            if (ingredientName.toLowerCase().equals("no")) {
                addMoreIngredients = false;
            }
            
            else if (ingredientName.toLowerCase().equals("yes")){
                Ingredient tempIngredient = new Ingredient().addIngredient(ingredientName);
                this.recipeIngredients.add(tempIngredient);
            }
            else{
                    System.out.println("Please enter yes or no");
                    }
        } while (addMoreIngredients);
        
        //Prompt user with option to enter instructions
        do {
            System.out.println("Do you want to enter instruction steps? Please type yes or no: ");
            String stepsYesNo = scnr.next();
            if (stepsYesNo.toLowerCase().equals("no")) {
                addMoreInstructions = false;
            }
            
            else if (stepsYesNo.toLowerCase().equals("yes")){
                addSteps();
               
            }
            else{
                    System.out.println("Please enter yes or no");
                    }
        } while (addMoreInstructions);
        
        
        
        Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, recipeInstructions, totalRecipeCalories);
                
        return newRecipe;
    }
       
    /**
     * Prompts user to enter recipe instructions.
     */ 
    public void addSteps() {
       String tempInstructions = "";
       Scanner scnr = new Scanner(System.in);
       
       System.out.println("Please enter instructions: ");
       tempInstructions = scnr.nextLine();
       
       recipeInstructions.add(tempInstructions);
       }
}