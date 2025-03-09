package com.datastructure.intervew;

import java.util.Arrays;

public class LeftRightSumDifference {
    public  int[] findDifferenceArray(int[] nums){
        int n = nums.length;
        int[] differenceArray = new int[n];
        int leftSum=0, rightSum=0;
        for(int i =0;i<nums.length;i++){
            rightSum += nums[i];
        }
        for(int i=0;i<nums.length;i++){
            rightSum -= nums[i];
            differenceArray[i] = Math.abs(rightSum-leftSum);
            leftSum += nums[i];
        }
        return differenceArray;
    }
    public static void main(String[] args) {
        LeftRightSumDifference difference = new LeftRightSumDifference();
        int[] example1 = {2,5,1,6,1};
        int[] example2 = {3,3,3};
        int[] example3 = {1,2,3,4,5};
        System.out.println(Arrays.toString(difference.findDifferenceArray(example1)));
        System.out.println(Arrays.toString(difference.findDifferenceArray(example2)));
        System.out.println(Arrays.toString(difference.findDifferenceArray(example3)));
    }
}
