/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Problem10 {

    public static void main(String[] args) {
        long sum = 2;

        int i = 1;
        while (i < 2 * 1000 * 1000) {
            i += 2;
            if (isPrime(i)) {
                sum += i;
                System.out.println(i);
            }
        }

        System.out.println("Sum: " + sum);
    }

    public static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
