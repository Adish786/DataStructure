package com.datastructure.intervew2025;

import java.util.*;
import java.util.stream.Collectors;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        List<Character> collect = str.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() >= 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(lengthOfLongestSubstring(str)); // 3
    }


    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

