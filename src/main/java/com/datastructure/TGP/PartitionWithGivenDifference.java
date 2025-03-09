package com.datastructure.TGP;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, representing the number of chocolates in the ith bag where 1 <= i <= N and N is the length of Array nums, Alice and Bob are best friends. They want to share chocolates in such a way that the absolute difference between their set of chocolates is d, also make sure that Alice always gets the bigger or equal part. Count how many possible ways there are for such partitions. Since the answer can be large, print it with modulo 10^9+7.
Note: that they can pick the chocolates in any order and same numbers are not considered as identical.
Constraints:
1 ≤ N ≤ 50
0 ≤ D ≤ 2500
0 ≤ ARR[i] ≤ 50
Example:
Input:
N = 4
d = 3
arr = [5, 2, 6, 4]
Output:
1
Explanation: The way they can distribute is for Bob we can pick chocolates at index 0,1 and for Alice chocolates at index 2,3 which is the only way we can get a total minimum difference between them to be 3 (abs(6 + 4 - 5 - 2) = 3).
Input:
N = 4
d = 0
arr = [1, 1, 1, 1]
Output:
6
Explanaton: There are multiple ways these chocolates can be distributed. Below are all the ways the chocolates will be distributed to Alice and the remaining would go to Bob.
Alice can take chocolates at index 0,1 (1st way)
Alice can take chocolates at index 0,2 (2nd way)
at index 0,3 (3rd way)
at index 1,2 (4th way)
at index 1,3 (5th way)
at index 2,3 (6th way)
Note: that it is asking us to seperate them in sets
 */
public class PartitionWithGivenDifference {
    public static void main(String[] args) {
        int n =4;
        int d =0;
        int[] arr= {1, 1, 1, 1};
        System.out.println(countPartitions(n,d,arr));
    }
    private static final int MOD = 1000000007;
    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if ((totalSum + d) % 2 != 0) {
            return 0;
        }
        int targetSum = (totalSum + d) / 2;
        Map<String, Integer> memo = new HashMap<>();
        return countSubsets(arr, n, targetSum, 0, memo);
    }

    private static int countSubsets(int[] nums, int n, int targetSum, int currentIndex, Map<String, Integer> memo) {
        if (targetSum == 0) {
            return 1;
        }
        if (currentIndex >= n) {
            return 0;
        }
        String key = currentIndex + "," + targetSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int include = 0;
        if (nums[currentIndex] <= targetSum) {
            include = countSubsets(nums, n, targetSum - nums[currentIndex], currentIndex + 1, memo);
        }
        int exclude = countSubsets(nums, n, targetSum, currentIndex + 1, memo);
        int result = (include + exclude) % MOD;
        memo.put(key, result);
        return result;
    }
}
