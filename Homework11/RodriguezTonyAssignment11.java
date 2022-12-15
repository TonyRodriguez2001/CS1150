/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Nov 20, 2020 
 *  
 *  Description: Assignment #11 
 *  
 *  Purpose: Learn more about objects and how to write to a file.
 *  
 *  Synopsis: I will write a program that will bring in an array 
 *  of cars and run a simulation on those car objects to determine 
 *  the order that the cars run out of gas. The objects will include 
 *  an odometer and a fuel gauge that will be used for the simulation.  
 *   
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class RodriguezTonyAssignment11 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		//Array that hold 5 cars
		Car[] mainCarArray = new Car[5];
		
		//adding all of the car objects to the array
		createCars(mainCarArray);
		
		//writing the cars to a file 
		writeCarDetailsToFile(mainCarArray); 
		
		//printing the cars to the console
		System.out.println("Cars at the start of the simulation:");
		printCars(mainCarArray);
		
		//creating array that will hold the empty cars
		Car[] emptyCarsArray = new Car[5];
		
		//counter that will allow me to add the empty cars in order to the empty cars array
		int index = 0;
		
		
		//while loop will run the simulation while cars still have gas
		while(!checkFuelLevels(mainCarArray)) {
			
			//for loop is accessing all of the cars in the array
			for(int i = 0; i < mainCarArray.length; i++) {
				
				//calculating the amount of fuel that it takes a car to go 11 mile based on its fuel economy
				double fuelFor1Mile = 1 / mainCarArray[i].getMpg();
					
				//if the car has enough fuel to go 1 mile
				if(mainCarArray[i].getFuelGauge().getGallons() > fuelFor1Mile) {
						
						//decrementing the amount of fuel that the car has by the amount for 1 mile
					mainCarArray[i].getFuelGauge().decrementGallons(fuelFor1Mile);
						
						//incrementing the odometer after every iteration by 1 mile
					mainCarArray[i].getOdometer().incrementMiles(1.0);
						
				}
					
				//else statement will run and add car to empty cars array if it has ran out of gas
				else if (!mainCarArray[i].getFuelLevel().equals("Empty")){
					
					//setting the car object into empytcars array 
					mainCarArray[i].setFuelLevel("Empty");
					emptyCarsArray[index] = mainCarArray[i];
					index++;
				}
				
			}//for loop
			
			
		}//while loop
		
		
		//printing the cars in the order that they ran out of gas
		System.out.println("\n\nThe cars ran out of gas in this order:");
		System.out.println("-------------------------------------------------------------------------");
		
		for(int i = 0; i < emptyCarsArray.length; i++) {
			System.out.printf("Ran out of gas: %s\n", emptyCarsArray[i].getOwner());
		}
		
		
		//printing the cars that were run through the simulation
		System.out.println("\n\nCars at the end of the simulation:");
		
		printCars(mainCarArray);
	
	}//main

	
	
	// Create the cars for the simulation based on the assignment sheet table
	  	public static void createCars(Car[] cars) {
	  		
	  		//car objects that will be placed into the array 
	  		cars[0] =  new Car ("Shrek", "Toyota Tundra", 15.00, 6.00, 20000.00);
	  		cars[1] = new Car ("Fiona", "Audi Q7", 21.00, 10.00, 8270.00);
	  		cars[2] = new Car ("Donkey", "Jeep CJ5", 14.00, 5.00, 11800.00);
	  		cars[3] = new Car ("Farquaad", "Smart car", 42.00, 4.00, 710.00);
	  		cars[4] = new Car ("Dragon", "Chevy Suburban", 12.00, 30.00, 10800.00);
	 
	  	}
	  	
	  	

	 // Print the details for each car in the array 
    	public static void printCars(Car[] cars) {
    		
    		//printing the cars that were in the array that the method is called for
    		System.out.println("-------------------------------------------------------------------------");
    		System.out.println("Owner\t\tBrand\t\tFuel Economy  Gallons\tMileage");
    		System.out.println("-------------------------------------------------------------------------");
    		for(int i = 0; i < cars.length; i++) {
    			System.out.printf("%-15s%-17s%-15.2f%-10.2f%.2f\n", cars[i].getOwner(), cars[i].getModel(), 
    					cars[i].getMpg(), cars[i].getFuelGauge().getGallons(), cars[i].getOdometer().getMiles());
    		}
    	}

    	
    	
    // Returns true if all the cars are out of gas, otherwise false
    	public static boolean checkFuelLevels(Car[] cars) {
    		
    		
    		
    		boolean carsAreEmpty = false;
    		
    		int numberOfEmptyCars = 0;
    		for(int i = 0; i < cars.length; i++) {
    			
    			//if the car is empty
    			if(cars[i].getFuelLevel().contentEquals("Empty")) {
    				numberOfEmptyCars++;
    				
    				//if all cars are empty
    				if(numberOfEmptyCars == 5) {
    					carsAreEmpty = true;
    				}
    			}
    		}
    		
    		//return true when all cars are out of fuel
    		return carsAreEmpty;
    	}

    	
    	
    // Print the details for each car in the cars array to a file
    	public static void writeCarDetailsToFile(Car[] cars) throws IOException {
    		
    		// Setup the file reference variable to refer to the text file.
    		// Assignment11.txt is the file that will be created on your hard drive.
    		File fileName = new File("Assignment11.txt");
    		
    		// Create the file that the cars will be written to. 
    // This means connect Assignment11.txt on your hard drive to the 
    // variable resultsFile in the code.
    		PrintWriter resultsFile = new PrintWriter (fileName);
    		
    		// Write the details for each car to the file
    		resultsFile.println("Car Details");
    		for (int i = 0; i < cars.length; i ++) {
    		   resultsFile.println(cars[i].getOwner());
    		   resultsFile.println(cars[i].getModel());
    		   resultsFile.println(cars[i].getMpg());
    		   resultsFile.println(cars[i].getFuelGauge().getGallons());
    		   resultsFile.println();
    		}
    		resultsFile.close();

    		// Shows where the file is located on your hard drive
    		System.out.println("\nFind the file here " + fileName.getAbsolutePath());
    		System.out.println();
    	}//write car details to file
	
	
}//assignment11



class Car{

	//Instance variables (details) 
	private String owner;
	private String model;
	private Double mpg;
	private String fuelLevel;
	private Odometer odometer;
	private FuelGauge fuelGauge;
	
	
	
	//Constructor
	public Car (String owner, String model, double mpg, double gallons, double mileage) {
		this.owner = owner;
		this.model = model;
		this.mpg = mpg;
		this.fuelLevel = "Has Gas";
		odometer = new Odometer(mileage);
		fuelGauge = new FuelGauge(gallons);
		
		
	}
	
	
	//Getters
	public String getOwner(){
		
		return owner;
		
	}
	
	//Getters
	public String getModel() {
		
		return model;
		
	}
	public double getMpg() {
		
		return mpg;
	}
	public FuelGauge getFuelGauge() {
		
		return fuelGauge;
	}
	
	public String getFuelLevel() {
		
		return fuelLevel;
	}
	
	public Odometer getOdometer() {
		return odometer;
	}

	//fuel level setter
	public void setFuelLevel(String fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	
}//car



class FuelGauge {
	
	   private double gallons;
	   
	   
	   //constructor
	   public FuelGauge (double gallons) {
		   
		   this.gallons = gallons;
		   
	   }
	   
	   //getter
	   
	   public double getGallons() {
		   
		   return gallons;
	   }
	   
	   
	   //decrements gallons by the number of gallons used
	  	public void decrementGallons(double gallonsUsed) {
	  		if(gallons >= gallonsUsed) {
	  			gallons -= gallonsUsed;
	  		}
	  		else {
	  			gallons = 0.00;
	  		}
	  	}//decrement gallons
	  	
	} // FuelGauge



class Odometer {
	
	   private double miles;
	   
	   
	   //constructor
	   public Odometer (double mileage) {
		   this.miles = mileage;
	   }
	   
	   public double getMiles() {
		   
		   return miles;
	   }
	   
	   
	   //increments the odometer by the number of miles traveled
	   public void incrementMiles(double milesTraveled) {
		   miles += milesTraveled;
	   }
	} // Odometer
