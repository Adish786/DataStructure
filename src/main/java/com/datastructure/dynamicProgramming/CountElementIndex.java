package com.datastructure.dynamicProgramming;
/*
Count the k =2 element present in the array show the present index in new array
input :-        int[] arr = {2,5,6,0,2,9,2};
                int k =2 ;
OutPut :- { 0, 4 , 6 }

 */

public class CountElementIndex {

    public static int[] helper(int[]arr, int k ,int index,int count){
        if(index==arr.length) return new int[count];
        if(arr[index]==k){
            int[] ans = helper(arr,k,index+1,count+1);
            ans[count] = index;
            return ans;
        }
        else {
            return helper(arr,k,index+1,count);
        }
    }
    //TODO print the element k=2 present the array
    public static int helper1(int[] arr ,int k,int index){
        if(index == arr.length) return -1;
        int ans = helper1(arr,k,index+1);
        if(ans!= -1) return ans;
        if(arr[index] ==k) ans =index;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,2,9,2};
        int[] ans =helper(arr,2,0,0);
        for(int ele :ans){
            System.out.println(ele);
        }
    }
}
