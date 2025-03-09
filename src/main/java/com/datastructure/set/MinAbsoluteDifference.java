package com.datastructure.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Sample Input 2:
int n =4
 1 2 3 4
Sample Output 2:
3
 */
public class MinAbsoluteDifference {
    public static void main(String[] args) {
        List<Integer> arr= Arrays.asList( 1, 2, 3, 4);
        int x=4;
        System.out.println(minAbsoluteDifference(arr,x));
    }
    public static int minAbsoluteDifference(List<Integer> arr, int x) {
        int minDiff = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int num : arr) {
            if (set.contains(num + 1)) {
                minDiff = Math.min(minDiff, Math.abs(num + 1 - num));
            }
            if (set.contains(num - 1)) {
                minDiff = Math.min(minDiff, Math.abs(num - 1 - num));
            }
        }
        return minDiff;

    }
}
