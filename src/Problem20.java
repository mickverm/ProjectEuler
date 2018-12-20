import java.math.BigInteger;

/**
 * Factorial digit sum
 * Problem 20
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class Problem20 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static void run() {
        System.out.println(sumOfDigits(factorial(100)));
    }

    private static BigInteger factorial(int number) {
        return factorial(BigInteger.valueOf(number));
    }

    private static BigInteger factorial(BigInteger number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number.longValue(); factor++)
            result = result.multiply(BigInteger.valueOf(factor));

        return result;
    }

    private static int sumOfDigits(BigInteger num) {
        String digits = num.toString();
        int sum = 0;

        for (int i = 0; i < digits.length(); i++)
            sum = sum + (digits.charAt(i) - '0');

        return sum;
    }
}
