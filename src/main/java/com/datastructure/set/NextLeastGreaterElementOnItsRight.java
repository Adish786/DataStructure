package com.datastructure.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
/*
Next least greater element on its right
Given an array nums of n integers, replace every element with the least greater element on its right side in the array. If there are no greater elements on the right side, replace it with -1.
Input Format:
The first line contains an integer n, denoting the number of elements in the array.
The second line contains n space-separated integers representing the elements of the array.
Output Format:
A single line containing n space-separated integers, where each integer is the least greater element on the right side of each element in the array. If no such element exists, print -1.
Sample Input 1:
15
8 58 71 18 31 32 63 92 43 3 91 93 25 80 28
Sample Output 1:
18 63 80 25 32 43 80 93 80 25 93 -1 28 -1 -1
Explanation 1:
For each element in the array, the least greater element on its right side is found and replaced. If no such element exists, -1 is used.
Sample Input 2:
6
2 6 9 1 3 2
Sample Output 2:
3 9 -1 2 -1 -1
Explanation 2:
For each element in the array, the least greater element on its right side is found and replaced. If no such element exists, -1 is used
 */
public class NextLeastGreaterElementOnItsRight {
    public static ArrayList<Integer> findLeastGreater(int n, int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {
            Integer leastGreater = set.higher(nums[i]);
            if (leastGreater == null) {
                result.add(-1);
            } else {
                result.add(leastGreater);
            }
            set.add(nums[i]);
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 1, 3, 2};
        int n =6;
        System.out.println(findLeastGreater(n,arr));
    }
}
