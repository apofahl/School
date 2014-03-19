package csis180;

public class Problem2 {

	/** This program finds all of the even numbers in the Fibonacci series up to 
	 * 		4000000 and adds them up
	 * 
	 * 	Author: Abi Pofahl
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// write Fibonacci numbers
		double num1 = 1;
		double num2 = 2;
		double num3 = 0;
		double sum = 2;            // forgot about this starting at 2 for a while.
		while (num1 <= 4000000)
		{
			num3 = num1 + num2;
			
			// adding up the numbers
			if (num3%2 == 0)
			{
				sum += num3;
			}
			num1 = num2;
			num2 = num3;
			
		}
		
		// report to user
		System.out.println("The sum is " +sum);

	}

}
