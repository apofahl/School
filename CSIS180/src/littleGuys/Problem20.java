package littleGuys;

import java.math.BigInteger;

public class Problem20 {

	public static BigInteger thisIsDumb(int i)
	{
		String toChange = "";
		toChange += i;
		BigInteger number = new BigInteger(toChange);
		
		return number;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Set up variables
		int max = 100;
		BigInteger factorial = new BigInteger("1");
		BigInteger sum = BigInteger.ZERO;
		BigInteger [ ] divisor = new BigInteger [2];
		
		// Build the factorial
		for (int i = 1; i <= max; i++)
		{
			BigInteger number = thisIsDumb(i);
			factorial = factorial.multiply(number);
		}
		
		// Add up the digits
		while (!factorial.equals(BigInteger.ZERO))
		{
			divisor = factorial.divideAndRemainder(BigInteger.TEN);
			factorial = divisor [0];
			sum = sum.add(divisor [1]);
		}
		
		System.out.println(sum);
	}

}
