package com.datastructure.TGP;
/*
You are given an array ‘ARR’ with N positive integers and an integer K. return true if there is a subset whose sum is equal to K.
Example :
Input : N = 4 , K = 5 , arr = [1,4,4,5]
Output : true

 */
public class SumEqualTok {
    public static void main(String[] args) {
        int[] arr ={1,4,4,5};
        int n =4;
        int k =5;
        System.out.println(isSubsetSum(arr,n,k));
    }
    public static   boolean isSubsetSum(int[] arr, int n, int k) {
        if (k == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (arr[n - 1] > k) {
            return isSubsetSum(arr, n - 1, k);
        }
        return isSubsetSum(arr, n - 1, k) || isSubsetSum(arr, n - 1, k - arr[n - 1]);
    }
}
