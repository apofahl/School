package littleGuys;

import java.math.BigInteger;

/**
 * Created by apofahl
 */
public class Problem10 {

//    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//    Find the sum of all the primes below two million.

    public static boolean isPrime(BigInteger check) {
        boolean done = false;

        return done;
    }

    public static void main(String args[]) {
        BigInteger check = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        int count = 0;

        for (long dex = 2; dex < 2000000; dex++) {
            check = BigInteger.valueOf(dex);
            if (isPrime(check)) {
                sum = sum.add(check);
                count++;

                if (count == 10001) {
                    System.out.println("Problem 7 answer: " +check);
                }
            }
        }

        System.out.println("The sum of all primes under 2000000 is " +sum);
    }
}

