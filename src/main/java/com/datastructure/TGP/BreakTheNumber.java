package com.datastructure.TGP;
import java.util.HashMap;
import java.util.Map;
/*
Given an integer n, break it into the sum of 2 or more than two integers, and maximize the product of those integers.
Return the maximum product that you can get.
Sample Input - 1:
3
Sample Output - 1:
2
Explanation: You can break it into the sum 2+1 = 3 and their product is 2 x 1 = 2 which is the maximum possible that you can get.
Sample Input -2:
10
Sample Output - 2:
36
Explanation: We can make the sum 10 as follows 3 + 3 + 4 and their product comes out to be 3x3x4 = 36, which is the maximum possible.
 */

public class BreakTheNumber {
    public static void main(String[] args) {
        int n =10;
        System.out.println(solve(n));
    }
    public static int solve(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return maxProductRec(n, memo);
    }
    private static int maxProductRec(int n, Map<Integer, Integer> memo) {
        if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            int product = Math.max(i * (n - i), i * maxProductRec(n - i, memo));
            maxProduct = Math.max(maxProduct, product);
        }
        memo.put(n, maxProduct);
        return maxProduct;
    }
}
