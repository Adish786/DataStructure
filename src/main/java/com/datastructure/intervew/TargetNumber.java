package com.datastructure.intervew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*

Find Target Indices After Sorting Array
Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.

 */



public class TargetNumber {
    public static void main(String[] args) {
        int[] list = {1,2,5,2,3};
        int target = 2 ;
       List<Integer> arrayList =  targetIndices(list,target);
        System.out.println(arrayList);
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
       Arrays.sort(nums);
       List<Integer> list = new ArrayList<>();
       for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==target){
                list.add(i);
            }
        }
       return list;
    }
}
