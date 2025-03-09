package com.datastructure.stack;

import java.util.Stack;
/*
Iron Bars
You are a blacksmith at Iron&Steel Sons. You are presented with a large piece of iron sheet by a client who says it's waste material from the construction of his house.
The sheet is in a weird shape because it has been created by welding together a number of rectangular iron sheets side by side of width 1cm but of variable height.
The client wants you to cut out the greatest rectangle-shaped iron sheet from the given shape.
You are given an array representing the height of each iron sheet which was welded into the larger iron sheet. Remember each of these sheets had a width of 1cm. Your task is to return the area of the largest rectangular iron sheet that can be cut out from this.
Input Format:
The first line contains an integer n (the number of iron sheets).
The second line contains n space-separated integers representing the height of each iron sheet.
Output Format:
Return the area of the largest rectangular iron sheet that can be cut out.
Sample Input 1:
5
1 3 4 5 4
Sample Output 1:
12
Explanation: We can pick the 3rd, 4th, and 5th indices and cut out an area of (4 * 3 = 12 cm^2) of iron sheet
 */

public class IronBars {
    public static void main(String[] args) {
        long[] arr = {1, 3, 4, 5, 4};
        int n =5;
        System.out.println(getMaxArea(arr,n));
    }
    public static long getMaxArea(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int m = arr.length;
        for (int i = 0; i <= m; i++) {
            long currentHeight = (i == m) ? 0 : arr[i];
            while (!stack.isEmpty() && currentHeight < arr[stack.peek()]) {
                long height = arr[stack.pop()];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
