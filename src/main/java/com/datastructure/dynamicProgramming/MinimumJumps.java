package com.datastructure.dynamicProgramming;
/*
Given an array of ( N ) integers arr[] where each element represents the maximum length of the jump that can be made forward from that element. This means if arr[i] = x, then we can jump any distance ( y ) such that ( y <= x ).
Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.
Note: Return -1 if you can't reach the end of the array.
Input Format:
The first line contains a single integer ( T ) denoting the number of test cases. For each test case:
The first line contains a single integer ( N ) denoting the number of elements in the array.
The second line contains ( N ) space-separated integers denoting the elements of the array.
Output Format:
Return the minimum number of jumps to reach the end of the array. If not possible, return -1.
Sample Input 1:
1
11
1 3 5 8 9 2 6 7 6 8 9
Sample Output 1:
3
Explanation 1:
First jump from the 1st element to the 2nd element with value 3. Now, from here we jump to the 5th element with value 9, and from here we will jump to the last.
Sample Input 2:
1
6
1 4 3 2 6 7
Sample Output 2:
2
Explanation 2:
First we jump from the 1st to the 2nd element and then jump to the last element
 */

public class MinimumJumps {
    public static int minJumps(int[] arr, int n) {
        if (arr[0] == 0) {
            return -1;
        }
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        int result = minJumpsRec(arr, 0, n, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public static int minJumpsRec(int[] arr, int currentIndex, int n, int[] memo) {
        if (currentIndex >= n - 1) {
            return 0;
        }
        if (arr[currentIndex] == 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }
        int minJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + arr[currentIndex];
        for (int i = start; i <= end && i < n; i++) {
            int jumps = minJumpsRec(arr, i, n, memo);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }
        memo[currentIndex] = minJumps;
        return minJumps;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = 11;
        System.out.println(minJumps(arr,n));
    }
}
