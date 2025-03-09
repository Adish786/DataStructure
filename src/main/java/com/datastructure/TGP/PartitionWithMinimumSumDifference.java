package com.datastructure.TGP;

/*
Given an integer array nums, representing the number of chocolates in ith bag where 1<=i<=N and N is the length of Array nums , Alice and Bob are best friends they want to share chocolates in such a way that minimises the absolute difference between the sum of two arrays. Return the minimum possible absolute difference.
For example the given array is [8, 6, 5] and we divide it in arrays [6,5] and [8] then the absolute difference of these arrays would be |8 - (6+5)| = 3. You have to seperate the array in such a way that the absolute difference between the array is minimised.
Example 1 :
Input:  nums = [3,9,7,3]
Output: 2
Example 2 :
Input: nums = [36,36]
Output: 0
 */
public class PartitionWithMinimumSumDifference {
    public static void main(String[] args) {
        int[] arr = {3,9,7,3};
        int n = 4;
        System.out.println(minDifference(arr,n));
    }
    public static int minDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        return findMinDifference(arr, 0, 0, totalSum);
    }

    private static int findMinDifference(int[] nums, int currentIndex, int currentSum, int totalSum) {
        if (currentIndex == nums.length) {
            int otherSum = totalSum - currentSum;
            return Math.abs(currentSum - otherSum);
        }
        int includeCurrent = findMinDifference(nums, currentIndex + 1, currentSum + nums[currentIndex], totalSum);
        int excludeCurrent = findMinDifference(nums, currentIndex + 1, currentSum, totalSum);
        return Math.min(includeCurrent, excludeCurrent);
    }
}
