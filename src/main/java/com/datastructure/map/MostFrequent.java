package com.datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 6, 6, 6, 7, 7, 8};
        System.out.println(mostFrequent(arr));
    }
    public static int mostFrequent(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer element : arr) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }
        Integer mostFrequent = null;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

}
