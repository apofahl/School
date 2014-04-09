package littleGuys;

import java.math.BigInteger;

public class Problem16 {

	/**
	 *  Title: Power Digit Sum
	 *  
	 *  Author: Abi Pofahl
	 * @param args
	 */
	public static void main(String[] args) {
		// Set up variables
		BigInteger base = new BigInteger("2");
		int power = 1000;
		BigInteger powerNum;
		powerNum = base.pow(power);
		BigInteger sum = BigInteger.ZERO;
		BigInteger i = BigInteger.TEN.pow(302);

		// Divide and add and all that jazz
		while (!i.equals(BigInteger.ZERO))
		{
			BigInteger [ ] meow = powerNum.divideAndRemainder(i);
			BigInteger toAdd = meow[0];
			powerNum = meow [1];
			sum = sum.add(toAdd);
			i = i.divide(BigInteger.TEN);
		}
		
		System.out.println("The digits that make up 2^1000 have a sum of " +sum+ ".\n\nBlood, sweat, and tears by Abi Pofahl.");


	}
	

}