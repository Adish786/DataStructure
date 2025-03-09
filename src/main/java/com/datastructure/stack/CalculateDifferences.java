package com.datastructure.stack;
import java.util.Stack;
/*
Given an integer array arr of length n, for each element in the array, find the nearest smaller element on both the left and right sides. If a nearest smaller element does not exist on either side, consider it as 0.
The task is to determine the maximum absolute difference between the nearest smaller elements on the left and right for every element in the array.
Input Format:
The first line contains an integer n (the size of the array).
The second line contains n space-separated integers representing the array arr.
Output Format:
Return the maximum absolute difference between the nearest smaller elements on the left and right for every element in the array.
Sample Input 1:
3
2 1 8
Sample Output 1:
1
Explanation:
Left smaller elements: ls = {0, 0, 1}
Right smaller elements: rs = {1, 0, 0}
Maximum difference of absolute values: abs(ls[i] - rs[i]) = 1

 */

public class CalculateDifferences {

    public static int maxAbsDiffNearestSmallerElements(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = 0;
            } else {
                rightSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8};
        System.out.println(maxAbsDiffNearestSmallerElements(arr));
    }
}
