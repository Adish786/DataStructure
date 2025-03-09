package com.datastructure.TGP;

import java.util.HashMap;

/*
Given a string s, your task is to calculate the number of distinct non-empty subsequences of s. Due to the potential size of the answer, return it modulo 1000000007 (1e9 + 7).
A subsequence of a string is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. For example, "ace" is a subsequence of "abcde" while "aec" is not.
Input Format:
A single line containing the string s.
Output Format:
An integer representing the number of distinct non-empty subsequences of smodulo1000000007.`
Sample Input 1:
abc
Sample Output 1:
7
Explanation:
The seven distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
Sample Input 2:
aba
Sample Output 2:
6
Explanation:
The six distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".
Constraints:
1 <= s.length <= 2000
s consists of lowercase English letters
 */
public class CountUniqueSubsequences {

    public static void main(String[] args) {
        String s ="a";
        System.out.println(s);
    }
    private static final int MOD = 1000000007;
    public static int uniqueSubsequences(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            char currentChar = s.charAt(i - 1);
            dp[i] = (2 * dp[i - 1]) % MOD;
            if (lastIndex.containsKey(currentChar)) {
                int lastIdx = lastIndex.get(currentChar);
                dp[i] = (dp[i] - dp[lastIdx - 1] + MOD) % MOD;
            }
            lastIndex.put(currentChar, i);
        }
        return (int) (dp[n] - 1);
    }
}
