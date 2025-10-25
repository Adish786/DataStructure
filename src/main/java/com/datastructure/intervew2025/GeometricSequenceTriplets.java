package com.datastructure.intervew2025;
/*
Geometric Sequence Triplets
A geometric sequence triplet is a sequence of three numbers where each successive number is
obtained by multiplying the preceding number by a constant called the common ratio.
Let's examine three triplets to understand how this works:
● (1, 2, 4): Geometric sequence with a ratio of 2 (i.e., [1, 1·2 = 2, 2·2 = 4]).
● (5, 15, 45): Geometric sequence with a ratio of 3 (i.e., [5, 5·3 = 15, 15·3 = 45]).
● (2, 3, 4): Not a geometric sequence.
Given an array of integers and a common ratio r, find all triplets of indexes (i, j, k) that follow
geometric sequence for i < j < k. It’s possible to encounter duplicate triplets in the array.
Example:
Input: nums = [2, 1, 2, 4, 8, 8], r = 2
Output: 5
Explanation: Triplet [2, 4, 8] occurs at indexes (0, 3, 4), (0, 3, 5), (2, 3, 4), (2, 3, 5). Triplet
[1, 2, 4] occurs at indexes (1, 2, 3).
 */
import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplets {
    public static int countGeometricTriplets(int[] nums, int r) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Map<Integer, Integer> middleMap = new HashMap<>();
        Map<Integer, Integer> lastMap = new HashMap<>();
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            // If the current number can be the middle element of a triplet
            if (lastMap.containsKey(current * r)) {
                // Add the frequency of the last element to the count
                count += lastMap.get(current * r);
            }
            // If the current number can be the last element of a triplet
            if (middleMap.containsKey(current * r)) {
                // Update the frequency of the last element in the lastMap
                lastMap.put(current, lastMap.getOrDefault(current, 0) + middleMap.get(current * r));
            }
            // Update the frequency of the current number in the middleMap
            middleMap.put(current, middleMap.getOrDefault(current, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 8, 8};
        int r = 2;
        System.out.println("Number of geometric sequence triplets: " + countGeometricTriplets(nums, r));
    }
}
