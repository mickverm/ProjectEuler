import java.math.BigInteger;

/**
 * Lattice paths
 * Problem 15
 * <p>
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly
 * 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20×20 grid?
 * <p>
 * Solution: 137846528820
 */
public class Problem15 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static final int GRID_SIZE = 20;

    private static void run() {
        // Method 1:

        // A 20x20 grid has a 21x21 point grid
        // Using a long[][] is necessary, int[][] wont work
        long[][] grid = new long[GRID_SIZE + 1][GRID_SIZE + 1];

        //Initialise the grid with boundary conditions
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][GRID_SIZE] = 1;
            grid[GRID_SIZE][i] = 1;
        }

        for (int i = GRID_SIZE - 1; i >= 0; i--) {
            for (int j = GRID_SIZE - 1; j >= 0; j--) {
                grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
            }
        }

        System.out.println("Amount of paths: " + grid[0][0]);

        // Method 2;
        // TODO: 20/12/2018 is this really correct?
        int gridSize = 20;
        long paths = 1;

        for (int i = 0; i < gridSize; i++) {
            paths *= (2 * gridSize) - i;
            paths /= i + 1;
        }

        System.out.println("Amount of paths: " + paths);

        // Method 3:
        BigInteger factorialOfSum = factorial(BigInteger.valueOf(GRID_SIZE + GRID_SIZE));
        BigInteger factorialOfLength = factorial(BigInteger.valueOf(GRID_SIZE));
        BigInteger factorialOfWidth = factorial(BigInteger.valueOf(GRID_SIZE));

        BigInteger amount = factorialOfSum.divide((factorialOfLength.multiply(factorialOfWidth)));
        System.out.println("Amount of paths: " + amount.toString());
    }

    public static BigInteger factorial(BigInteger number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number.longValue(); factor++)
            result = result.multiply(BigInteger.valueOf(factor));

        return result;
    }
}
