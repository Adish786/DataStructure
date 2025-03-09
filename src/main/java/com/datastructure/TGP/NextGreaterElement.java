package com.datastructure.TGP;

import java.util.Arrays;
import java.util.Stack;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
Example 1
Input
nums = [1,2,1]
Output
[2,-1,2]
Explanation
The first 1's next greater number is 2; The number 2 can't find next greater number. The second 1's next greater number needs to search circularly, which is also 2.
Example 2
Input
nums = [1,2,3,4,3]
Output
[2,3,4,-1,4]
Input Format
Given a array nums of n element
Output Format
Output the array containing next greater element of every element if there is no next greater element output -1 on that position
Constraints
1 <= nums.size()<= 1e5
1 <= nums[i]<= 1e6
 */
public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
