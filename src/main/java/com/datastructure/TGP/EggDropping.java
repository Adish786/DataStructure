package com.datastructure.TGP;

import java.util.HashMap;
import java.util.Map;

/*
You are given N identical eggs and you have access to a K-floored building from 1 to K.
There exists a floor f where 0 <= f <= K such that any egg dropped from a floor higher than f will break, and any egg dropped from or below floor f will not break. There are few rules given below.
An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
Return the minimum number of moves that you need to determine with certainty what the value of f is.
For more description on this problem see the wiki page
Example 1:
Input:
N = 1, K = 2
Output: 2
Explanation:
1.Drop the egg from floor 1. If it breaks, we know that f = 0.
2.Otherwise, drop the egg from floor 2.If it breaks,we know that f = 1.
3.If it does not break, then we know f = 2.
4. Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

 */
public class EggDropping {
    public static void main(String[] args) {
        int n =1;
        int k =2 ;
        System.out.println(eggDrop(n,k));
    }
    public static int eggDrop(int n, int k) {
        Map<String, Integer> memo = new HashMap<>();
        return eggDropRec(n, k, memo);
    }
    private static int eggDropRec(int N, int K, Map<String, Integer> memo) {
        if (K == 0 || K == 1) {
            return K;
        }
        if (N == 1) {
            return K;
        }
        String key = N + "," + K;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int minAttempts = Integer.MAX_VALUE;
        for (int x = 1; x <= K; x++) {
            int breakCount = eggDropRec(N - 1, x - 1, memo);
            int notBreakCount = eggDropRec(N, K - x, memo);
            int worstCaseAttempts = 1 + Math.max(breakCount, notBreakCount);
            minAttempts = Math.min(minAttempts, worstCaseAttempts);
        }
        memo.put(key, minAttempts);
        return minAttempts;
    }
}
