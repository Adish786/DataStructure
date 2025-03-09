package com.datastructure.intervewPattern2025;
/*
Next Lexicographical Sequence
Given a string of lowercase English letters, rearrange the characters to form a new string
representing the next immediate sequence in lexicographical (alphabetical) order. If the given
string is already last in lexicographical order among all possible arrangements, return the
arrangement that’s first in lexicographical orde
Example 1:
Input: s = "abcd"
Output: "abdc"
Explanation: "abdc" is the next sequence in lexicographical order after rearranging "abcd".
Example 2:
Input: s = "dcba"
Output: "abcd"
Explanation: Since "dcba" is the last sequence in lexicographical order, we return the fir
sequence: "abcd".
Constraints:
● The string contains at least one character.
 */
public class NextLexicographicalSequence {
    public static String nextPermutation(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // Step 1: Find the rightmost character that is smaller than its next character
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) { // If such a character is found
            // Step 2: Find the rightmost character that is greater than arr[i]
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }
        // Step 4: Reverse the suffix starting from index i+1
        reverse(arr, i + 1, n - 1);
        return new String(arr);
    }
    // Utility method to swap two characters in the array
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Utility method to reverse part of the array
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextPermutation("abcd")); // Output: "abdc"
        System.out.println(nextPermutation("dcba")); // Output: "abcd"
        System.out.println(nextPermutation("aabb")); // Output: "abab"
    }
}
