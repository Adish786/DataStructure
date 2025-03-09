package com.datastructure.intervew;

import java.util.Arrays;

public class ContainDuplicate {
    public boolean containsDuplicate1(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate solution = new ContainDuplicate();
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate1(nums1)); // Expected output: false
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate1(nums2)); // Expected output: true
        int[] nums3 = {};
        System.out.println(solution.containsDuplicate1(nums3)); // Expected output: false
        int[] nums4 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate1(nums4)); // Expected output: true
    }
}
