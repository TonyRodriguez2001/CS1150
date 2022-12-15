/* 
 Name: Tony Rodriguez 
 Class: CS1150 (T/R) 
 Due:  Sept 3, 2020  
 Description: Assignment #2  

 Synopsis:
 For this assignment I will create a “water intake calculator” that approximates 
 the amount of water required for two people who exercise. The program also computes 
 the differences between several values for these two people.  The amount of water a 
 person needs varies based on a number of different factors (i.e. temp, humidity, etc.).  
 For this assignment, I will limit the water approximation based on a person’s weight and exercise time.
*/ 

//Importing the scanner
import java.util.Scanner;

public class RodriguezTonyAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		
		Scanner input = new Scanner(System.in);
		
//Prompting for info for first person 
//-----------------------------------------------
		
		System.out.println("First Person");
		System.out.println("------------");
		
        //Prompting for and obtaining first person's name
		System.out.print("Enter 1st person's name: ");
		String namePerson1 = input.next();
		
		//Prompting for and obtaining first person's weight 
		System.out.println("\nPlease enter first person's weight: ");
		double person1Weight = input.nextDouble();
		
		//Prompting for and obtaining first person's exercise time
		System.out.println("\nPlease enter first person's exercise time in minutes: ");
		double person1ExerciseTime = input.nextDouble();
		
		
//Prompting for info for second person 
//-----------------------------------------------
		
		System.out.println("\n\nSecond Person");
		System.out.println("-------------");
		
		//Prompting and obtaining for second person's name
		System.out.println("Enter second person's name: ");
		String namePerson2 = input.next();
		
		//Prompting for and obtaining second person's weight
		System.out.println("\nPlease enter second person's weight: ");
		double person2Weight = input.nextDouble();
		
		//Prompting for and obtaining second person's exercise time
		System.out.println("\nPlease enter second person exercise time in minutes: ");
		double person2ExerciseTime = input.nextDouble();
		
		
//Mathematical Calculations
//*************************************
		//Constants
		final double DAILY_WATER_RATIO = 0.67;	
		final double OUNCES_PER_CUP = 8.0;

		//Ounces of water calculation
		double person1WaterOunces = person1Weight * DAILY_WATER_RATIO;
		double person2WaterOunces = person2Weight * DAILY_WATER_RATIO;
		
		//Converting Ounces to cups calculation
		double person1WaterCups = person1WaterOunces / OUNCES_PER_CUP;
		double person2WaterCups = person2WaterOunces / OUNCES_PER_CUP;
		
		//Exercise water ounces calculations
		double person1ExtraWaterOunces = person1ExerciseTime / 30 * 12;
		double person2ExtraWaterOunces = person2ExerciseTime / 30 * 12;
		
		//Converting exercise water ounces to cups
		double person1ExtraWaterCups = person1ExtraWaterOunces / OUNCES_PER_CUP;
		double person2ExtraWaterCups = person2ExtraWaterOunces / OUNCES_PER_CUP;
		
		//Calculating total daily water requirement
		double person1TotalDailyWater = person1WaterCups + person1ExtraWaterCups;
		double person2TotalDailyWater = person2WaterCups + person2ExtraWaterCups;
		
		//Calculating differences
		double differenceWeight = person1Weight - person2Weight;
		double differenceExercise = person1ExerciseTime - person2ExerciseTime;
		double differenceDailyWater = person1WaterCups - person2WaterCups;
		double differenceExerciseWater = person1ExtraWaterCups - person2ExtraWaterCups;
		double differenceTotalWater = person1TotalDailyWater - person2TotalDailyWater;
		
	
//Displaying output to the user
//***************************************
		
		//Structuring the table
		System.out.println("\n**************************************"
				+ "***********************************************");
		System.out.println("\t\t\t\tWater Intake Calculator");
		System.out.println("*****************************************"
				+ "********************************************");
		System.out.println("\nPerson\t\tweight\t\tExercise\tDaily Water\tExercise Water\tTotal Water");
		System.out.println("\t\t(lbs.)\t\t(minutes)\t(Cups)\t\t(Cups)\t\t(Cups)");
		System.out.println("------------------------------------------"
				+ "-------------------------------------------");
		
		//Printing output for person 1
		 System.out.printf("%s", namePerson1);
		 System.out.printf("\t\t%6.2f", person1Weight);
		 System.out.printf("\t\t%6.2f", person1ExerciseTime);
		 System.out.printf("\t\t%6.2f", person1WaterCups);
		 System.out.printf("\t\t%6.2f", person1ExtraWaterCups);
		 System.out.printf("\t\t%6.2f", person1TotalDailyWater);
		
		 //Printing output for person 2 
		 System.out.printf("\n%s", namePerson2);
		 System.out.printf("\t\t%6.2f", person2Weight);
		 System.out.printf("\t\t%6.2f", person2ExerciseTime);
		 System.out.printf("\t\t%6.2f", person2WaterCups);
		 System.out.printf("\t\t%6.2f", person2ExtraWaterCups);
		 System.out.printf("\t\t%6.2f", person2TotalDailyWater);
		 
		 System.out.println("\n**************************************"
					+ "***********************************************");
		 
		 //Printing differences using absolute 
		 System.out.printf("\nDifferences");
		 System.out.printf("\t");
		 System.out.print(Math.abs(differenceWeight));
		 System.out.printf("\t\t");
		 System.out.print(Math.abs(differenceExercise));
		 System.out.printf("\t\t");
		 System.out.print(Math.abs(differenceDailyWater));
		 System.out.printf("\t\t");
		 System.out.print(Math.abs(differenceExerciseWater));
		 System.out.printf("\t\t");
		 System.out.print(Math.abs(differenceTotalWater));

		 


	}

}
