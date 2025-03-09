package com.datastructure.sort;

import java.util.HashSet;
import java.util.Set;
/*
 find the longest sequence of consecutive numbers in an unsorted array
 Time complexity of O(n)
 Space complexity :- O(1)
 Input :-  int[] nums = {100, 4, 200, 1, 3, 2};
 Output: 4 (The sequence is [1, 2, 3, 4])
 */

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums)); // Output: 4 (The sequence is [1, 2, 3, 4])
    }
}
