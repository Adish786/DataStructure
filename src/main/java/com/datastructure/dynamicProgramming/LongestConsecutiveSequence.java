package com.datastructure.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/*
You are given an array of integers. Your task is to find the length of the longest consecutive sequence of numbers in this array.
Input Format:
The first line contains an integer n, representing the size of the array.
The second line contains n space-separated integers, representing the elements of the array.
Output Format:
Print a single integer, which is the length of the longest consecutive sequence of numbers in the array.
Constraints:
1 <= n <= 10^5
-10^9 <= {Elements of the array} <= 10^9
Example:
Input:
6
100 4 200 1 3 2
Output:
4
Explanation:
In the given array [100, 4, 200, 1, 3, 2], the longest consecutive sequence is [1, 2, 3, 4], which has a length of 4
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
            int[] arr={100, 4, 200, 1, 3 ,2};
        System.out.println(longestConsecutiveSequence(arr));
    }
    public static int longestConsecutiveSequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                longestStreak = Math.max(longestStreak, findStreakLength(numSet, num));
            }
        }
        return longestStreak;
    }
    private static int findStreakLength(Set<Integer> numSet, int num) {
        if (!numSet.contains(num)) {
            return 0;
        }
        return 1 + findStreakLength(numSet, num + 1);
    }

}
