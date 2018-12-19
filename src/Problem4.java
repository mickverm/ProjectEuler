import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * <p>
 * Solution: 906609
 */
public class Problem4 {

    public static void main(String[] args) {
        List<Integer> palindromes = new ArrayList<>();

        for (int i = 999; i > 100; i--) {
            for (int j = 999; j > 100; j--) {
                int product = i * j;
                if (isPalindrome(String.valueOf(product).toCharArray()))
                    palindromes.add(product);
            }
        }

        Collections.sort(palindromes);
        System.out.println("Largest: " + palindromes.get(palindromes.size() - 1));
    }

    public static boolean isPalindrome(char[] text) {
        int i1 = 0;
        int i2 = text.length - 1;

        while (i2 > i1) {
            if (text[i1] != text[i2])
                return false;
            i1++;
            i2--;
        }

        return true;
    }
}

