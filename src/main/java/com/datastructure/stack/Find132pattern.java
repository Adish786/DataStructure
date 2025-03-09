package com.datastructure.stack;
import java.util.Stack;
/*
132 Pattern
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j], and nums[k] such that (i < j < k) and (nums[i] < nums[k] < nums[j]).
Return true if there is a 132 pattern in nums, otherwise, return false
Sample Input 1:
4
1 2 3 4
Sample Output 1:
false
Explanation:
There is no 132 pattern in the sequence
Sample Input 2:
4
3 1 4 2
Sample Output 2:
true

 */

public class Find132pattern {
    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        System.out.println(find132pattern(arr));
    }
}
