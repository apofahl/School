package csis180;

public class Problem4 {

	public static int [ ] putInArray(int product)
	{
		int [ ] palindrome = new int [6];
		int j = 0;
		
		for (int i = 100000; i != 0; i /= 10)
		{
			palindrome [j] = product/i;
			product = product % i;
			j++;
		}
		
		return palindrome;
	}
	
	public static boolean checkPalindrome(int [ ] palindrome)
	{
		// Set up variables
		boolean check = true;
		int length = 5;
		int i = 0;
		
			// Check for an even palindrome
			while (check == true && i < 3)
			{
					int a = palindrome [i];
					int b = palindrome [length - i];
					if (a != b)
					{
						check = false;
					}
					i++;
			}
		
		return check;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Set up variables
		int product;
		int theOne = 0;
		
		for (int i = 100; i < 1000; i++)
		{
			for (int j = 100; j < 1000; j++)
			{
				product = i * j;
				int [ ] palindrome = putInArray(product);
				boolean check = checkPalindrome(palindrome);
				
				if (check == true && product > theOne)
				{
					theOne = product;
				}
				
			}
		}
		System.out.println(theOne);
	}

}

