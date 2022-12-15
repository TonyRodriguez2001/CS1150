/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Dec 3, 2020 
 *  
 *  Description: Assignment #12 
 *  
 *  Purpose: Learn to use inheritance 
 *  and polymorphism and read from a file
 *  
 *  Synopsis: I will write a program that will create a 
 *  polymorphic array of animals with their characteristics 
 *  read from a file. The animals will consist 
 *  of bears, penguins, wolves, and panthers. All of the 
 *  animals will be subclasses of the animal super class
 *   and various animals will have their own overridden 
 *   methods. These methods will be called for each animal 
 *   in the array. 
 */


import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class RodriguezTonyAssignment12 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Setup the file reference variable to refer to the text file
				File inputFileName = new File("assignment12.txt");
				
				// Open the file for reading by creating a scanner for the file
				Scanner inputFile = new Scanner (inputFileName);
			
				
		//polymorphic array that will hold the animals
		Animal[] arrayOfAnimals = new Animal[5];
		
		
		//Loop will iterate through file checking the type of animal
		//specified and create that animal within the array
		for(int i = 0; i < arrayOfAnimals.length; i++) {
			
			
			//going through file and reading it for 
			//properties of the animals 
			String type = inputFile.next();
			String name = inputFile.next();
			double weight = inputFile.nextDouble();
			String food = inputFile.next();
			String location = inputFile.next();
			
			
			//creating the specified animal in the array  
			if(type.equals("Panther")) {
				arrayOfAnimals[i] = new Panther(name, weight, food, location);
			}
			
			else if(type.equals("Penguin")) {
				arrayOfAnimals[i] = new Penguin(name, weight, food, location);
			}
			
			else if(type.equals("Bear")) {
				arrayOfAnimals[i] = new Bear(name, weight, food, location);
			}
			
			else if(type.equals("Wolf")) {
				arrayOfAnimals[i] = new Wolf(name, weight, food, location);
			}
			
			
		}//for loop
		
		
		//Iterating through the array and 
		//printing all of the animals to the console
		for(int i = 0; i < arrayOfAnimals.length; i++) {
			
			String type = "";
			
			//check the type of each animal and creating 
			//a variable that will hold the type to print
			if(arrayOfAnimals[i] instanceof Panther) {
				type = "Panther";
			}
			
			else if(arrayOfAnimals[i] instanceof Penguin) {
				type = "Penguin";
			}
			
			else if(arrayOfAnimals[i] instanceof Bear) {
				type = "Bear";
			}
			
			else if(arrayOfAnimals[i] instanceof Wolf) {
				type = "Wolf";
			}
			
			
			//printing the animals using the toString method
			System.out.printf("arrayOfAnimals[%d] is a %s\n", i, type);
			System.out.printf("%s", arrayOfAnimals[i].toString());
			
			
			//calling the methods for each animal
			arrayOfAnimals[i].eat();
			arrayOfAnimals[i].sleep();
			arrayOfAnimals[i].swim();
			
			System.out.println();
			
		}//for loop
		
		
		
	}//main

}//Assignment12



//animal superclass
class Animal{
	
	
	//instance variables that will be 
	//Inherited by all of the animals
	private String name;
	private double weight;
	private String food;
	private String location;
	
	
	//animal constructor
	public Animal(String name, double weight, String food, String location) {
		
		this.name = name;
		this.weight = weight; 
		this.food = food;
		this.location = location;
	}
	
	//getter that returns the name
	public String getName() {
		return name;
	}
	
	//getter that returns the weight
	public double getWeight() {
		return weight;
	}
	
	//getter that returns the food
	public String getFood() {
		return food;
	}
	
	//getter that returns the location 
	public String getLocation() {
		return location;
	}
	
	//methods
	public void eat() {
		System.out.println("\nAnimal is eating.");
	}
	
	public void sleep()  {
		System.out.println("Animal is sleeping - do not disturb");
	}
	
	public void swim() {
		System.out.println("Animal is swimming");
	}
	
}//animal



//panther subclass
class Panther extends Animal {

    public Panther(String name, double weight, String food, String location) {
        super(name, weight, food, location);
    }
    
    //overriding the eat method
    @Override
	public void eat() { 
    	System.out.println("\nPanther is eating Meat.");
    } 
    
    //overriding the sleep method
    @Override
    public void sleep(){
    	System.out.println("Panther is Sleeping.");
    }
    
    //overriding the toString method 
    @Override
	public String toString() {
    	return "Panther: Name: " + getName() + " - weighs: " + getWeight() + "lbs" + " - location: " + getLocation();
	}
    
   } // Panther



//penguin subclass
class Penguin extends Animal {

    public Penguin(String name, double weight, String food, String location) {
        super(name, weight, food, location);
    }
    
    //overriding the eat method
    @Override
    public void eat() {
    	System.out.println("\nPenguin is eating - Seafood");
    }
    
    //overriding the swim method
    @Override
    public void swim() {
    	System.out.println("Penguin is swimming.");
    }
    
  //overriding the toString method 
    @Override
	public String toString() {
    	return "Penguin: Name: " + getName() + " - weighs: " + getWeight() + "lbs" + " - location: " + getLocation();	
	}

} // Penguin Class



//bear subclass
class Bear extends Animal {

    public Bear(String name, double weight, String food, String location) {
        super(name, weight, food, location);
        
    }
    
    //overriding the eat method
    @Override
    public void eat() {
    	System.out.println("\nBear is eating - Honey");
    }
    
    //overriding the sleep method
    @Override
    public void sleep() {
    	System.out.println("Bear is sleeping.");
    }
    
    //overriding the swim method
    @Override
    public void swim() {
    	System.out.println("Bear is swimming.");
    }
    
    //overriding the toString method 
    @Override
	public String toString() {
    	return "Bear: Name: " + getName() + " - weighs: " + getWeight() + "lbs" + " - location: " + getLocation();	
	}

} // Bear Class



//wolf subclass
class Wolf extends Animal {

    public Wolf(String name, double weight, String food, String location) {
        super(name, weight, food, location);
    }
    
    //overriding the toString method 
    @Override
  	public String toString() {
      	return "Wolf: Name: " + getName() + " - weighs: " + getWeight() + "lbs" + " - location: " + getLocation();	
  	}
    
} // Wolf Class

