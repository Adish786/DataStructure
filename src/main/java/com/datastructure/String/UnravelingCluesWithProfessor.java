package com.datastructure.String;
import java.util.ArrayList;
import java.util.List;
/*
Unraveling Clues with Professor
Professor Prateek from HeyCoach coding academy in Bangalore challenges Varshil to find all indices where a given pattern appears within a given text. Both text and pattern consist of lowercase alphabetical characters. The goal is to identify the starting indices in the text where the complete pattern is found.
Input Format:
The first line contains the string text, consisting of lowercase alphabetical characters (1 <= |text| <= 10^5).
The second line contains the string pattern, consisting of lowercase alphabetical characters (1 <= |pattern| <= 10^5).
Output Format:
A list of integers separated by spaces, representing the starting indices of the text where the pattern appears in its entirety.
Sample Input 1:
text = "ababcabab"
pattern = "ab"
Sample Output 1:
0 2 5 7
Explanation:
The pattern "ab" appears at indices 0, 2, 5, and 7 within the text

*/

public class UnravelingCluesWithProfessor {
    public static List<Integer> findPatternIndices(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        if (pattern.length() == 0) {
            return indices;
        }
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                indices.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return indices;
    }
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
       String text = "ababcabab";
       String  pattern = "ab";
        System.out.println(findPatternIndices(text,pattern));
    }
}
