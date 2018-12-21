import java.util.ArrayList;
import java.util.List;

/**
 * Non-abundant sums
 * Problem 23
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
 * the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum
 * exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of
 * two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be
 * written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even
 * though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than
 * this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Problem23 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static final int LIMIT = 28123;

    private static void run() {

        List<Integer> abundant = new ArrayList<>();

        // find all abundant numbers
        for (int i = 1; i <= LIMIT; i++)
            if (sumOfDivisors(i) > i)
                abundant.add(i);

        boolean[] isSum = new boolean[LIMIT + 1];
        for (int i = 0; i < abundant.size(); i++) {
            for (int j = i; j < abundant.size(); j++) {
                int abundantSum = abundant.get(i) + abundant.get(j);
                if (abundantSum <= LIMIT)
                    isSum[abundantSum] = true;
                else
                    break;
            }
        }

        int sum = 0;

        for (int i = 1; i <= LIMIT; i++)
            if (!isSum[i])
                sum += i;

        System.out.println(sum);
    }

    private static int sumOfDivisors(int number) {
        int sum = 1;
        for (int i = 2; i <= number / 2; i++)
            if (number % i == 0)
                sum += i;
        return sum;
    }
}
