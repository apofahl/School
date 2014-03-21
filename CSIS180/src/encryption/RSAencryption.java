package encryption;

import java.math.BigInteger;
import java.util.Random;

public class RSAencryption {

    static BigInteger p;
    static BigInteger q;
    static BigInteger n;
    static BigInteger phi;
    static BigInteger e;
    static BigInteger d;

    public static void generateRSA() {
        // generate p & q
        Random random = new Random();
        p = new BigInteger(2048, 10, random);
        q = new BigInteger(2048, 10, random);

        n = p.multiply(q);
        phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("3");
        while (!e.gcd(phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.valueOf(2));
        }
        d = e.modInverse(phi);

        System.out.println("Large prime1: " +p);
        System.out.println("Large prime2: " +q);
        System.out.println("Modulus for both keys: " +n);
        System.out.println("Totient: " +phi);
        System.out.println("Exponent for public key: " +e);
        System.out.println("Exponent for private key: " +d);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Start time
        long start = System.currentTimeMillis();
        generateRSA(); // get RSA info

        // Check out info
        int sum = (p.bitLength() + q.bitLength());
        System.out.println("Sum of bit length: " +sum);
        BigInteger m = new BigInteger("123456789");
        BigInteger r = m.modPow(e, n);
        BigInteger m2 = r.modPow(d, n);
        System.out.println("Initially: " + m + "\nAfter encryption: "
                + r + "\nAfter decoding: " + m2);

        // End time
        long stop = System.currentTimeMillis();
        System.out.println("Program started at " + start + " and ended at "
                + stop + " taking " + (stop - start)+ " milliseconds.");
    }

}

