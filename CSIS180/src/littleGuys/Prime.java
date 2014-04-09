package littleGuys;

import java.util.*;
import java.math.*;

public class Prime {

    public static void main(String [] args) {
        long time = System.currentTimeMillis();
        int n = 100;
        if (args.length==1)
            n = Integer.parseInt(args[0]);

        int [] primes = new int[n];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int current = 7;

        for (int currentIdx=3; currentIdx<primes.length; ) {
            boolean primeFlag = true;
            for (int primeIdx=1; primeIdx<currentIdx; primeIdx++) {
                if (current % primes[primeIdx] == 0) {
                    primeFlag = false;
                    break;
                }
            }
            if (primeFlag) {
                primes[currentIdx] = current;
                currentIdx++;
            }
            current += 2;
        }
//	printArr(primes);
	System.out.println("elapsed="+(System.currentTimeMillis()-time));
    }

    public static void printArr(int [] a) {
	for (int i=0; i<a.length; i++)
		System.out.println("P[" + i + "]=" + a[i]);
    }
}
