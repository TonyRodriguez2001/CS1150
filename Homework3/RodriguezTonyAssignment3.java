
/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Sept 17, 2020 
 *  
 *  Description: Assignment #3 
 *  
 *  Synopsis: Learn to use boolean expressions,
 *  relational and logical operators and if
 *  statements. I will create a simple Fitness Gym 
 *  that allows a user to select a membership, 
 *  possible add-ons, and view the final costs. 
 *  My program displays the type of membership 
 *  the user selects, any “add on” that is selected, 
 *  the enrollment fee, and total cost. The program 
 *  must handle invalid selections 
 */
import java.util.Scanner;

public class RodriguezTonyAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Importing Scanner
		Scanner input = new Scanner(System.in);
		
		//Defining membership prices as constants
		final double PLATINUM_MEMBERSHIP = 29.99;
		final double GOLD_MEMBERSHIP = 19.99;
		final double BASIC_MEMBERSHIP = 9.99;
		
		// Defining add on prices as constants
		final double NO_ADD_ON = 0.00;
		final double CHILDCARE = 5.00;
		final double PERSONAL_TRAINING = 15.00;
		
		//Defining enrollment fee constant 
		final double ENROLLMENT_FEE = 15.00;
		
		//Printing membership menu
		System.out.println("CS 1150 Fitness Gym\n");
		System.out.println("Option\t  Membership\tMonthly Cost");
		System.out.println("--------------------------------------");
		System.out.printf("1\t  Platinum\t$%.2f\n", PLATINUM_MEMBERSHIP);
		System.out.printf("2\t  Gold\t\t$%.2f\n", GOLD_MEMBERSHIP);
		System.out.printf("3\t  Basic\t\t$%.2f\n", BASIC_MEMBERSHIP);
		
		//Prompting for and obtaining the users selection
		System.out.println("Select a membership: 1, 2, or 3:");
		int selection = input.nextInt();
		
		//Using memebershipCost to store value of selected constant
		//Using boolean variable as the condition for the following series of nested if statements
		//using the string to store name of selected membership
		double membershipCost = 0.00;
		boolean VALID_INPUT = false;
		String membershipType = "";
		
		//Determining if input is valid or not
		if (selection >= 1 && selection <= 3) {
			
			//will be used to run the next series of nested if statements if true
			VALID_INPUT =  true;
			
			//Running through options to check selection
			if (selection == 1) {
				membershipCost = PLATINUM_MEMBERSHIP;
				membershipType = "Platinum Membership";
			}
			else if (selection == 2) {
				membershipCost = GOLD_MEMBERSHIP;
				membershipType = "Gold Membership";
			}
			else if (selection == 3) {
				membershipCost = BASIC_MEMBERSHIP;
				membershipType = "Basic Membership";
			}
		}
		//Printing the error if input is not valid
		else {
			System.out.printf("%d is not a valid input. Please restart the program, good bye!", selection);
		}
		
		
		//Using the boolean variable as the condition for next series of if statements
		boolean VALID_ADD_ON = false;
		// addOnSlection will store the user selection
		int addOnSelection = 0; 
		
		//Following code will NOT run if VALID_INPUT is false
		if (VALID_INPUT) {
			
			//Printing the add on menu
			System.out.println("Option\t\tAdd On\t\tPrice");
			System.out.println("--------------------------------------");
			System.out.printf("1\t  No Add On\t\t$%.2f\n", NO_ADD_ON);
			System.out.printf("2\t  Childcare\t\t$%.2f\n", CHILDCARE);
			System.out.printf("3\t Personal Training\t$%.2f\n", PERSONAL_TRAINING);
			
			//Obtaining desired add on
			System.out.println("\nSelect 1, 2, or 3:");
			addOnSelection = input.nextInt();
			
			if(addOnSelection >= 1 && addOnSelection <= 3) {
				VALID_ADD_ON = true;
			}
			
			//printing error if user does not select valid add on 
			else {
				System.out.printf("%d is not a valid input. Please restart the program, good bye!", addOnSelection);
			}
		}
		
		//Using the addOnCost to store the value of the constant chosen
		//Using the string to store the name of the add on chosen
		double addOnCost = 0.00;
		String addOnType = "";
		
		//Following code will not run if VALID_ADD_ON is false
		if(VALID_ADD_ON) {
			
			//Checking for selected add on 
			if(addOnSelection == 1) {
				addOnCost = NO_ADD_ON;
				addOnType = "No Add On";
			}
			else if (addOnSelection == 2) {
				addOnCost = CHILDCARE;
				addOnType = "Childcare";
			}
			else if (addOnSelection == 3) {
				addOnCost = PERSONAL_TRAINING;
				addOnType = "Personal Training";
			}
			
			// calculating total cost 
			double totalCost = membershipCost + addOnCost + ENROLLMENT_FEE;
			// Printing totals for the user
			System.out.println("------------------------------");
			System.out.println("Monthly Costs");
			System.out.println("------------------------------");
			System.out.printf("%s \t $%.2f \n", membershipType, membershipCost);
			System.out.println("\n");
			System.out.println("------------------------------");
			System.out.println("One Time Costs");
			System.out.println("------------------------------");
			System.out.printf("%s \t$%.2f\n", addOnType, addOnCost);
			System.out.printf("Enrollment Fee\t\t$%.2f\n", ENROLLMENT_FEE);
			System.out.println("------------------------------");
			System.out.println("Due Today");
			System.out.println("------------------------------");
			System.out.printf("Total Cost \t\t$%.2f", totalCost);
		}
	}

}
