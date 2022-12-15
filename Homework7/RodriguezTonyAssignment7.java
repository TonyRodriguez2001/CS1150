/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Oct 16, 2020 
 *  
 *  Description: Assignment #7 
 *  
 *  Purpose: Learn to use methods
 *  
 *  Synopsis: Write a program that 
 *  simulates an app for a driver of 
 *  Uber, Lift, etc. For this simulation, 
 *  the program will randomly generate the 
 *  following values: Number of passengers, 
 *  distance to destination, and average speed.
 *  When the user is done making trips, the 
 *  program will print the totals for the day.
 */


import java.util.Scanner;

public class RodriguezTonyAssignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Driver Details App\n");
		
		
		//first prompt determines if the while loop will run
		boolean selection = pickupPassengers(input);
		
		
		//These variables store the totals after every iteration 
		int totalNumTrips = 0;
		int totalPassengers = 0;
		int totalMiles = 0;
		double totalNumMinutes = 0.00;
		double totalFare = 0.00;
		
		//While the user chooses to make trips
		while (selection) {
		
			
		    int numPassengers = numberOfPassengers( );
		    
		    totalPassengers += numPassengers;
			
			int numMiles = milesToDestination();
			
			totalMiles += numMiles;
			
			int speed = averageMilesPerHour();
			
			double travelTime = computeMinutesToDestination(numMiles, speed);
			
			totalNumMinutes += travelTime;
			
			double fare = computeFare(numPassengers, numMiles, travelTime);
			
			totalFare += fare;
			
			displayTripDetails(numPassengers, speed, 
				     numMiles, travelTime, fare);
			
			totalNumTrips++;
			
			selection = pickupPassengers(input);
			
		}//selection loop
		
		//displays total after user selects no
		displayTotalResults(totalNumTrips, totalPassengers, totalMiles, totalNumMinutes, totalFare);
		
		//closing scanner
		input.close();
		
	}//main
	
	
	// Randomly generate the number of passengers for the trip (between 1 and 5)
	public static int numberOfPassengers( ) {
		
		int numPassengers = (int) (Math.random() * 5) + 1;
		
		return numPassengers;
		
	}//numberOfPassengers method
	
	
	// Randomly generate the number of miles for the trip (between 1 and 20 miles)
	public static int milesToDestination() {
		
		int distance = (int) (Math.random() * 20) + 1;
		
		return distance;
		
	}//milesToDestination method
	
	
	// Randomly generate average miles per hours for trip (between 30 mph and 60 mph)
	public static int averageMilesPerHour() {
		
		int speed = (int) (Math.random() * 31) + 30;
		
		return speed;
		
	}//averageMilesPerHour method
	
	
	// Compute number of minutes for trip based on miles to destination and average mpg
	public static double computeMinutesToDestination(int milesToDestination, double averageMph) {
		
		final int SECONDS_IN_MINUTE = 60;
		double travelTime = (milesToDestination / averageMph) * SECONDS_IN_MINUTE; 
		
		return travelTime;
		
	}//computeMinutesToDestination method
	
	
	// Compute the fare for the trip
	public static double computeFare(int numPassengers, int numMiles, double numMinutes) {
		
		//Constants holding the value of prices
		final double BASE_FARE = 7.50;
		final double COST_PER_MILE = 1.50;
		final double COST_PER_MINUTE = 0.30;
		final double EXTRA_PASSENGER_FEE = 1.00;
		
		//Calculating different costs
		double costForMiles = (double) numMiles * COST_PER_MILE;
		double costForMinutes = (double) numMinutes * COST_PER_MINUTE;
		double costForPassengers = 0.00;
		
		
		if (numPassengers >= 3)
		{
			costForPassengers = EXTRA_PASSENGER_FEE * numPassengers;
		}
		
		double totalFare = costForMiles + costForMinutes + costForPassengers;
		
		if(totalFare < 7.50)
		{
			totalFare = BASE_FARE;
		}
		
		else {
			totalFare += BASE_FARE;
		}
		
		return totalFare;
		
	}//computeFare method
	
	
	// Displays the results for one trip 
	public static void displayTripDetails(int numPassengers, int averageMph, 
						     int numMiles, double numMinutes, double fare) {
		
		System.out.println("***********************************************");
		System.out.println("\t\tCurrent Trip Details");
		System.out.println("***********************************************");
		System.out.printf("\nNumber of passengers:\t%d", numPassengers);
		System.out.printf("\nAverage MPH:\t\t%d", averageMph);
		System.out.printf("\nNumber of Miles:\t%d", numMiles);
		System.out.printf("\nNumber of minutes:\t%.1f", numMinutes);
		System.out.printf("\nCollected fare:\t\t$%.2f", fare);
		System.out.println("\n-----------------------------------------------");
		
	}//displayTripDetails method
	
	
	//Displays results for all trips
	public static void displayTotalResults(int totalNumTrips, int totalNumPassengers, 
			int totalNumMiles, double totalNumMinutes,         
			double totalFare) {
		
		System.out.println("***********************************************");
		System.out.println("\t\tTotals For Today");
		System.out.println("***********************************************");
		System.out.printf("\nTotal number of trips:      %d", totalNumTrips);
		System.out.printf("\nTotal number of passengers: %d", totalNumPassengers);
		System.out.printf("\nTotal number of miles:      %d", totalNumMiles);
		System.out.printf("\nTotal number of minutes:    %.1f", totalNumMinutes);
		System.out.printf("\nTotal collected fare:       $%.2f", totalFare);
		System.out.println("\n-----------------------------------------------");
		
	}//displayTotalResults method
	
	
	// Prompt user about continuing
	public static boolean pickupPassengers(Scanner input) {
		
		boolean pickUpPassenger = false;
		
		System.out.println("Pick up passengers (Y/N)?");
		String option = input.next();
		
		char selection = option.toLowerCase().charAt(0);
		
		if(selection == 'y')
		{
			pickUpPassenger = true;;
		}
		
		else if(selection == 'n')
		{
			pickUpPassenger = false;
		}
		
		//Invalid user input will run the loop an re-prompt the user for valid input
		while ((selection != 'y') && (selection != 'n') )
		{
			System.out.printf("\n%c is not a valid entry - try again", selection);
			System.out.println("\n\nPick up passengers (Y/N)?");
			option = input.next();
			
			selection = option.toLowerCase().charAt(0);
			
			if(selection == 'y')
			{
				pickUpPassenger = true;;
			}
			
			else if(selection == 'n')
			{
				pickUpPassenger = false;
			}
		}
		return pickUpPassenger;

	}//pickupPassengers method
	
}//class

