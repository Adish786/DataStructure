package com.datastructure.TGP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
You have to sort the string s in decreasing order based on the frequency of the characters. Return the sorted string. if frequency of two character are same then sort in alphabetical order.
Example 1
Input
s = "tree"
Output
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'. "eetr" is not a valid answer as r appears before t
 */
public class SortTheArray {
    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Character> characters = frequencyMap.keySet().stream().sorted((a, b) -> {
            int freqCompare = frequencyMap.get(b) - frequencyMap.get(a);
            if (freqCompare == 0) {
                return a - b;
            }
            return freqCompare;
        }).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
