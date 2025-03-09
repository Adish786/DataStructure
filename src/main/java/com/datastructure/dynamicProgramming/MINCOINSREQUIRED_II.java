package com.datastructure.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
/*
Alice has coins of different denominations and he has to pay an amount to buy an item. Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0. You may assume that you have an infinite number of each kind of coin.
Example:
Input:
amount = 5, coins = [1,2,5]
Output:
4
Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
 */
public class MINCOINSREQUIRED_II {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int n =0;
        int T = 5;
        System.out.println(countWaysToMakeChange(arr,n,T));
    }

  public  static long countWaysToMakeChange(int[] arr, int n, int T) {
        Map<String, Integer> memo = new HashMap<>();
        return coinChangeCombinationsRecursive(T, arr, 0, memo);
    }
    private static int coinChangeCombinationsRecursive(int amount, int[] coins, int index, Map<String, Integer> memo) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index >= coins.length) {
            return 0;
        }
        String key = amount + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int includeCoin = coinChangeCombinationsRecursive(amount - coins[index], coins, index, memo);
        int excludeCoin = coinChangeCombinationsRecursive(amount, coins, index + 1, memo);
        int result = includeCoin + excludeCoin;
        memo.put(key, result);
        return result;
    }
}
