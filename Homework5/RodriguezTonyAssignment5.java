/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Oct 1, 2020 
 *  
 *  Description: Assignment #5 
 *  
 *  Purpose: Learn to use while loops as well 
 *  as learning how to handle invalid user input using them.
 *  
 *  Synopsis: I will create a program that generates scratch off tickets.
 *  The user will select enter the number of scratch off tickets
 *  then number will be generated to determine how many winners they have.
 *  They will then see the probability that they had of winning. 
 */


import java.util.Scanner;

public class RodriguezTonyAssignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Scratch Ticket Game\n");
		
		//Creating bounds for valid number of tickets
		final int upperBound = 20;
		final int lowerBound = 0;
		
		System.out.println("How many scratch tickets would you like to buy?");
		int numOfTickets = input.nextInt();
		
		//Using while loop to handle invalid user input
		while ((numOfTickets <= lowerBound) || (numOfTickets > upperBound))
		{
			System.out.printf("\n%d is not a valid number of tickets, please reenter.", numOfTickets);
			System.out.println("\nHow many scratch tickets would you like to buy?");
		    numOfTickets = input.nextInt();
		}
		
		
		System.out.println("\nGenerating Scratch Tickets...\n");
		System.out.println("Outcome\t\tWinning # \t Scratch Ticket Numbers");
		System.out.println("-----------------------------------------------------------");
		
		
		//counters for number of loops ran and number of winning tickets
		int counter = 0;
		int numOfWinners = 0;
		
		
		while(counter < numOfTickets)
		{
			//Temporary variables
			//generating random numbers for tickets
			 int randomWinningNum = (int) (Math.random() * 60) + 1;
			 int randomNum1 = (int) (Math.random() * 60) + 1;
			 int randomNum2 = (int) (Math.random() * 60) + 1;
			 int randomNum3 = (int) (Math.random() * 60) + 1;
			 int randomNum4 = (int) (Math.random() * 60) + 1;
			
			
			String winnerOrLoser = "Loser";
			
			//Used multiway if statements because switch statement can only handle constant cases
			if(randomWinningNum == randomNum1) {
				winnerOrLoser = "Winner";
				numOfWinners++;
			}
			else if(randomWinningNum == randomNum2) {
				winnerOrLoser = "Winner";
				numOfWinners++;
			}
			else if(randomWinningNum == randomNum3) {
				winnerOrLoser = "Winner";
				numOfWinners++;
			}
			else if(randomWinningNum == randomNum4) {
				winnerOrLoser = "Winner";
				numOfWinners++;
			}
			
			System.out.printf("%s\t\t%d\t\t%d\t%d\t%d\t%d\n", winnerOrLoser, randomWinningNum, 
					randomNum1, randomNum2, randomNum3, randomNum4);
			counter++;
			
		}
		
		
		//Calculating win probability
		double winProbability = (100 / (double) numOfTickets) * (double) numOfWinners;
		
		System.out.printf("\nOut of %d scratch tickets you had %d winners.", numOfTickets, numOfWinners);
		System.out.printf("\nProbability of winning %f%%", winProbability);
		
	}

}
