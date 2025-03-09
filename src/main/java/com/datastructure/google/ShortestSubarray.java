package com.datastructure.google;
/*

Shortest Subarray with Sum at Least K
Given an array of integers nums and a positive integer k, return the minimum length of the non-empty subarray of nums such that sum of its elements should be at least k. If there is no such subarray, return -1.
A subarray is defined as a contiguous sequence of an array.

Input: nums = [1, 2, 3, 4, 5], k = 11
Expected Output: 3
Justification: The shortest subarray with a sum of at least 11 is [3, 4, 5], which has a length of 3.

Time Complexity :- O(n)
Space Complexity :- O(n)

*/


import java.util.Deque;
import java.util.LinkedList;
public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < prefixSums.length; i++) {
            while (!deque.isEmpty() && prefixSums[i] - prefixSums[deque.getFirst()] >= k)
                result = Math.min(result, i - deque.pollFirst());
            while (!deque.isEmpty() && prefixSums[i] <= prefixSums[deque.getLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public static void main(String[] args) {
        ShortestSubarray solution = new ShortestSubarray();
        System.out.println(solution.shortestSubarray(new int[]{1, 2, 3, 4, 5}, 11)); // Expected output: 3
        System.out.println(solution.shortestSubarray(new int[]{1, -1, 5, 2, 3, 4, 3, 2}, 8)); // Expected output: 3
        System.out.println(solution.shortestSubarray(new int[]{-1, -1, -2, -3}, 2)); // Expected output: -1
    }
}
