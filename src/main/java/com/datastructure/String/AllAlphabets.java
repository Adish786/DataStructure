package com.datastructure.String;
/*
All Alphabets
Write a program that takes lowercase string str as input and checks if it contains all 26 alphabets at least once. Given a string str, return true if str contains all 26 alphabets, or false otherwise.
Input:
thequickbrownfoxjumpsoverthelazydog
Output
true
 */

public class AllAlphabets {
    public static void main(String[] args) {
        String str = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(allAlphabetsOrNot(str));
    }
    public static boolean allAlphabetsOrNot(String str) {
        if (str.length() < 26) {
            return false;
        }
        boolean[] alphabetTracker = new boolean[26];
        int uniqueAlphabetsCount = 0;
        for (char c : str.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                int index = c - 'a';
                if (!alphabetTracker[index]) {
                    alphabetTracker[index] = true;
                    uniqueAlphabetsCount++;
                    if (uniqueAlphabetsCount == 26) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
