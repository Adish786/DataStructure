package com.datastructure.intervew;
/*
Write a program to find missing number in an array from 1 to n ;
Input : int n =6;
        int[] arr = {5,3,2,1,7,6};
Output :- 4
 */

public class MissingNumber {
    public static void main(String[] args) {
            int n =6;
            int[] arr = {5,3,2,1,7,6};
          int aa=  missingNumber(n,arr);
        System.out.println("Missing Number is "+aa);
    }

    public static int missingNumber(int n,int[] arr){
        int sum1 =0;
        int sum2=0;
        for(int i=0;i<arr.length;i++){
            sum1 =sum1+arr[i];
        }
        n = n+1;
        sum2 = n*(n+1)/2;
        int res=  sum2-sum1;
        return res;
    }
}
