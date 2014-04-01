package littleGuys;

import java.math.BigInteger;

/**
 * Created by apofahl
 */
public class Problem7 {

//    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//    What is the 10 001st prime number?

    public static boolean isPrime(BigInteger check) {
        boolean done = false;

        return done;
    }

    public static void main(String args[]) {
        int count = 0;
        BigInteger check = BigInteger.valueOf(2);

        while (count < 10001) {
            if (isPrime(check)) {
                count++;
            }
            check = check.add(BigInteger.ONE);
        }

        System.out.println("The 10001st prime number is " +check);
    }

}
