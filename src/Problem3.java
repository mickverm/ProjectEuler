/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 * <p>
 * Solution: 6857
 */
public class Problem3 {

    public static void main(String[] args) {
        long number = 600851475143L;
        long largestPrime = -1;

        for (long i = 3; i <= number; i += 2L) {
            while (number % i == 0) {
                largestPrime = i;
                number = number / i;
            }
        }

        System.out.println("Largest prime: " + largestPrime);
    }
}
