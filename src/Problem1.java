
/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Answer: 233168
 */
public class Problem1 {

    public static void main(String[] args) {

        int total = 0;

        for (int i = 3; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                total += i;
        }

        System.out.println(total);
    }
}
