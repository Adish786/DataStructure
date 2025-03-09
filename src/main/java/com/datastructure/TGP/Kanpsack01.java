package com.datastructure.TGP;

import java.util.HashMap;
import java.util.Map;

/*
0/1 kanpsack
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item. In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000
Example:
Input:
N = 3 W = 4 values[] = {1,2,3} weight[] = {4,5,1}
 */
public class Kanpsack01 {
    public static void main(String[] args) {
            int[] wt = {4,5,1};
            int[] val = {1,2,3};
            int n=3;
            int W= 4;
        System.out.println(knapsack(wt,val,n,W));

    }
    public static int knapsack(int[] wt, int[] val, int n, int W) {
        Map<String, Integer> memo = new HashMap<>();
        return knapsackRec(val, wt, W, 0, memo);
    }
    private static int knapsackRec(int[] values, int[] weights, int W, int currentIndex, Map<String, Integer> memo) {
        if (currentIndex >= values.length || W == 0) {
            return 0;
        }
        String key = currentIndex + "," + W;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int exclude = knapsackRec(values, weights, W, currentIndex + 1, memo);
        int include = 0;
        if (weights[currentIndex] <= W) {
            include = values[currentIndex] + knapsackRec(values, weights, W - weights[currentIndex], currentIndex + 1, memo);
        }
        int result = Math.max(include, exclude);
        memo.put(key, result);
        return result;
    }
}
