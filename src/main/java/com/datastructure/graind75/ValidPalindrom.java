package com.datastructure.graind75;

import java.util.stream.IntStream;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 */
public class ValidPalindrom {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
     //   boolean isItPalindrome = IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
    }
/*
    public static boolean isPalindrome(String s) {
        String lowerCased  = s.toLowerCase();
        String strippedString = lowerCased.replaceAll("[^a-z0-9]", "");
        for (int i = 0; i < strippedString.length() / 2; i++) {
            char leftChar = strippedString.charAt(i);
            char rightChar = strippedString.charAt(strippedString.length() - 1 - i);
            if(leftChar != rightChar){
                return false;
            }
        }
        return true;
    }

 */
    public static boolean isPalindrome(String s){
        String a = s.toLowerCase();
        int last = s.length()-1;
        int start = 0;
        while (start <= last){
            char currentIndex = a.charAt(start);
            char lastIndex = a.charAt(last);
            if(!Character.isLetterOrDigit(currentIndex)){
                start++;
            } else if (!Character.isLetterOrDigit(lastIndex)) {
                last--;
            }
            else {
                if(currentIndex !=lastIndex) return false;
                start++;
                last--;
            }
        }
        return true;
    }

}







