package com.datastructure.graind75;
/*
Given two strings s and t, return true if t is an
anagram of s, and false otherwise.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        // Count character frequencies in both strings
        int[] charCounts = new int[26]; // Assuming only lowercase letters
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }
        // Check if all counts are zero
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
