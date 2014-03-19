package csis180;

public class Problem6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		int square = 0;
		
		for (int dex = 1; dex <= 100; dex++) {
			sum += Math.pow(dex, 2);
			square += dex;
		}
		
		square = (int) Math.pow(square, 2);
		
		int answer = square - sum;
		System.out.println(answer);

	}

}
