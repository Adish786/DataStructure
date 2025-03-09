package com.datastructure.map;

import java.util.HashMap;
/*
Number of subarrays with given sum
Given an array of integers nums and an integer k, your task is to devise an efficient algorithm that determines the number of subarrays within the given array, where the sum of elements in each subarray is exactly equal to the given value k.

Note: A subarray is defined as a continuous and non-empty sequence of elements extracted from the original array.

Input Format:

The first line contains two integers n and k, where n is the number of elements in the array and k is the target sum.
The second line contains n space-separated integers denoting the elements of the array.
Output Format: Print the number of subarrays where the sum of elements is equal to k.
Sample Input 1:
5 10
10 1 4 2 3
Sample Output 1:
2
Explanation 1:
We have two such subarrays where the sum of elements is equal to 10 and they are {10} and {4, 2, 3, 1}.
Sample Input 2:
6 6
-4 4 3 3 8 -2
Sample Output 2:
3
Explanation 2:
There are in total 3 subarrays whose sum is equal to 6 and they are {-4, 4, 3, 3}, {3, 3}, and {8, -2}
 */
public class NumberOfSubarrays{
    public static int findSubarraySum(int[] arr, int n, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {-4, 4, 3, 3, 8, -2};
        int n=6;
        int k =6;
        System.out.println(findSubarraySum(arr,n,k));
    }
}
