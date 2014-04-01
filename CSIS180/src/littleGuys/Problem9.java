package littleGuys;

public class Problem9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Define Pythagorean Triplet
		double addition;
		long triplet = 0;
		
		for (int a = 100; a < 1000; a++)
		{
			for (int b = 200; b < 1000; b++)
			{
				for (int c = (1000 - a - b); c < 1000; c++)	
				{
					if (a + b + c == 1000)
					{
						addition = Math.pow(a, 2) + Math.pow(b, 2);
						if (addition == Math.pow(c, 2))
						{
							triplet = a * b * c;
						}
					}
		
				}
			}
		}
		
		System.out.println(triplet);
	}

}
