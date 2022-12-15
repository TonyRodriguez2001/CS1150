/*
 *  Name: Tony Rodriguez
 *  
 *  Class: CS1150 (T/R)
 *  
 *  Due:  Oct 30, 2020 
 *  
 *  Description: Assignment #8 
 *  
 *  Purpose: Learn to use methods and arrays
 *  
 * In this assignment I will create a GPA calculator 
 * and also get a brief introduction to using a class 
 * and creating object.  The program will create 3 arrays 
 * and then perform several manipulations on the arrays to 
 * compute the GPA.  The 1ST array stores course names 
 * (strings), the 2nd stores letter grades (strings) that 
 * correspond to those courses, and the 3rd stores credit hours 
 * (integers) that correspond to those courses.    
 */

public class RodriguezTonyAssignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//The 3 arrays that hold classes, credits, and their corresponding grade
		String[] courses = new String[] {"Math", "CS1150", "Physics", "Chemistry", "English"};
		String[] grades = new String[] {"B+", "A", "A-", "C+", "C"};
		int[] credits = new int[] {3, 3, 4, 4, 3};
		
		//Displaying the courses and their corresponding grades
		display(courses, grades, credits);
		
		//Calculating and printing the total credits
		int totalCredits = computeSum(credits);
		System.out.printf("\nTotal Credits: %d", totalCredits);
		
		//Computing and printing the total grade points for the classes taken
		double totalGradePoints = computeTotalGradePoints(grades, credits);
		System.out.printf("\nTotal Grade Points: %.2f", totalGradePoints);
		
		//Determining and printing the course with the grade worth the most points
		String highestGradeSubject = courses[findGradeWorthMostPoints(grades, credits)];
		String highestGrade = grades[findGradeWorthMostPoints(grades, credits)];
		System.out.printf("\nGrade worth most points: %s  %s", highestGradeSubject, highestGrade);
		
		//Calculation for overall GPA
		//Printing the overall GPA
		double overallGpa = totalGradePoints / (double) totalCredits;
		System.out.printf("\nOverall GPA: %.2f", overallGpa);
		
		//The array that holds the dogs and their bark
				Dog[] dogArray = new Dog[5];
				
				dogArray[0] = new Dog ("Rover", "woof woof");
				dogArray[1] = new Dog ("Max", "arf arf arf");
				dogArray[2] = new Dog ("Tiny", "yap yap yap");
				dogArray[3] = new Dog ("Trooper", "ruff ruff ruff");
				dogArray[4] = new Dog ("Magoo", "bow wow bow wow");
				
				makeDogsBark(dogArray);
	}
	
	
	//For each course, display the course’s name, letter grade, and credit 
	public static void display(String[] courses, String[] grades, int[] credits) {
		
		System.out.println("------------------------------------");
		System.out.println("Courses\t\tGrades Credits");
		System.out.println("------------------------------------");
		
		//Since all arrays are same size i just chose ones length
		int arraySize = courses.length;
		
		for(int i = 0; i < arraySize; i++) {
			
			System.out.printf("%-15s%-15s%d\n", courses[i], grades[i], credits[i]);
			
		}//for loop
		
	}//Display Method
	
	
	
	// Computes and returns the total points for all letter grades in grades array
	public static double computeTotalGradePoints(String[] grades, int[] credits) {
		
		//Array of possible grades earned
		String possibleGrades[] = {"A", "A-", "B+", "B", "B-", "C+", 
				"C", "C-", "D+", "D", "D-", "F"};
		
		double totalGradePoints = 0.0;
		
		//Evaluating the grade to find its match
		for(int i = 0; i < grades.length; i++) {
			
			boolean findingGrade = true;
			
			int j = 0;
			
			while (findingGrade) {
				if(grades[i].equals(possibleGrades[j])) {
					//using the convert letter grades to points method and multiplying 
					//that result by the corresponding credits to that particular class
					totalGradePoints += convertLetterGradeToPoints(grades[i]) * credits[i];
					findingGrade = false;
				}
				j++;
			}//while loop
		}//for loop
		
		return totalGradePoints;
		
	}//compute total grade points method
	
	
	// Converts a letter grade into its numeric equivalent
	public static double convertLetterGradeToPoints(String grade) {
		
		//Array holding possible grades earned
        double gradeValues[] = new double[] {4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
		
        //array holding the values for each possible grade
		String possibleGrades[] = new String[] {"A", "A-", "B+", "B", "B-", "C+", 
				"C", "C-", "D+", "D", "D-", "F"};
		
		double gradeValue = 0.0;
		
		boolean findingGrade = true;
		
		int i = 0;
		
		//Runs until the grade being evaluated has a match
		//returns the value for the grade matched
		while(findingGrade) {
			
			if(grade.equals(possibleGrades[i])) {
				
				gradeValue = gradeValues[i];
				findingGrade = false;
			}
			i++;
		}
		
		return gradeValue;
	}//convert letter grade to points method
	

	// Computes and returns the sum of all values (credits) in the array
	public static int computeSum(int[] credits) {
		
		int totalCredits = 0;
		
		//adding all the credits to one variable 
		for(int i = 0; i < credits.length; i++) {
			totalCredits += credits[i];
		}
		
		return totalCredits;
	}//compute sum method

	
	// Finds the grade that is worth the most points, returns that grade’s index
	public static int findGradeWorthMostPoints(String[] grades, int[] credits) {
		
		//Arrays that will be used to find the grade that is being looked at
		double gradeValues[] = new double[] {4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
		
		String possibleGrades[] = new String[] {"A", "A-", "B+", "B", "B-", "C+", 
				"C", "C-", "D+", "D", "D-", "F"};
		
		
		//Variables that will hold values for the index and the highest grade
		int highestGrade = 0;
		double gradePoints = 0.0;
		double highestGradePoint = 0.00;
		
		
		//for loop is being used to access all of the grades arrays indexes
		for(int i = 0; i < grades.length; i++) {
			
			
			boolean findingGrade = true;
			
			int j = 0;
			
			//Looking at current grade and looking through 
			//possible grades to find a match and retrieving the 
			//value for that grade from grade values array
			while (findingGrade) {
				if(grades[i].equals(possibleGrades[j])) {
				 gradePoints = gradeValues[j] * credits[i];
					findingGrade = false;
				}
				j++;
			}
			
			//Comparing the current grade to the highest grade in order to get the 
			//highest grade in the array and its index
			if(highestGradePoint < gradePoints) {
				highestGradePoint = gradePoints;
				highestGrade = i;
			}
		}
		return highestGrade;
		
	}//find grade worth most points method
	
	
	//method to calculate dog name and bark
		public static void makeDogsBark(Dog[] dogArray) {
			
			
			System.out.println("\n\nCreate and array of dog objects");
			System.out.println("-------------------------------");
			
				for (int i = 0; i < dogArray.length; i++) {
					System.out.printf("%s barks like this: %s\n", dogArray[i].getName(), dogArray[i].getBark());
				}
		}	


}//Assignment 8 

//Class for the dog portion of the assignment
class Dog {

	private String name;
	private String bark;
	
		public Dog(String name, String bark) {
			this.name = name;
			this.bark = bark;	
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBark() {
			return bark;
		}
		public void setBark(String bark) {
			this.bark = bark;
		}
		
}//dog class

