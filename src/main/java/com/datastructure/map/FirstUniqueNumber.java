package com.datastructure.map;

import java.util.LinkedHashMap;
import java.util.Map;
/*
First Unique Number
Given a non-empty list of elements, return the sequentially first element which occurred only once in the array.
Input:
4
9 6 7 6
Output:
9
 */

public class FirstUniqueNumber {
    public static void main(String[] args) {
        int[] arr = {9, 6, 7, 6 };
        System.out.println(firstUniqueInteger(arr));
    }
    public static int firstUniqueInteger(int[] v) {
        LinkedHashMap<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int num : v) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
