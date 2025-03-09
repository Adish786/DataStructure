package com.datastructure.sort;

import java.util.HashSet;
import java.util.Set;

/*
find all unique pairs of numbers in an array that sum up to a given target k
Time Complexity: O(N)
Space Complexity: O(N)
Input :- int[] nums = {1, 5, 7, -1, 5};
Output: Pairs with sum 6:  (1, 5)
                            (-1, 7)
 */
public class PairSum {
    public static Set<Pair> findPairsWithSum(int[] nums, int k) {
        Set<Pair> result = new HashSet<>();
        if (nums == null || nums.length < 2) {
            return result;
        }
        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            int complement = k - num;
            if (seenNumbers.contains(complement)) {
                result.add(new Pair(Math.min(num, complement), Math.max(num, complement)));
            }
            seenNumbers.add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 7, -1, 5};
        int k = 6;
        Set<Pair> pairs = findPairsWithSum(nums, k);
        System.out.println("Pairs with sum " + k + ":");
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
        // Output:
        // Pairs with sum 6:
        // (1, 5)
        // (-1, 7)
    }
}
