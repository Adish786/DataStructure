package com.datastructure.SessionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You're a daring jewel thief infiltrating the vault of the century, protected by a complex combination lock. Each dial holds a glittering gem, their values encoded in integers (represented by the nums array).
To crack the lock, you need to arrange the gems in a specific order: for each adjacent pair, either the first gem's value must divide evenly into the second's, or vice versa. But cracking such a combination requires more than just brute force!
You're given an array of nums containing the values of the vault's gems (n distinct positive integers between 1 and 10^9).
Your mission is to find the total number of possible "special" arrangements of these gems, where every pair satisfies the divisibility requirement (i.e., forms a harmonious sequence). Since the number of special arrangements can be huge, you need to return the answer modulo 10^9 + 7 to avoid numerical overflows.
Input/Output Format:
Input:
An array nums containing the gem values separated by spaces or commas.
Output:
Return a single integer representing the total number of special gem arrangements modulo 10^9 + 7.
Examples:
Input:
2 3 6 (Three gems in the vault)
Output:
2 (Only two arrangements work: [3 6 2] and [2 6 3])
Input:
1 4 3 (Another vault to plunder)
Output:
2 (Similar to the first example, only two special arrangements exist: [3 1 4] and [4 1 3])
 */
public class SpecialArrangements {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,3,6);
        System.out.println(specialArr(nums));
    }
    private static final int MOD = 1_000_000_007;
    private static int count = 0;
    public static int specialArr(List<Integer> nums) {
        Arrays.sort(nums.toArray());
        boolean[] used = new boolean[nums.size()];
        List<Integer> currentArrangement = new ArrayList<>();
        backtrack(nums, used, currentArrangement);
        return count;
    }

    private static void backtrack(List<Integer> nums, boolean[] used, List<Integer> currentArrangement) {
        if (currentArrangement.size() == nums.size()) {
            count = (count + 1) % MOD;
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) continue;
            if (currentArrangement.isEmpty() || isDivisible(currentArrangement.get(currentArrangement.size() - 1), nums.get(i))) {
                used[i] = true;
                currentArrangement.add(nums.get(i));
                backtrack(nums, used, currentArrangement);
                currentArrangement.remove(currentArrangement.size() - 1);
                used[i] = false;
            }
        }
    }
    private static boolean isDivisible(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
}
