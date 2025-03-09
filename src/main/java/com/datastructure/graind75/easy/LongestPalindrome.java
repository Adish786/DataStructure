package com.datastructure.graind75.easy;

import java.util.HashSet;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.
Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7
 */
public class LongestPalindrome {
    public static void main(String[] args) {
            String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String str) {
        long bit=0L;
        int n=str.length();
        for(int i=0;i<n;i++) bit^=(1L<<(str.charAt(i)-'A'));
        bit=Long.bitCount(bit);
        return n-(int)(bit==0?0:bit-1);
    }
}
