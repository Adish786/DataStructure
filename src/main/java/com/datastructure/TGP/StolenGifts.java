package com.datastructure.TGP;

import java.util.HashMap;
import java.util.Map;

/*
A thief wants to steal gifts from a shop where gifts are arranged in a linear order. The thief's safety mechanism triggers an alarm unless he steals a precise number of gifts quantified by value, not by count. The task is to determine the number of unique ways the thief can combine the gifts to achieve exactly k value without triggering the alarm.
Objective:
Calculate the number of distinct combinations of gifts that sum up to exactly k.
Constraints:
1 <= n <= 100 where n is the number of gifts.
0 <= gifts[i] <= 1000 where gifts[i] is the value of the i-th gift.
1 <= k <= 1000 where k is the exact value of gifts the thief needs to steal to avoid triggering the alarm.
Input Format:
The input consists of three lines:
  1. An integer n, the number of gifts.
  2. An integer k, the exact total value of gifts the thief must steal.
  3. A list of n integers, each representing the value of a gift.
Output Format:
An integer representing the number of unique combinations of gifts that sum up to exactly k.
Sample Inputs and Outputs:
Example 1:
Input:
int[] arr ={1, 2, 3, 4, 5 ,6, 7, 8, 9, 10};
        int n =10;
        int k =5;
Output:
3
Explanation: There are three unique ways to achieve a total gift value of 3:
Using the gifts with values [1, 2, 1]
Using the gifts with values [1, 3]
Using the gifts with values [2, 2]
Note:
The combination [2, 2] is counted as one unique way even though the values come from different positions in the array.
 */
public class StolenGifts {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 5 ,6, 7, 8, 9, 10};
        int n =10;
        int k =5;
        System.out.println(solve(arr,n,k));
    }
    public static int solve(int[] ar, int n, int k) {
        Map<String, Integer> memo = new HashMap<>();
        return countWays(ar, n, k, 0, memo);
    }

    private static int countWays(int[] gifts, int n, int k, int currentIndex, Map<String, Integer> memo) {
        if (k == 0) {
            return 1;
        }
        if (currentIndex >= n || k < 0) {
            return 0;
        }
        String key = currentIndex + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int include = countWays(gifts, n, k - gifts[currentIndex], currentIndex + 1, memo);
        int exclude = countWays(gifts, n, k, currentIndex + 1, memo);
        int result = include + exclude;
        memo.put(key, result);
        return result;
    }
}
