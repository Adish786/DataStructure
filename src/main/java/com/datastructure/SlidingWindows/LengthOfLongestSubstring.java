package com.datastructure.SlidingWindows;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}
