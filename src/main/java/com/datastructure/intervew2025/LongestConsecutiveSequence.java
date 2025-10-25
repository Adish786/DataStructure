package com.datastructure.intervew2025;

import java.util.HashSet;
import java.util.Set;
/*
Longest Chain of Consecutive Numbers
Find the longest chain of consecutive numbers in an array. Two numbers are consecutive if
they have a difference of 1.
Example:
Input: nums = [1, 6, 2, 5, 8, 7, 10, 3]
Output: 4
Explanation: The longest chain of consecutive numbers is 5, 6, 7, 8.
 */

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Create a HashSet to store all the numbers for quick lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        // Iterate through each number in the set
        for (int num : numSet) {
            // Check if the current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // Increment the current number and check if the next number exists in the set
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                // Update the longest streak if the current streak is longer
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 2, 5, 8, 7, 10, 3};
        System.out.println("The longest chain of consecutive numbers is: " + longestConsecutive(nums));
    }
}