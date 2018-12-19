public class Problem6 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(arithmeticSum(2, 14, 5));
        System.out.println(arithmeticSum(1, 5, 5));
        System.out.println(sumOfSquares(8));
        System.out.println(sumOfSquares(10));

        int solution = (int) (Math.pow(arithmeticSum(1, 100, 100), 2) - sumOfSquares(100));
        System.out.println("Solution: " + solution);
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Arithmetic_progression">Arithmetic progression - Wikipedia</a>
     */
    public static int arithmeticSum(int start, int end, int amount) {
        // n * (a₁ + aₙ) / 2
        return amount * (start + end) / 2;
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Square_pyramidal_number#Squares_in_a_square">Square pyramidal number - Wikipedia</a>
     */
    public static int sumOfSquares(int upper) {
        // n * (n + 1) * (2n + 1) / 6
        return upper * (upper + 1) * (2 * upper + 1) / 6;
    }
}
