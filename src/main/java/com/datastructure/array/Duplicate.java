package com.datastructure.array;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums= [1, 2, 3, 4]
Output: false
Explanation: There are no duplicates in the given array.
Example 2:
Input: nums= [1, 2, 3, 1]
Output: true
Explanation: '1' is repeating.
 */


public class Duplicate {
    private boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Duplicate solution = new Duplicate();
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums1)); // Expected output: false
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums2)); // Expected output: true
        int[] nums3 = {};
        System.out.println(solution.containsDuplicate(nums3)); // Expected output: false
        int[] nums4 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate(nums4)); // Expected output: true
    }
}
