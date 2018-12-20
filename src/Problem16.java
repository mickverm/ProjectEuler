import java.math.BigInteger;

/**
 * Power digit sum
 * Problem 16
 * <p>
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 21000?
 * <p>
 * Solution: 1336
 */
public class Problem16 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static void run() {
        System.out.println(sumOfDigits(BigInteger.valueOf(2).pow(1000)));
    }

    private static int sumOfDigits(BigInteger num) {
        String digits = num.toString();
        int sum = 0;

        for (int i = 0; i < digits.length(); i++)
            sum = sum + (digits.charAt(i) - '0');

        return sum;
    }
}
