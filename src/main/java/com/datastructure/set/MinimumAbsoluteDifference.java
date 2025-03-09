package com.datastructure.set;

import java.util.Arrays;
import java.util.List;
/*
Minimum absolute difference
Given a 0-indexed integer array nums and an integer k, find the minimum absolute difference between any two elements in the array that are at least k indices apart. Return the minimum absolute difference found.
Input Format:
The first line contains an integer n, the size of the array nums.
The second line contains n space-separated integers, the elements of the array nums.
The third line contains an integer k, representing the minimum index distance between two elements to be considered.
Output Format:
Print a single integer, the minimum absolute difference between two elements in the array that are at least k indices apart.
Sample Input 1:
5
5 3 2 10 15
1
Sample Output 1:
1
Explanation 1:
The elements 3 and 2 are 1 index apart, and their difference is 1 which is the minimum absolute difference for k = 1.
 */
public class MinimumAbsoluteDifference {
    public static  int minAbsoluteDifference(List<Integer> nums, int k) {
        int n = nums.size();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - k; i++) {
            for (int j = i + k; j < n; j++) {
                int diff = Math.abs(nums.get(i) - nums.get(j));
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff;
    }
    public static void main(String[] args) {
     List<Integer> nums = Arrays.asList(5, 3 ,2 ,10, 15);
     int k = 3;
        System.out.println(minAbsoluteDifference(nums,k));
    }
}
