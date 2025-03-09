package com.datastructure.graind75.medium;
/*
Given an integer array nums, find the
subarray  with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        //int n = nums.length;
        int maxi = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            maxi = maxi<sum?sum:maxi;
            if(sum<0) sum = 0;
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));

    }
}
