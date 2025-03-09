package com.datastructure.map;

/*
Number of subarrays with given sum
Sample Input 1:
5 10
10 1 4 2 3
Sample Output 1:
2
Explanation 1:
We have two such subarrays where the sum of elements is equal to 10 and they are {10} and {4, 2, 3, 1}
 */

import java.util.HashMap;
public class SubarraySum {
    public static void main(String[] args) {
        int[] arr ={10, 1, 4, 2, 3};
        int k =5;
        System.out.println(subarraySum(arr,k));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int targetSum = sum - k;
            if (map.containsKey(targetSum)) {
                count += map.get(targetSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
