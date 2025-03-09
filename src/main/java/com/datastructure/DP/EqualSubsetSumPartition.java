package com.datastructure.DP;
/*
Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.
Example 1:
Input: {1, 2, 3, 4}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
Example 2:
Input: {1, 1, 3, 4, 7}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
Example 3:
Input: {2, 3, 4, 6}
Output: False
Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
public class EqualSubsetSumPartition {
    public static void main(String[] args) {
            int[] arr = {1, 1, 3, 4, 7};
        System.out.println(canPartition(arr));
    }
    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];
        if(sum % 2 != 0)
            return false;
        return canPartitionRecursive(num, sum/2, 0);
    }
    private static boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        if (sum == 0)
            return true;
        if(num.length == 0 || currentIndex >= num.length)
            return false;
        if( num[currentIndex] <= sum ) {
            if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
                return true;
        }
        return canPartitionRecursive(num, sum, currentIndex + 1);
    }

}
