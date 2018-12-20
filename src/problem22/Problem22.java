package problem22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 * <p>
 * Solution: 871198282
 */
public class Problem22 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static void run() {
        File file = new File("src/problem22/names.txt");
        String content = readFile(file);
        content = content.replace("\"", "").toLowerCase();
        String[] names = content.split(",");
        Arrays.sort(names);

        long total = 0;

        for (int i = 0; i <= names.length - 1; i++) {
            long sum = names[i].chars().asLongStream().map(character -> (int) character - 'a' + 1).sum();
            sum *= (i + 1);
            total += sum;
        }

        System.out.println(total);
    }

    private static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                content.append(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
