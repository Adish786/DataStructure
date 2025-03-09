package com.datastructure.graind75.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.
Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(final int i :nums){
            if(!set.add(i)) return true;
        }
        return false;
    }

    /*
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

     */
    /*
    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
}
