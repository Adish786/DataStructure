package com.datastructure.intervew;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByLengthJava8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Mango", "Banana", "Apple", "Papaya");
        Map<Integer, List<String>> result = list.stream()
                .collect(Collectors.groupingBy(String::length));
        result.forEach((k, v) -> System.out.println("Key = " + k + " Value = " + v));
    }


    List<String> list = Arrays.asList("Mango", "Banana", "Apple", "Papaya");

    public Map<Integer, List<String>> getData() {
        Map<Integer, List<String>> result = new HashMap<>();
        for (String word : list) {
            int len = word.length();
            if (!result.containsKey(len)) {
                result.put(len, new ArrayList<>());
            }
            result.get(len).add(word);
        }
        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        }
        return result;
    }
}
