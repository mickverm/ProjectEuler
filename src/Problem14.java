/**
 * Longest Collatz sequence
 * Problem 14
 * <p>
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * <p>
 * Solution: 837799
 */
public class Problem14 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static void run() {
        int maxCount = 0;
        int start = 0;

        // Having n as an integer created gave 910107 (476) as a solution, which is incorrect.
        // It also produced sequences that didn't end with 1.
        // The integer reached Integer.MAX_VALUE, which threw off the formula.
        long n;

        for (int i = 2; i < 1000000; i++) {
            int count = 1;
            n = i;

            while (n > 1) {
                if (n % 2 == 0)
                    n = n / 2;
                else
                    n = 3 * n + 1;
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
                start = i;
            }
        }

        System.out.println("largest count: " + maxCount + " for starting number: " + start);
    }
}
