/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Nov 13, 2020 
 *  
 *  Description: Assignment #10 
 *  
 *  Purpose: Learn to use objects and classes as well as 
 *  creating an array of objects
 *  
 *  Synopsis: I will write a program that will contain 3 classes.
 *  My first class will be my main which will hold a test array for transactions.
 *  My second class will consist of creating the Transaction object.
 *  My third class will hold an array of transaction objects and will also find 
 *  the largest transaction within that array of objects.
 *  My program will then print all of the transactions and print the largest 
 *  transaction in both arrays.
 *   
*/

public class RodriguezTonyAssignment10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creating transactions array and manually filling it with transactions
		Transaction transactionArray1[] = new Transaction[7];
		transactionArray1[0] = new Transaction("Target", "Shopping", 77.50);
		transactionArray1[1] = new Transaction("Lowes", "Home", 190.00);
		transactionArray1[2] = new Transaction("Chegg", "Education", 14.95);
		transactionArray1[3] = new Transaction("Safeway", "Groceries", 132.50);
		transactionArray1[4] = new Transaction("AirBnB", "Travel", 630.00);
		transactionArray1[5] = new Transaction("Amazon", "Shoppping", 15.00);
		transactionArray1[6] = new Transaction("Ace", "Home", 24.95);
		
		System.out.println("********************************************************");
		System.out.println("\t\tTransactions in Array");
		System.out.println("********************************************************");
		
		System.out.println("\nMerchant\tCategory\tAmount");
		System.out.println("--------------------------------------------------------");
		
		
		//printing all of the the transactions in the transactions array
		for(int i = 0; i < transactionArray1.length; i++) {
			System.out.printf("%-15s%-17s%.2f\n", transactionArray1[i].getMerchant(), 
					transactionArray1[i].getCategory(), transactionArray1[i].getAmount());
		}//for loop
		
		
		//Variables that will be used to find the largest transaction
		int indexOfLargestNum = 0;
		double highestAmount = transactionArray1[0].getAmount();
		
		//Finding the largest transaction in the array of transactions
		for(int i = 0; i < transactionArray1.length; i++) {
			if(transactionArray1[i].getAmount() > highestAmount ) {
				highestAmount = transactionArray1[i].getAmount();
				indexOfLargestNum = i;
			}
		}
		
		//Printing the largest transaction in the array of transactions
		System.out.println("\nMost Expensive Transaction in the Array of Transactions");
		System.out.println("---------------------------------------------------------");
		System.out.printf("Merchant: %s", transactionArray1[indexOfLargestNum].getMerchant());
		System.out.printf("\nCategory: %s", transactionArray1[indexOfLargestNum].getCategory());
		System.out.printf("\nAmount: %.2f", transactionArray1[indexOfLargestNum].getAmount());
		
		
		
		
		//Creating credit card object
		CreditCard card1 = new CreditCard(10);
		
		//Adding transactions to the array in the credit card class from the 
		//array in main
		for(int i = 0; i < 7; i++) {
		card1.addTransaction(transactionArray1[i]);
		
	    }//for loop

		System.out.println("\n\n********************************************************");
		System.out.println("\t\tTransactions on Credit Card");
		System.out.println("********************************************************");
		
		System.out.println("\nMerchant\tCategory\tAmount");
		System.out.println("--------------------------------------------------------");
		
		
		//Displaying all of the transactions in the array within the credit card class
		card1.displayAllTransactions();
		
		
		
		//Printing the largest transaction in the credit card class
		System.out.println("\n\nMost Expensive Transaction on Credit Card");
		System.out.println("---------------------------------------------------------");
		System.out.printf("Merchant: %s", card1.findMostExpensiveTransaction().getMerchant());
		System.out.printf("\nCategory: %s", card1.findMostExpensiveTransaction().getCategory());
		System.out.printf("\nAmount: %.2f", card1.findMostExpensiveTransaction().getAmount());
		
		
	}//main

}//assignment10



//transactions class
class Transaction{
	
	//Instance variables 
	private String merchant; 
	private String category;
	private double amount;
	
	
	//Constructor 
	public Transaction(String transactionMerchant, String transactionCategory, double transactionAmount) {
		merchant = transactionMerchant;
		category = transactionCategory;
		amount = transactionAmount;
	}
	
	//will return the merchant in the specified transaction
public String getMerchant() {
		
	return merchant;
	}

//will return the category in the specified transaction
public String getCategory() {
	
	return category;
}

//will return the amount of the specified transaction
public double getAmount() {
	
	return amount;
}

}//Transaction Class



//Credit card class
class CreditCard{
	
	//Instance variables of array and the counter of transactions
	private Transaction[] transactionArray; 
	private int currentNumTransactions = 0;
	
	//constructor that gives the array its size and allocates memory for it
	   public CreditCard(int maxNumTransactions) {
		   
		   //Allocating memory for the array using the size that comes into 
		   //the constructor
		  transactionArray = new Transaction[maxNumTransactions]; 
		 
	   }
	   
	   
	   //Will add transaction to the array
	   	public void addTransaction (Transaction transactionToAdd) {
	   			
	   				//Adding transactions to each index of the transaction array
	   				transactionArray[currentNumTransactions] = transactionToAdd;
	   				currentNumTransactions++;
	   			
	   			
	   	}//add transaction
	   	
	   	    //This method will return the most expensive transaction in the array
	   		public Transaction findMostExpensiveTransaction() {
	   		
	   			//variables that will be used to compare transactions
	   			int indexOfLargestTransaction = 0;
	   			double largestTransactionAmount = transactionArray[0].getAmount();
	   			
	   			//Going through each index of the array and comparing each transaction to 
	   			//the largest transaction thus far
	   			for(int i = 0; i < 7; i++) {
	   				
	   				//if the current transaction is larger than the largest transaction,
	   				//the current transaction will be set to the largest transaction
	   				if(transactionArray[i].getAmount() > largestTransactionAmount ) {
	   					largestTransactionAmount = transactionArray[i].getAmount();
	   					indexOfLargestTransaction = i;
	   				}//if statement
	   				
	   			}//for loop
	   			
	   			return transactionArray[indexOfLargestTransaction];
	   		
	   		}//find most expensive transaction
	   		
	   		
	   		//this method will display all of the transactions within the array
	   		public void displayAllTransactions() {
	   			for (int i = 0; i < 7; i++) {
	   				System.out.printf("%-15s%-17s%.2f\n", transactionArray[i].getMerchant(), 
	   						transactionArray[i].getCategory(), transactionArray[i].getAmount());
	   			}//for loop
	   			
	   		}//display all transactions
	   		
	   	}//credit card class
	   	
	   	

