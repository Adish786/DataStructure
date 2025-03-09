package com.datastructure.intervew;

import java.util.HashSet;
import java.util.Set;
/*
Write a Pangram Program
Given a string sentence containing English letters (lower- or upper-case), return true if sentence is a Pangram, or false otherwise.
Input: sentence = "TheQuickBrownFoxJumpsOverTheLazyDog"
Output: true
Explanation: The sentence contains at least one occurrence of every letter of the English alphabet either in lower or upper case.

Time Complexity :-O(n)
Space Complexity :-O(1)

 */

public class CheckIfPangram {
    public static boolean checkIfPangram(String str ){
        Set<Character > seen = new HashSet<>();
        for (int i = 0; i <str.length() ; i++) {
            char currentChar  =  Character.toLowerCase(str.charAt(i));
            if(Character.isLetter(currentChar)){
                seen.add(currentChar);
            }
        }
        return seen.size()==26;
    }

    public static void main(String[] args) {
        CheckIfPangram sol = new CheckIfPangram();
        // Test case 1: "TheQuickBrownFoxJumpsOverTheLazyDog"
        // Expected output: true
        System.out.println(sol.checkIfPangram("TheQuickBrownFoxJumpsOverTheLazyDog"));
        // Test case 2: "This is not a pangram"
        // Expected output: false
        System.out.println(sol.checkIfPangram("This is not a pangram"));

        // Test case 3: "abcdef ghijkl mnopqr stuvwxyz"
        // Expected output: true
        System.out.println(sol.checkIfPangram("abcdef ghijkl mnopqr stuvwxyz"));

        // Test case 4: ""
        // Expected output: false
        System.out.println(sol.checkIfPangram(""));

        // Test case 5: "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        // Expected output: true
        System.out.println(sol.checkIfPangram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}
