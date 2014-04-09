package littleGuys;

import java.math.BigInteger;

/**
 * Created by apofahl
 */
public class Problem7 {

//    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//    What is the 10 001st prime number?

    public static int findPrime10001() {

        int [ ] primes = new int[1500000];
        int currentIdx = 2;
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int currentCheck = 7;

        while (currentIdx <= 10001) {
            boolean primeFlag = true;
            for (int primeIdx = 1; primeIdx < currentIdx; primeIdx++) {
                if (currentCheck % primes[primeIdx] == 0) {
                    primeFlag = false;
                    break;
                }
            }

            if (primeFlag) {
                primes[currentIdx + 1] = currentCheck;
                currentIdx++;
                if (currentIdx == 10000) {
                    break;
                }
            }
            currentCheck += 2;
        }

        return currentCheck;
    }

    public static void main(String args[]) {
        int check = findPrime10001();

        System.out.println("The 10001st prime number is " +check);
    }

}
