import java.text.DecimalFormat;

/**
 * Number letter counts
 * Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 *
 * Solution: 21124
 */
public class Problem17 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run();
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }

    private static final String[] TENS_NAMES = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] NUM_NAMES = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static void run() {
        int characters = 0;
        for (int i = 1; i <= 1000; i++)
            characters += convert(i).length();


        System.out.println(characters);

        /*
        System.out.println(convert(0));
        System.out.println(convert(1));
        System.out.println(convert(16));
        System.out.println(convert(100));
        System.out.println(convert(118));
        System.out.println(convert(200));
        System.out.println(convert(219));
        System.out.println(convert(800));
        System.out.println(convert(801));
        System.out.println(convert(1316));
        System.out.println(convert(1000000));
        System.out.println(convert(2000000));
        System.out.println(convert(3000200));
        System.out.println(convert(700000));
        System.out.println(convert(9000000));
        System.out.println(convert(9001000));
        System.out.println(convert(123456789));
        System.out.println(convert(2147483647));
        System.out.println(convert(3000000010L));
        */
    }

    // 1 to 999
    private static String convertSmall(int number) {
        int original = number;
        String word;

        if (number % 100 < 20) {
            word = NUM_NAMES[number % 100];
            number /= 100;
        } else {
            word = NUM_NAMES[number % 10];
            number /= 10;

            word = TENS_NAMES[number % 10] + word;
            number /= 10;
        }

        if (number == 0)
            return word;
        return NUM_NAMES[number] + "hundred" + (original % 100 > 0 ? "and" : "") + word;
    }

    // 0 to 999 999 999 999
    private static String convert(long number) {
        if (number == 0) return "zero";

        // pad with 0's
        String mask = "000000000000";
        DecimalFormat format = new DecimalFormat(mask);
        String string = format.format(number);
        String result = "";

        // XXX nnn nnn nnn
        int billions = Integer.parseInt(string.substring(0, 3));
        // nnn XXX nnn nnn
        int millions = Integer.parseInt(string.substring(3, 6));
        // nnn nnn XXX nnn
        int hundredThousands = Integer.parseInt(string.substring(6, 9));
        // nnn nnn nnn XXX
        int thousands = Integer.parseInt(string.substring(9, 12));

        result = billions == 0 ? "" : result + convertSmall(billions) + "billion";
        result = millions == 0 ? result : result + convertSmall(millions) + "million";
        result = hundredThousands == 0 ? result : result + convertSmall(hundredThousands) + "thousand";
        result = thousands == 0 ? result : result + (!result.equals("") && thousands < 100 ? "and" : "") + convertSmall(thousands);

        return result;
    }
}
