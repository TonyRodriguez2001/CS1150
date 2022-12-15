/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Nov 6, 2020 
 *  
 *  Description: Assignment #9 
 *  
 *  Purpose: More practice with methods and arrays
 *  
 * I will write a program to manipulate arrays by creating arrays, 
 * filling arrays with values, displaying arrays, combining 
 * arrays, sorting arrays and finding a missing number.    
 */

import java.util.Arrays;
public class RodriguezTonyAssignment9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//The 2 arrays that will be combined
		int[] array1 = {9, 29, 19, 4, 15, 1, 10, 12, 28, 14, 5, 3, 21, 22, 27, 13, 2};
		int[] array2 = {16, 7, 18, 24, 6, 17, 8, 23, 11, 25, 26, 30};
		
		final int TEST_1_LOWER_BOUND = 1;
		final int TEST_1_UPPER_BOUND = 30;
		
		System.out.println("*****************************");
		System.out.println("Test #1 Original Arrays");
		System.out.println("*****************************");

		//displaying the sorted combined array 
		displayArray (combineArrays (array1, array2), "Combined Array Test #1");
		
		//finding the missing number in the sorted combined array and printing it
		System.out.printf("\n\nMissing Value = %d",
				findMissingNumber (combineArrays (array1, array2), TEST_1_LOWER_BOUND, TEST_1_UPPER_BOUND));
		
		//The 2 arrays that will be combined
		int[] array3 = {29, 19, 15, 28, 21, 22, 27};
		int[] array4 = {16, 18, 24, 17, 23, 25, 26, 20};
		
		final int TEST_2_LOWER_BOUND = 15;
		final int TEST_2_UPPER_BOUND = 30;
		
		System.out.println("\n\n*****************************");
		System.out.println("Test #2 Original Arrays");
		System.out.println("*****************************");
		
		//displaying the sorted combined array 
		displayArray (combineArrays (array3, array4), "Combined Array Test #2");
		
		//finding the missing number in the sorted combined array and printing it
		System.out.printf("\n\nMissing Value = %d", 
				findMissingNumber (combineArrays (array3, array4), TEST_2_LOWER_BOUND, TEST_2_UPPER_BOUND));
		
		
		//The 2 arrays that will be combined
		int[] array5 = {16, 21, 18, 15, 19, 20, 25};
		int[] array6 = {22, 23, 17};
		
		final int TEST_3_LOWER_BOUND = 15;
		final int TEST_3_UPPER_BOUND = 25;
		
		System.out.println("\n\n*****************************");
		System.out.println("Test #3 Original Arrays");
		System.out.println("*****************************");
		
		//displaying the sorted combined array 
		displayArray (combineArrays (array5, array6), "Combined Array Test #3");
		
		//finding the missing number in the sorted combined array and printing it
		System.out.printf("\n\nMissing Value = %d", 
				findMissingNumber (combineArrays (array5, array6), TEST_3_LOWER_BOUND, TEST_3_UPPER_BOUND));
		
		
		//The 2 arrays that will be combined
		int[] array7 = {16, 20, 18, 14, 19, 13};
		int[] array8 = {11, 15, 17, 12};
		
		final int TEST_4_LOWER_BOUND = 10;
		final int TEST_4_UPPER_BOUND = 20;

		System.out.println("\n\n*****************************");
		System.out.println("Test #4 Original Arrays");
		System.out.println("*****************************");
		
		//displaying the sorted combined array 
		displayArray (combineArrays (array7, array8), "Combined Array Test #4");
		
		//finding the missing number in the sorted combined array and printing it
		System.out.printf("\n\nMissing Value = %d", 
				findMissingNumber (combineArrays (array7, array8), TEST_4_LOWER_BOUND,  TEST_4_UPPER_BOUND));
		
		
		//The 2 arrays that will be combined
		int[] array9 = {16, 20, 10, 18, 14, 19, 13};
		int[] array10 = {11, 15, 17, 12};
		
		final int TEST_5_LOWER_BOUND = 10;
		final int TEST_5_UPPER_BOUND = 20;
		
		System.out.println("\n\n*****************************");
		System.out.println("Test #5 Original Arrays");
		System.out.println("*****************************");
		
		//displaying the sorted combined array 
		displayArray (combineArrays (array7, array8), "Combined Array Test #5");
		
		//finding the missing number in the sorted combined array and printing it
		System.out.printf("\n\nMissing Value = %d", 
				findMissingNumber (combineArrays (array9, array10), TEST_5_LOWER_BOUND, TEST_5_UPPER_BOUND));
		
	}//main

	
	// Displays the values in an array. arrayName is a string that describes the array
	public static void displayArray (int[] array, String arrayName) {
		
		//displays array description 
		System.out.printf("\n%s", arrayName);
		System.out.println("\n-----------------------------------------");
		
		//displays all of the values in each index of the array
		for(int i = 0; i < array.length; i++) {
			System.out.printf("\nArray[%d]\t=  %d", i, array[i]);
		}
	}//displayArray
	
	
	// Combines the values in two arrays into one and returns the combined array
	public static int[] combineArrays (int[] array1, int[] array2) {
		
		//Creating a new array of size array1 + array2
		int combinedArray [] = new int[array1.length + array2.length];
		
		int counter = 0;
		
		//Putting values of first array into new array
		for(int i = 0; i < array1.length; i++) {
			combinedArray[i] = array1[i];
			counter++;
		}
		
		//putting values of second array in new array
		for(int i = 0; i < array2.length; i++) {
			combinedArray[counter++] = array2[i];
		}
		
		//sorting the array
		Arrays.sort(combinedArray);
		
		return combinedArray;
	}//combineArrays
	
	
	// The array sent in contains the numbers from lower to upper, but exactly 1 number 
	// will be missing. This method finds and returns that number.
	public static int findMissingNumber (int[] array, int lower, int upper) {
		
		
		int index = 0;
		
		int currentValue = lower;
		
		int missingNumber = 0;
		
		boolean foundMissingValue = true;
		
		//accessing each index and comparing it to the value that it should be 
		while(index < array.length && foundMissingValue) {
			
			if (array[index] != currentValue) {
				missingNumber = currentValue;
				foundMissingValue = false;
			}
			
			//if the last index does not equal the upper 
			//bound the missing number is the upper bound
			else if(array[array.length - 1] != upper) {
				missingNumber = upper;
			}
			
			//if last index equals the upper bound 
			//there were no missing numbers
			else if (array[array.length -1] == upper) {
				missingNumber = -1;
			}
			index++;
			currentValue++;
		}
		
		//if the missing number is -1 there was not a missing value
		if (missingNumber == -1) {
			System.out.println("\n\nThere were no missing numbers.");
		}
		return missingNumber;
	}//findMissingNumber


	
}//rodrigueztonyassignment9
