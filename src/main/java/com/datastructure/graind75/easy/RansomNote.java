package com.datastructure.graind75.easy;
/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

 */
public class RansomNote {
    public static void main(String[] args) {
      String   ransomNote = "a";
      String magazine = "b";
        System.out.println(canConstruct(ransomNote,magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) return false;
            alphabet[c % 26] = i + 1;
        }
        return true;
    }


}
