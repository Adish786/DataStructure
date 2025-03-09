package com.datastructure.intervewPattern2025;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
Shift Zeros to the End
Given an array of integers, modify the array in place to move all zeros to the end while
maintaining the relative order of non-zero elements.
Example:
Input: nums = [0, 1, 0, 3, 2]
Output: [1, 3, 2, 0, 0]
 */
public class ShiftZerosToTheEnd {
    public static void main(String[] args) {
        int[] arr ={0,1,2,4,0,12,0,43,0,32};
        System.out.println(Arrays.toString(pushAllZeros(arr)));

    }

    public static int[] pushAllZeros(int[] arr) {
        int[] allNonZero = Arrays.stream(arr).filter(num -> num != 0).toArray();
        long allZero = Arrays.stream(arr).filter(num -> num == 0).count();
        int[] result = IntStream.concat(Arrays.stream(allNonZero), IntStream.generate((() -> 0)).limit(allZero)).toArray();
        return result;
    }
}
