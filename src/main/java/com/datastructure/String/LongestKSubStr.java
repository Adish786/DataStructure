package com.datastructure.String;
import java.util.HashMap;
import java.util.Map;
/*
Longest SubString With K unique charachters
Given a string S and an integer K, find the length of the longest substring of S that contains exactly K unique characters. If no such substring exists, return -1.
Your Task: You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.
Input Format:
A string S containing lowercase letters.
An integer K, the number of unique characters required in the substring.
Output Format:
Return the length of the longest substring with exactly K unique characters. If there is no substring with exactly K unique characters, return -1.
Sample Input 1:
S = "aabacbebebe"
K = 3
Sample Output 1:
7
Explanation:
The longest substring with exactly 3 distinct characters is "cbebebe"
 */

public class LongestKSubStr {
    public static int longestKSubstr(String S, int K) {
        if (S == null || S.length() == 0 || K <= 0) {
            return -1;
        }
        int n = S.length();
        int maxLength = -1;
        int left = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char rightChar = S.charAt(right);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > K) {
                char leftChar = S.charAt(left);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                left++;
            }
            if (charFrequencyMap.size() == K) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k =3;
        System.out.println(longestKSubstr(str,k));
    }
}
