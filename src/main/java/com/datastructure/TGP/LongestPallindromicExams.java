package com.datastructure.TGP;

import java.util.HashMap;
import java.util.Map;

/*
Find the length of the longest palindromic subsequence within a given string, denoted by s. A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements. The goal is to determine the maximum length of a subsequence in s that is also a palindrome.
Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters.
Input Format:
A single string 's' consisting only of lowercase English letters.
Output Format:
An integer representing the length of the longest palindromic subsequence within the given string 's'.
Examples:
Example 1:
Input:
s = "bbbab"
Output:
4
Explanation: For the string "bbbab":
The longest palindromic subsequence is "bbbb", which is a palindrome of length 4.
 */
public class LongestPallindromicExams {
    public static void main(String[] args) {
         String s = "bbbab";
        System.out.println(longestPalinSubseq(s));
    }
    public static int longestPalinSubseq(String s)
    {
        Map<String, Integer> memo = new HashMap<>();
        return longestPalindromeSubseqRec(s, 0, s.length() - 1, memo);
    }

    private static int longestPalindromeSubseqRec(String s, int left, int right, Map<String, Integer> memo) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        String key = left + "," + right;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result;
        if (s.charAt(left) == s.charAt(right)) {
            result = 2 + longestPalindromeSubseqRec(s, left + 1, right - 1, memo);
        } else {
            int excludeLeft = longestPalindromeSubseqRec(s, left + 1, right, memo);
            int excludeRight = longestPalindromeSubseqRec(s, left, right - 1, memo);
            result = Math.max(excludeLeft, excludeRight);
        }
        memo.put(key, result);
        return result;
    }
}
