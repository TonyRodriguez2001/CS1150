/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Oct 9, 2020 
 *  
 *  Description: Assignment #6 
 *  
 *  Purpose: Learn to use loops - while and for.  
 *  Learn to combine if statements, while, and for loops.
 *  
 *  Synopsis: I will write a program to determine password strength.  
 *  For this assignment, password strength will be based on 
 *  password entropy, which is a measurement of how predictable 
 *  a password is. My program will ask the user for a password, 
 *  compute the password entropy, then display the password, 
 *  its length, entropy, and strength.
 */


import java.util.Scanner;
public class RodriguezTonyAssignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("*************************************************");
		System.out.println("\tWelcome To The Password Tester");
		System.out.println("*************************************************\n");
		System.out.println("Password Entropy\t\tPassword Strength");
		System.out.println("-------------------------------------------------");
		System.out.println("Less than 28 bits\t\tVery Weak");
		System.out.println("28 - 35 Bits\t\t\tWeak");
		System.out.println("36 - 59 Bits\t\t\tReasonable");
		System.out.println("60 - 127 Bits\t\t\tStrong");
		System.out.println("Greater than 127 Bits\t\tVery Strong");
		System.out.println("-------------------------------------------------");
		
		//Constants that will be used to determine password strength 
		final int VERY_WEAK = 27;
		final int WEAK_LOWER_BOUND = 28;
		final int WEAK_UPPER_BOUND = 35;
		final int REASONABLE_LOWER_BOUND = 36;
		final int REASONABLE_UPPER_BOUND = 59;
		final int STRONG_LOWER_BOUND = 60;
		final int STRONG_UPPER_BOUND = 127;
		final int VERY_STRONG = 128;
	    
		//Using this boolean expression for the outer loop
		boolean outerLoop = true;
		
		//Counter will count number of passwords tested
		int passwordCounter = 0;
		
		
		//Outer loop will continue until user selects exit
		while (outerLoop)
		{
			//Printing menu 
			System.out.println("\n\nSelect an option:");
			System.out.println("-------------------------------------------------");
			System.out.println("1) Test password");
			System.out.println("2) Exit");
			System.out.println("Select menu option 1 or 2: ");
			
			int optionSelection = input.nextInt();
			
			//Setting booleans to false will change them according to the selection 
			boolean testPassword = false;
			
			
			//Changing booleans according to the selection for the required loop
			if (optionSelection == 1)
			{
				testPassword = true;
			}
			else if (optionSelection == 2) 
			{
				outerLoop = false;
			}
			
			
			//While loop that will handle invalid user input 
			while ((optionSelection < 1) || (optionSelection > 2))
			{
				//Prompting for user input
				System.out.println("Invalid entry. Enter 1 or 2:");
				optionSelection = input.nextInt();
				
				//Changing booleans according to the selection for the required loop
				if (optionSelection == 1)
				{
					testPassword = true;
				}
				else if (optionSelection == 2) 
				{
					outerLoop = false;
				}
				
			}//Invalid user input loop
			
			
			//Loop that that runs when user selects to test a password
			while (testPassword)
			{
				System.out.println("Enter a password to test: ");
				String password = input.next();
				
				//Determining the length of the password string
				int passwordLength = password.length();
				
				//Will count the number of alphanumeric characters 
				//Will then compare it to number of total characters
				int alphanumericCounter = 0;
				
				//Going through each index checking to check if characters are alphanumeric
				for (int i = 0; i < password.length(); i++)
				{
					
					char evaluatedChar = password.charAt(i);
					
					if((evaluatedChar >= '0') && (evaluatedChar <= '9'))
					{
						alphanumericCounter++;
					}
					else if((evaluatedChar >= 'A') && (evaluatedChar <= 'Z'))
					{
						alphanumericCounter++;
					}
					else if((evaluatedChar >= 'a') && (evaluatedChar <= 'z'))
					{
						alphanumericCounter++;
					}
					
				}//for loop
				
				
				//Comparing number of alphanumeric characters to number of total characters
				//to determine if the password is completely alphanumeric
				if (alphanumericCounter == passwordLength)
				{
					//Calculation of the password entropy
					double entropyFormula = Math.pow(62, (double) passwordLength);
					double entropy = Math.log(entropyFormula)/ Math.log(2);
					
					//Storing the strength of the password in  string
					String passwordStrength = "";
					
					if (entropy < VERY_WEAK)
					{
						passwordStrength = "Very Weak";
					}
					else if ((entropy >= WEAK_LOWER_BOUND) && (entropy <= WEAK_UPPER_BOUND))
					{
						passwordStrength = "Weak";
					}
					else if ((entropy >= REASONABLE_LOWER_BOUND) && (entropy <= REASONABLE_UPPER_BOUND))
					{
						passwordStrength = "Reasonable";
					}
					else if ((entropy >= STRONG_LOWER_BOUND) && (entropy <= STRONG_UPPER_BOUND))
					{
						passwordStrength = "Strong";
					}
					else if (entropy >= VERY_STRONG)
					{
						passwordStrength = "Very Strong";
					}
					
					//Printing the output
					System.out.printf("\nPassword: %s", password);
					System.out.printf("\nLength: %d", passwordLength);
					System.out.printf("\nEntropy: %.2f", entropy);
					System.out.printf("\nStrength: %s", passwordStrength);
					
					//incrementing password counter and breaking out of password loop
					passwordCounter++;
					testPassword = false;
					
				}//Alpha-numeric check
				
				//error statement for  non-alphanumeric password
				else
				{
					System.out.println("Password contains non-alphanumeric characters");
				}
				
				
				
			}//test password loop
		
		}//outer loop
		
		//good bye statement and printing number of passwords tested
		System.out.printf("Number of passwords tested: %d", passwordCounter);
		System.out.println("\nThank you for using the password tester!");
		
		//closing scanner
		input.close();
	}//main

}//class
