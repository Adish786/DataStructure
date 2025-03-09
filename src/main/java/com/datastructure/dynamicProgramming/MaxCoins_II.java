package com.datastructure.dynamicProgramming;
/*
Nitin is an explorer, and he has a map that consists of ( n ) number of houses. All houses at this place are arranged in a circle. Each house has a certain amount of money stashed.
The only constraint stopping Nitin from getting each of them is that adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money Nitin can rob tonight without alerting the police.
Input Format:
The first line contains an integer ( n ) representing the number of houses.
The second line contains ( n ) space-separated integers representing the amount of money stashed in each house.
Output Format:
An integer representing the maximum amount of money Nitin can rob tonight without alerting the police.
Sample Input 1:
4
1 2 3 1
Sample Output 1:
4
Explanation 1:
Nitin can rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount = 1 + 3 = 4.
Sample Input 2:
5
2 7 9 3 1
Sample Output 2:
11
Explanation 2:
Nitin can rob house 1 (money = 2), rob house 3 (money = 9). Total amount = 2 + 9 = 11.
Sample Input 3:
7
6 7 1 3 8 2 4
Sample Output 3:
19
Explanation 3:
Nitin can rob house 2 (money = 7), house 5 (money = 8), and house 7 (money = 4). Total amount = 7 + 8 + 4 = 19.


 */
public class MaxCoins_II {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(maxCoins(nums, 0, n - 2), maxCoins(nums, 1, n - 1));
    }

    private static   int maxCoins(int[] nums, int start, int end) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return robRecursive(nums, end, memo, start);
    }

    private static int robRecursive(int[] nums, int i, int[] memo, int start) {
        if (i < start) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        memo[i] = Math.max(robRecursive(nums, i - 2, memo, start) + nums[i], robRecursive(nums, i - 1, memo, start));
        return memo[i];
    }

    public static void main(String[] args) {
       int[] arr= { 1, 2 ,3 ,1};
        System.out.println(rob(arr));
    }
}
