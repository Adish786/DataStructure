package com.datastructure.String;

import java.util.Arrays;

/*
Question :- Given an array of n distinct integers the task is to check whether
reversing one subarray can make the array sorted or not.
if the array is already sorted or can be made sorted by reversing one subarry print "Yes"
other wise pring "No".

 */
public class ReversingSubArray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3,6,7};
        int n=3;
        System.out.println(sortedSubArray(arr,n));
    }
    public static boolean sortedSubArray(int[] arr,int n){
        int[] temp = new int[arr.length];
        int i;
        int start = -1;
        int end = -1;
        for(i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        for(i=0;i<=arr.length;i++)
        {
            if(arr[i]!=temp[i]){
                start = i;
                break;
            }
        }
        for (i = arr.length-1;  i>=0 ; i--) {
            if(arr[i]!=temp[i]){
                end = i;
                break;
            }
        }
        for(i=start;i<end;i++){
            if(arr[i] < arr[i+1]){
                return false;
            }
        }
        return true;
    }
    
}
