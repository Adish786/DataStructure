package com.datastructure.SlidingWindows;

public class MaxSumSubarray {

    public static int maxSumSubarray(int[] arr, int k) {
        // Edge case: if k is greater than the array length, return 0
        if (arr.length < k) {
            return 0;
        }
        // Calculate the sum of the first window
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        // Initialize the current window sum to the maxSum
        int currentWindowSum = maxSum;
        // Slide the window from start to the end of the array
        for (int i = k; i < arr.length; i++) {
            // Update the current window sum by adding the new element and subtracting the element that is left behind
            currentWindowSum += arr[i] - arr[i - k];
            // Update the maxSum if the current window sum is greater
            maxSum = Math.max(maxSum, currentWindowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 8, 7, 6, 4};
        int k = 3;
        int result = maxSumSubarray(arr, k);
        System.out.println("The maximum sum of a subarray of size " + k + " is: " + result);
    }
}
