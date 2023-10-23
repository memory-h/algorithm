package string.bronze.bronze_1;

import java.util.Arrays;
import java.util.Scanner;

public class _6996 {

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------
         *
         * Your code should return true if the two strings are anagrams of each other.
         *
         * */

        if (first.length() != second.length()) return false;

        char[] c1 = first. toCharArray();
        char[] c2 = second.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            solveAnagrams(first, second);

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}