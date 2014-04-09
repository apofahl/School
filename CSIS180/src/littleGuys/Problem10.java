package littleGuys;

import java.math.BigInteger;

/**
 * Created by apofahl
 */
public class Problem10 {

//    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//    Find the sum of all the primes below two million.

    static BigInteger sum = BigInteger.ZERO;

    public static void primeSum() {
        sum = new BigInteger("10");

        int [ ] primes = new int[1500000];
        int currentIdx = 2;
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int currentCheck = 7;

        while (currentCheck < 2000000) {
            boolean primeFlag = true;
            for (int primeIdx = 1; primeIdx < currentIdx; primeIdx++) {
                if (currentCheck % primes[primeIdx] == 0) {
                    primeFlag = false;
                    break;
                }
            }
            if (primeFlag) {
                primes[currentIdx + 1] = currentCheck;
                sum = sum.add(BigInteger.valueOf((long) (currentCheck)));
                currentIdx++;
            }
            currentCheck += 2;
        }
    }

    public static void main(String args[]) {
        primeSum();

        System.out.println("The sum of all primes under 2000000 is " +sum);
    }
}

