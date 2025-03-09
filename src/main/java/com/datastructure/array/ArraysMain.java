package com.datastructure.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMain {
    public static void main(String[] args) {

    }
//TODO find min max using array
    public static int[] findMaxMin(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return new int[]{max, min};
    }
    //TODO remove element  using array
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
//TODO find longest string using java 7
    public static String findLongestString(String[] stringList) {
        String longestString = "";
        for (String str : stringList) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }
        return longestString;
    }
//TODO remove duplicates
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int writePointer = 1;
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }
        return writePointer;
    }
    //TODO max profit using java 7
    public static int maxProfit(int[] prices) {
        // Initialize minPrice with the highest possible integer value.
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit with 0, assuming no profit at the beginning.
        int maxProfit = 0;
        // Loop through each price in the array.
        for (int price : prices) {
            // If current price is lower than minPrice, update minPrice.
            minPrice = Math.min(minPrice, price);
            // Calculate potential profit for current price.
            int profit = price - minPrice;
            // If current profit is more than maxProfit, update maxProfit.
            maxProfit = Math.max(maxProfit, profit);
        }
        // After checking all prices, return the maximum profit.
        return maxProfit;
    }

    //TODO retate array using java 7
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        // Reverse the first part
        for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the second part
        for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the whole array
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    //TODO max subarray using java 7
    public static int maxSubarray(int[] nums) {
        // Check if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Initialize the maximum sum and current sum with the first element
        int maxSum = nums[0];
        int currentSum = nums[0];

        // Loop through the rest of the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update the current sum to be the larger between the current number
            // and the current sum added with the current number
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update the maximum sum to be the larger between the old maximum sum
            // and the updated current sum
            maxSum = Math.max(maxSum, currentSum);
        }
        // After the loop, return the maximum sum found
        return maxSum;
    }
    //TODO fibonacic using 7
    public static int fib(int n){
        int[] fibList = new int[n+1];
        fibList[0] =0;
        fibList[1] =1;
        for(int index =2;index<=n;index++){
            fibList[index] = fibList[index-1] +fibList[index-2];
        }
        return fibList[n];
    }

}
