package com.datastructure.intervew;

import java.util.Arrays;

public class SmallerThanCurrentNumber {
    public static void main(String[] args) {
        int[] nums1 = {8,1,2,2,3};
        int[] nums2 = {6,5,4,8};

        System.out.println(smallerNumbersThanCurrent(nums1));
        System.out.println(smallerNumbersThanCurrent(nums2));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[max + 1];
        Arrays.stream(nums).forEach(num -> freq[num]++);
        for (int i = 1; i < freq.length; i++) freq[i] += freq[i - 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = freq[nums[i] - 1];
            }
        }
        return ans;
    }
}



