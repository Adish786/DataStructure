package com.datastructure.stack;
import java.util.Stack;
/*
Can You Find The Magic Pattern?
Given an array of n integers nums, a magic pattern is a subsequence of three integers nums[i], nums[j], and nums[k] such that (i < j < k) and (nums[i] < nums[k] < nums[j]).
Return true if there is a magic pattern in nums, otherwise, return false.
Input Format:
The first line contains the integer n denoting the length of the array.
The second line contains n space-separated integers denoting the array nums.
Output Format:
A single Boolean (0 or 1) denoting if there is a magic pattern or not.
Sample Input 1:
4
1 2 3 4
Sample Output 1:
0
Explanation:
There is no magic pattern in the sequence.
Sample Input 2:
4
3 1 4 2
Sample Output 2:
1
Explanation:
There is a magic pattern in the sequence: ([1, 4, 2]).
Sample Input 3:
4
-1 3 2 0
Sample Output 3:
1
Explanation:
There are three magic patterns in the sequence: ([-1, 3, 2]), ([-1, 3, 0]), and ([-1, 2, 0]).
 */

public class CanYouFindTheMagicPattern {
    public static int magicPattern(int n, int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int min_i = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] < min_i) {
                return 1;
            }
            while (!stack.isEmpty() && stack.peek() < nums[j]) {
                min_i = stack.pop();
            }
            stack.push(nums[j]);
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        int n =4;
        System.out.println(magicPattern(n,arr));
    }
}
