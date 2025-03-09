package com.datastructure.array;
/*
Given an input array of integers nums, find an integer array, let's call it differenceArray, of the same length as an input integer array.
Input: nums = [2, 5, 1, 6, 1]
Expected Output: [13, 6, 0, 7, 14]
Explanation:
For i=0: |(0) - (5+1+6+1)| = |0 - 13| = 13
For i=1: |(2) - (1+6+1)| = |2 - 8| = 6
For i=2: |(2+5) - (6+1)| = |7 - 7| = 0
For i=3: |(2+5+1) - (1)| = |8 - 1| = 7
For i=4: |(2+5+1+6) - (0)| = |14 - 0| = 14

        */

import java.util.Arrays;

public class LeftRightSum {
    private int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            differenceArray[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }
        return differenceArray;
    }
    public static void main(String[] args) {
        LeftRightSum solution = new LeftRightSum();
        int[] example1 = {2, 5, 1, 6, 1};
        int[] example2 = {3, 3, 3};
        int[] example3 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution.findDifferenceArray(example1))); // Output: [13, 6, 0, 7, 14]
        System.out.println(Arrays.toString(solution.findDifferenceArray(example2))); // Output: [6, 0, 6]
        System.out.println(Arrays.toString(solution.findDifferenceArray(example3))); // Output: [14, 11, 6, 1, 10]
    }
}
