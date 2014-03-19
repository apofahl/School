package midterm;

import java.math.BigInteger;

/**
 * Created by apofahl
 */
public class Problem34 {

    public static BigInteger factorial(BigInteger num) {
        BigInteger fact = BigInteger.ONE;

        for (BigInteger dex = BigInteger.ONE; dex.compareTo(num) <= 0; dex = dex.add(BigInteger.ONE)) {
            fact = fact.multiply(dex);
        }

        return fact;
    }

    public static BigInteger[] sumBreakdown(BigInteger sum) {
        String sumSt = "" + sum;
        BigInteger [] answer = new BigInteger[sumSt.length()];

        for (int dex = 0; dex < sumSt.length(); dex++) {
            answer [dex] = new BigInteger(sumSt.substring(dex, dex+1));
        }

        return answer;
    }

    public static void main(String[] args) {
        BigInteger count = new BigInteger("100");
        BigInteger sum = BigInteger.ZERO;
        while (count.compareTo(BigInteger.valueOf(9999999)) < 0) {
            BigInteger [] numBreak = sumBreakdown(count);
            if (count.compareTo(BigInteger.valueOf(1000)) < 0) {
                if (count.equals(factorial(numBreak[0]).add(factorial(numBreak[1]).add(factorial(numBreak[2]))))) {
                    System.out.println(count + " fits the requirement!");
                    sum = sum.add(count);
                }
            } else if (count.compareTo(BigInteger.valueOf(10000)) < 0) {
                if (count.equals(factorial(numBreak[0]).add(factorial(numBreak[1])).add(factorial(numBreak[2])).add(factorial(numBreak[3])))) {
                    System.out.println(count + " fits the requirement!");
                    sum = sum.add(count);
                }
            } else if (count.compareTo(BigInteger.valueOf(100000)) < 0) {
                if (count.equals(factorial(numBreak[0]).add(factorial(numBreak[1])).add(factorial(numBreak[2])).add(factorial(numBreak[3])).add(factorial(numBreak[4])))) {
                    System.out.println(count + " fits the requirement!");
                    sum = sum.add(count);
                }
            } else if (count.compareTo(BigInteger.valueOf(1000000)) < 0) {
                if (count.equals(factorial(numBreak[0]).add(factorial(numBreak[1])).add(factorial(numBreak[2])).add(factorial(numBreak[3])).add(factorial(numBreak[4])).add(factorial(numBreak[5])))) {
                    System.out.println(count + " fits the requirement!");
                    sum = sum.add(count);
                }
            } else {
                if (count.equals(factorial(numBreak[0]).add(factorial(numBreak[1])).add(factorial(numBreak[2])).add(factorial(numBreak[3])).add(factorial(numBreak[4])).add(factorial(numBreak[5])).add(factorial(numBreak[6])))) {
                    System.out.println(count + " fits the requirement!");
                    sum = sum.add(count);
                }
            }
            count = count.add(BigInteger.ONE);
        }

        System.out.println("The answer is: " +sum);
    }
}
