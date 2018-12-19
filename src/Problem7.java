/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 * <p>
 * Solution: 104743
 */
public class Problem7 {

    public static void main(String[] args) {
        System.out.println(nthPrime(6));
        System.out.println(nthPrime(10001));
    }

    /**
     * Not the most efficient way.
     *
     * @see <a href="https://stackoverflow.com/questions/9625663/calculating-and-printing-the-nth-prime-number/9704912#9704912">Calculating and printing the nth prime number</a>
     */
    public static int nthPrime(int n) {
        int candidate = 2;

        for (int count = 0; count < n; candidate++) {
            if (isPrime(candidate))
                count++;
        }

        return candidate - 1;
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0)
            return n == 2;

        for (int i = 3; i < n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
