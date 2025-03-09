package com.datastructure.google;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(strs);
        System.out.println(groupedAnagrams);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new ArrayList<>());
            }
            anagramMap.get(sortedString).add(s);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
