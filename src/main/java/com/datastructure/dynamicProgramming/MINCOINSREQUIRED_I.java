package com.datastructure.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
Alice has coins of different denominations and he has to pay an amount to buy an item. Return the fewest number of coins that Alice needs to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. You may assume that you have an infinite number of each kind of coin.
Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
Example:
Input:
coins = [1,2,5], amount = 11
Output:
3
Input:
coins = [2], amount = 3
Output:
-1
 */
public class MINCOINSREQUIRED_I {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int T = 11;
        System.out.println(minimumElements(arr,T));
    }
    public static int minimumElements(int[] arr, int T) {
        Map<Integer, Integer> memo = new HashMap<>();
        int result = coinChangeRecursive(arr, T, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private static int coinChangeRecursive(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeRecursive(coins, amount - coin, memo);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        memo.put(amount, minCoins);
        return minCoins;
    }
}
