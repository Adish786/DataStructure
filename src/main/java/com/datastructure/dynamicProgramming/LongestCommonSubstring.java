package com.datastructure.dynamicProgramming;
/*
Longest Common Substring
Given two strings, find out the longest common substring. A substring is a contiguous segment within a string.

Input:
str1 : First String

str2 : Second string
Output:
Return a string which is a longest common substring in both str1 and str2. If there are multiple substring with longest length return which has the smallest starting index.
Examples:
Example 1:
Input:
str1 = "abcdefgabcdegh"
str2 = "abcdeghabfvsnm"
Output:
"abcdegh"
Explanation:
For the strings "abcdefgabcdegh" and "abcdeghabfvsnm":
The longest common substring is "abcdegh", appearing in the same order in both strings.
Example 2:
Input:
str1 = "abc"
str2 = "def"
Output:
""
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcdefgabcdegh";
        String str2 = "abcdeghabfvsnm";
        System.out.println(longestCommonSubstring(str1,str2));
    }
  public static   String longestCommonSubstring(String str1, String str2) {
        int maxLength = 0;
        String longestSubstr = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                String currentSubstr = findCommonSubstring(str1, str2, i, j);
                if (currentSubstr.length() > maxLength) {
                    maxLength = currentSubstr.length();
                    longestSubstr = currentSubstr;
                }
            }
        }
        return longestSubstr;
    }
    private static String findCommonSubstring(String str1, String str2, int i, int j) {
        if (i >= str1.length() || j >= str2.length()) {
            return "";
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return str1.charAt(i) + findCommonSubstring(str1, str2, i + 1, j + 1);
        } else {
            return "";
        }
    }
}
