package com.datastructure.TGP;
/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
Example 1
Input arr = [3,1,2,4]
Output   17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum is 17.
Example 2
Input  arr = [11,81,94,43,3]
Output  444
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumOfMins(arr));
    }
    private static final int MOD = 1_000_000_007;
    public static int sumOfMins(int[] arr) {
        return subarraySumHelper(arr, 0, arr.length - 1);
    }
    private static int subarraySumHelper(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        int leftSum = subarraySumHelper(arr, start, mid);
        int rightSum = subarraySumHelper(arr, mid + 1, end);
        int crossSum = crossSum(arr, start, mid, end);
        return (leftSum + rightSum + crossSum) % MOD;
    }
    private static int crossSum(int[] arr, int start, int mid, int end) {
        int sum = 0;
        int minLeft = Integer.MAX_VALUE;
        for (int i = mid; i >= start; i--) {
            minLeft = Math.min(minLeft, arr[i]);
            int minRight = Integer.MAX_VALUE;
            for (int j = mid + 1; j <= end; j++) {
                minRight = Math.min(minRight, arr[j]);
                sum = (sum + Math.min(minLeft, minRight)) % MOD;
            }
        }
        return sum;
    }
}
