package com.datastructure.utils;
/*
Write a Program for Prifix Sum Example
input  int ar[] = {1,2,3,4,5};
output :- 1 3 6 10 15
Time Complexity :- O(n^2)
Space Complexity:- O(1)
 */

public class PrifixSum {
    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5};
        System.out.println(prefixSum(ar));
    }
    public static int prefixSum(int arr[]){
        int i;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0]; //initializing first element
        for ( i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for ( i = 0; i < arr.length-1; i++) {
            System.out.print(prefix[i]+" "); //printing the array
        }
        return prefix[i];
    }
/*
//TODO This is total of sum logic
    public static int prefixSum1(int[] arr){
        int sum =0;
        int[] prefixSum = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            prefixSum[i]=sum+arr[i];
            sum =prefixSum[i];
        }
        return sum;
    }

 */
}
