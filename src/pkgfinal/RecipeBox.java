/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
* Program that creates a RecipeBox in which to store a collection 
* of Recipes and their Ingredients 
* Use as driver class for final submission.
* 
* 
* @author Joy Meredith
* @version 1.0 for Final Project Submission
 */
public class RecipeBox extends Recipe {
        
    protected ArrayList<Recipe> listOfRecipes = new ArrayList();
        
        /**
         * 
         * @return list of recipes
         */
        public ArrayList<Recipe> getListOfRecipes() {
            return listOfRecipes;
        }
        
        /**
         * 
         * @param listOfRecipes list of recipes
         */
        public void setListOfRecipes(ArrayList<Recipe> listOfRecipes){
            this.listOfRecipes = listOfRecipes;
        }
	
        /**
         * Default constructor for RecipeBox
         */
	public void RecipeBox(){
            this.listOfRecipes = new ArrayList<Recipe>();
        }
        
        /**
         * Constructs a recipe box.
         * @param listOfRecipes list of recipes
         */
        public void RecipeBox(ArrayList<Recipe> listOfRecipes){
            this.listOfRecipes = listOfRecipes;
        } 
        
        /**
         * Prints recipe details.
         * 
         * @param selectedRecipe 
         */
	public void printAllRecipeDetails(String selectedRecipe) {
 
           int i=0;
           for(i=0; i<listOfRecipes.size(); i++) {
               if(listOfRecipes.get(i).getRecipeName().equals(selectedRecipe)){ 
                   Recipe currentRecipe = listOfRecipes.get(i);
                   currentRecipe.printRecipe();
               }
           }
        }
        
        /**
         * Prints list of recipe names.
         */
        public void printAllRecipeNames() {
            int i = 0;
            for (i = 0; i < listOfRecipes.size(); i++) {
                  System.out.println(listOfRecipes.get(i));
            }
            System.out.println(""); //an extra blank space 
        }
        
        /**
         * Creates a new recipe.
         */
        public void addNewRecipe() {
            Recipe tempRecipe = new Recipe();
            tempRecipe.createNewRecipe();
            listOfRecipes.add(tempRecipe);   
        }
        
        /**
         * Delete a recipe from the collection.
         * 
         * @param selectedRecipe 
         */
        public void deleteRecipe(String selectedRecipe) {
             int i=0;
           for(i=0; i<listOfRecipes.size(); i++) {
               if(listOfRecipes.get(i).getRecipeName().equals(selectedRecipe)){ 
                   Recipe currentRecipe = listOfRecipes.get(i);
                   listOfRecipes.remove(i);
               }
           }
        }
	
	
	/**
         * Prompts user to select from Menu options to add recipe,
         * print recipe details, or print list of all
         * recipe names.
         * 
         * This can be used as the driver class for final submission
         * 
         * @param args command-line arguments
         * 
         */
	public static void main(String[] args) {
    	    		
	RecipeBox myRecipeBox = new RecipeBox(); 
        Scanner menuScnr = new Scanner(System.in);
        
        /*
        * Selection Menu
        * 1 creates a new recipe and adds it to the collection
        * 2 prompts user for the recipe name to print recipe details
        * 3 prints list of all recipe names
        * 4 deletes a recipe from the collection, user must enter the recipe name
        */
        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "Please select a menu item:");
        
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            
            int input = menuScnr.nextInt();
            
                if (input == 1) {
                    myRecipeBox.addNewRecipe();
                } 
                else if (input == 2) {
                    System.out.println("Which recipe?\n");
                    String selectedRecipeName = menuScnr.next();
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName);
                    //user must type the recipe name for the recipe they want to display
                    //currently case sensitive
                } 
                else if (input == 3) {		
                    for (int j = 0; j < myRecipeBox.listOfRecipes.size(); j++) { 
                        System.out.println((j + 1) + ": " + myRecipeBox.listOfRecipes.get(j).getRecipeName());
                    }
                } 
                else if (input ==4) {
                    System.out.println("Which recipe?\n");
                    String deleteRecipeName = menuScnr.next();
                    myRecipeBox.deleteRecipe(deleteRecipeName);
                }
                else {
                System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "Please select a menu item:");
                }
			
                System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "Please select a menu item:");
		}

	}

}



        