package com.datastructure.stack;

import java.util.Stack;
/*
Maximum Possible Breadth of Ramp
A ramp in an integer array nums is a pair ((i, j)) for which (i < j) and (nums[i] <= nums[j]). The breadth of such a ramp is (j - i). Given an integer array nums, return the maximum breadth of a ramp in nums.
If there is no ramp in nums, return 0.
Input Format:
The first line contains an integer n denoting the length of the array.
The second line contains n space-separated integers denoting the array nums.
Output Format:
A single integer denoting the maximum breadth of a ramp.
Sample Input 1:
6
6 0 8 2 1 5
Sample Output 1:
4
Explanation:
The maximum breadth ramp is achieved at ((i, j) = (1, 5)): (nums[1] = 0) and (nums[5] = 5).
Sample Input 2:
10
9 8 1 0 1 9 4 0 4 1
Sample Output 2:
7
Explanation:
The maximum breadth ramp is achieved at ((i, j) = (2, 9)): (nums[2] = 1) and (nums[9] = 1)
 */
public class MaximumPossibleBreadthOfRamp {
    public static int maxBreadthRamp(int n, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int maxBreadth = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxBreadth = Math.max(maxBreadth, j - i);
            }
        }
        return maxBreadth;
    }
    public static void main(String[] args) {
        int[] arr = {6, 0, 8, 2, 1, 5};
        int n =6;
        System.out.println(maxBreadthRamp(n,arr));
    }
}
