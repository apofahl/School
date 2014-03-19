package csis180;

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		
		for (int dex = 3; dex < 1000; dex++){
			if (dex%3 == 0 || dex%5 == 0) {
				sum += dex;
			}
		}
		
		System.out.println(sum);
	}

}
