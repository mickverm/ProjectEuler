/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 * <p>
 * Solution: 31626
 */
public class Problem21 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static final int TOP = 10000;

    private static void run() {
        int sum = 0;
        for (int i = 220; i <= TOP; i++)
            if (hasAmicablePair(i))
                sum += i;
        System.out.println(sum);
    }

    private static boolean hasAmicablePair(int number) {
        int sum = sumOfDivisors(number);
        if (number == sum)
            return false;
        return number == sumOfDivisors(sum);
    }

    private static int sumOfDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++)
            if (number % i == 0)
                sum += i;
        return sum;
    }
}
