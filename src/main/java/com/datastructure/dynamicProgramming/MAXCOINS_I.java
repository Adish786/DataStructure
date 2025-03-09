package com.datastructure.dynamicProgramming;
/*
Nitin is an explorer, and he has a map that consists of n houses along a coastline of a beach. Each house has a certain amount of money stashed. The only constraint stopping Nitin from getting each of them is that adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money in each house, return the maximum amount of money Nitin can rob tonight without alerting the police.
Input Format:
The first line contains an integer N representing the number of houses.
The second line contains N space-separated integers representing the amount of money in each house.
Output Format:
A single integer denoting the maximum amount of money Nitin can rob without alerting the police.
Sample Input 1:
4
1 2 3 1
Sample Output 1:
4
Explanation:
Nitin can rob the 1st and 3rd houses, obtaining a total of 1 + 3 = 4.
Sample Input 2:
5
2 7 9 3 1
Sample Output 2:
12
Explanation:
Nitin can rob the 1st, 3rd, and 5th houses, obtaining a total of 2 + 9 + 1 = 12
 */
public class MAXCOINS_I {
    public static   int maxCoins_I(int n, int[] arr) {
        int[] memo = new int[arr.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return coins(arr, arr.length - 1, memo);
    }
    private static int coins(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        memo[i] = Math.max(coins(nums, i - 2, memo) + nums[i], coins(nums, i - 1, memo));
        return memo[i];
    }

    public static void main(String[] args) {
        int n =4;
        int[] arr = {1, 2, 3, 1};
        System.out.println(maxCoins_I(n,arr));
    }
}
