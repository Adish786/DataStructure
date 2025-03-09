package com.datastructure.String;
/*
Swap to Max
You are given two arrays a1,a2,…,an and b1,b2,…,bn. In one operation, you can choose any integer i from 1 to n and swap the numbers a (ith) and b (ith).
Sample Input:
3
7 9 7
7 6 9
Sample Output:
"YES"
 */

public class SwapToMax {
    public static void main(String[] args) {
        int[] arr1= {7,9,7};
        int [] arr2 = {7,6,9};
        int n=3;
        solve(n,arr1,arr2);
    }
    public static void solve(int n, int[] a, int[] b) {
        System.out.println(canSatisfyConditions(n, a, b) ? "YES" : "NO");
    }
    public static boolean canSatisfyConditions(int n, int[] a, int[] b) {
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > maxA) {
                maxA = a[i];
            }
            if (b[i] > maxB) {
                maxB = b[i];
            }
        }
        int lastA = a[n - 1];
        int lastB = b[n - 1];
        if ((maxA == lastA || maxA == lastB) && (maxB == lastB || maxB == lastA)) {
            return true;
        }
        return false;
    }
}
