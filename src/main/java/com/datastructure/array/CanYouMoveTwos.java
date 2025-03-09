package com.datastructure.array;
import java.util.Arrays;
import java.util.List;
/*
Can you move two's?
Given an integer array nums, move all 2's to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.
You don't need to return anything in the function, just perform in-place operations.
Input Format
The first line contains an integer ( n ), representing the number of elements in the array.
The second line contains ( n ) space-separated integers representing the elements of the array nums.
Output Format
Print the elements of the array after moving all 2's to the end.
Sample Input 1
3
2 2 1
Sample Output 1
1 2 2
Explanation For the given input, the array after moving all 2's to the end while maintaining the relative order of the non-zero elements is [1, 2, 2]

*/

public class CanYouMoveTwos {
    public static void moveTwos(List<Integer> nums) {
        int n = nums.size();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) != 2) {
                nums.set(index++, nums.get(i));
            }
        }
        while (index < n) {
            nums.set(index++, 2);
        }
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 2, 1);
        moveTwos(nums);
    }
}
