package com.datastructure.map;

import java.util.HashMap;
import java.util.Map;

/*
Sample Input 1:
6
1 2 4 1 3 3
Sample Output 1:
[1,2] [2,1] [3,2] [4,1]
 */

public class MapImplementation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 3, 3};
        int n =6;
        System.out.println(mapImplementation(arr,n));

    }
    public static Map<Integer, Integer> mapImplementation(int[] arr, int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;


    }
}
