/*
 *  Name: Tony Rodriguez
 *  Class: CS1150 (T/R)
 *  Due:  Sept 3, 2020 
 *  Description: Assignment #1 
 *  This program demonstrates that I understand basic program structure by 
 *  printing a couple paragraphs that tell the instructor what I’m passionate       
 *  about.  It also gives a little practice with arithmetic in Java.
 */

public class RodriguezTonyAssignment1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       System.out.println("   My names is Tony Rodriguez.");
	       System.out.println("I am an out of state first generation student at UCCS.");
	       System.out.println("I was born and raised in a small North Texas town.");
	       System.out.println("I am currently in my third semester at UCCS and majoring in Computer Security.");
	       System.out.println("Some of my favorite hobbies include: fishing, hunting, and playing video games.");
	       System.out.println("   I also enjoy watching movies whether it be alone or with friends.");
	       System.out.println("I particularly enjoy movies directed by Quentin Tarantino.");
	       System.out.println("A few examples are: Inglorious Bastards, Django, The Bad News Bears, and The Hateful Eight.");
	       System.out.println("The coronovirus pandemic has impacted my love for movies.");
	       System.out.println("Not being able to go watch movies on the big screen at a cinema is a real bummer.");
	       System.out.println("Despite the pandemic and online classes, I remain optimistic for a great semester.\n");
	       
	       //Part 2 working with arithmetic
	      System.out.println("\nSeconds between lightning & thunder    Distance (miles)");
	      System.out.println("------------------------------------   ----------------");
	       int seconds = 10;
	       for (int i = 1; i <= seconds; i++)
	       {
	         float formula = (1100 * i);
	         float finalDistance = (formula / 5280);
	         System.out.printf("Seconds: %d                              "
	         		+ "Distance: %f\n " , i, finalDistance);
	       }
	       
	}	
}
