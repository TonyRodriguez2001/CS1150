/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Sept 24, 2020 
 *  
 *  Description: Assignment #4 
 *  
 *  Purpose: Learn to use the Math random method 
 *  and manipulate char and String input
 *  
 *  Synopsis: I will create a program that creates 
 *  gift cards based on the restaurant chosen and 
 *  gift card option.
 */
 
import java.util.Scanner;

public class RodriguezTonyAssignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
     
		
		//Defining Constants
        final char CHIPOTLE = 'C';
        final char TACO_BELL = 'T';
        final char OLIVE_GARDEN = 'O';
        final char SELECTION1 = '1';
        final char SELECTION2 = '2';
        final char SELECTION3 = '3';
        
        
		//Printing options
	     System.out.println("Enter two characters");
         System.out.println("C: Chipotle T: Taco Bell O: Olive Garden");
         System.out.println("1: One $10 gift card 2: One $15 gift card 3: 3-pack of $15 gift cards");
     
        //Obtaining selections from user
         String inputString = input.next();
         
         //Turning input string to upper case and making a new string 
         String selectionString = inputString.toUpperCase();
         
         
         //Variables and boolean expressions 
         //extracting the characters from string and turning them to char
         char restaurantSelection = selectionString.charAt(0); 
         char giftCardSelection = selectionString.charAt(1);
         boolean VALID_INPUT1 = false;
         boolean VALID_INPUT2 = false;
         String restaurantSelected = "";
         String giftCardSelected = "";
         
         
         //Checking if restaurantSelection is valid
         if ((restaurantSelection >= 'A') && (restaurantSelection <= 'Z'))
         {
        	 
        	if(restaurantSelection == CHIPOTLE) {
        		restaurantSelected = "Chipotle";
        		VALID_INPUT1 = true;
        	}
        	else if(restaurantSelection == TACO_BELL) {
        		restaurantSelected = "Taco Bell";
        		VALID_INPUT1 = true;
        	}
        	else if(restaurantSelection == OLIVE_GARDEN) {
        		restaurantSelected = "Olive Garden";
        		VALID_INPUT1 = true;
        	}
        	//Printing error message and stopping the program
        	else {
           	 System.out.println("Invalid input for restaurant selected.");
            }
            
         }
         
         //Checking if giftCardSelection is valid and setting the boolean expression accordingly
         if ((giftCardSelection >= SELECTION1) && (giftCardSelection <= SELECTION3) )
    	 {
        	 
    		 if(giftCardSelection == SELECTION1) {
    			 giftCardSelected = "One $10 gift card";
    			 VALID_INPUT2 = true;
    		 }
    		 else if(giftCardSelection == SELECTION2)
    		 {
    			 giftCardSelected = "One $15 gift card";
    			 VALID_INPUT2 = true;
    		 }
    		 else if(giftCardSelection == SELECTION3) {
    			 giftCardSelected = "3-pack of $15 gift cards";
    			 VALID_INPUT2 = true;
    		 }
    	 }
         //Printing error message program no longer runs b/c boolean expressions
         else {
    		 System.out.println("Invalid input for amount selected.");
    	 }
		 
		 
         if(VALID_INPUT1 && VALID_INPUT2 == true) {
        	 
    		 
        	//if restaurant selected = chipotle
        		 if(restaurantSelected == "Chipotle") {
        			 
        			//Creating temporary variables for random numbers and letters
        			 int randomNum1 = 100 + (int) (Math.random() * 900);
            		 int randomNum2 = 1000 + (int) (Math.random() * 9000);
            		 char randomLet1 = (char) (65 + Math.random() * 25);
            		 char randomLet2 = (char) (65 + Math.random() * 25);
            		 char randomLet3 = (char) (65 + Math.random() * 25);
            		 
        			 switch(giftCardSelection) {
        			 case '1':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("%d-%c%c%c-%d", randomNum1, randomLet1, randomLet2, randomLet3, randomNum2);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 case '2':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("%d-%c%c%c-%d", randomNum1, randomLet1, randomLet2, randomLet3, randomNum2);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 case '3':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("%d-%c%c%c-%d", randomNum1, randomLet1, randomLet2, randomLet3, randomNum2);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 }
        			
        			 
        		 }
        		 
        		 
            //if restaurant selected = taco bell
        		 else if(restaurantSelected == "Taco Bell") {
        			 
        			//Creating temporary variables for random numbers and letters		 
        			 int randomNum1 = 0 + (int) (Math.random() * 10);
            		 int randomNum2 = 9 + (int) (Math.random() * 91);
            		 int randomNum3 = 100 + (int) (Math.random() * 900);
            		 
            //printing info according to the cases
        			 switch(giftCardSelection) {
        			 case '1':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("TB%d %d %d", randomNum1, randomNum2, randomNum3);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 case '2':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("TB%d %d %d", randomNum1, randomNum2, randomNum3);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 case '3':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("TB%d %d %d", randomNum1, randomNum2, randomNum3);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 }
        			
        			 
        		 }
        		 
        		 
           //if the restaurant selected = olive garden
                 else if(restaurantSelected == "Olive Garden") {
        			 
           //Creating temporary variables for random numbers and letters
                	 int randomNum1 = 9 + (int) (Math.random() * 91);
            		 char randomLet1 = (char) (65 + Math.random() * 25);
            		 char randomLet2 = (char) (65 + Math.random() * 25);
            		 char randomLet3 = (char) (65 + Math.random() * 25);
            		 char randomLet4 = (char) (65 + Math.random() * 25);
            		 char randomLet5 = (char) (65 + Math.random() * 25);
            		 char randomLet6 = (char) (65 + Math.random() * 25);
            		 
            		 
            		 //Printing info according to the cases
        			 switch(giftCardSelection) {
        			 case '1':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("%c%c%c%c%d%c%c", randomLet1, randomLet2, randomLet3, randomLet4, 
        						 randomNum1, randomLet5, randomLet6);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 case '2':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("%c%c%c%c%d%c%c", randomLet1, randomLet2, randomLet3, randomLet4, 
        						 randomNum1, randomLet5, randomLet6);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 case '3':
        				 System.out.printf("%s: ", restaurantSelected);
        				 System.out.printf("%c%c%c%c%d%c%c", randomLet1, randomLet2, randomLet3, randomLet4, 
        						 randomNum1, randomLet5, randomLet6);
        				 System.out.printf("  (%s)", giftCardSelected);
        				 break;
        			 }
        			
        			 
        		 }

        		 
        		 
         }
         
	}

}
