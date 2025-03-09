package com.datastructure.map;
/*
Longest Subarray with Equal Number of 0s and 1s
Input:
3
0 1 0
Output:
2
Explanation:
[0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 */

import java.util.HashMap;
public class FindMaxLength {
    public static void main(String[] args) {
        int[] arr ={0,1,0};
        System.out.println(findMaxLength(arr));
    }
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
