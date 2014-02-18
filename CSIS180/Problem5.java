package csis180;

public class Problem5 {

	/**
	 *  Title: Smallest Multiple
	 * 
	 *  Author: Abi Pofahl
	 * @param args
	 */
	public static void main(String[] args) {
		// set up variables
		int top = 20;
		int number = 10; // random low starting number
		int check = 0;
		
		// find the smallest multiple
		while (check < top)               // exits only when mod is zero for every number
		{
			check = 0;    // resets count
			number++;     // moves to next number
			
			for (int i = 1; i <= top; i++)
			{
				int yes = number%i;
				if (yes == 0)
				{
					check++; // adds up the number of times the mod is 0
				}
			}
		}
		
		// report to user
		System.out.println(number);

	}

}
