/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom of the triangle below:
 * <p>
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * <p>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 * <p>
 * Solution: 1074
 */
public class Problem18 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static void run() {
        int[][] triSmall = {{3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3}};
        System.out.println(maxPathSum(triSmall));


        int[][] triLarge = new int[][]{
                {75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };

        int[][] triLargeFilled = new int[15][15];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (j <= triLarge[i].length - 1)
                    triLargeFilled[i][j] = triLarge[i][j];
                else
                    triLargeFilled[i][j] = 0;
            }
        }

        System.out.println(maxPathSum(triLargeFilled));
    }

    private static int maxPathSum(int[][] tri) {
        // loop for bottom-up calculation
        for (int i = tri[0].length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // for each element, check both
                // elements just below the number
                // and below right to the number
                // add the maximum of them to it
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i + 1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }

        // return the top element
        // which stores the maximum sum
        return tri[0][0];
    }
}
