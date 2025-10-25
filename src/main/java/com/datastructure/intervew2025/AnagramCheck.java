package com.datastructure.intervew2025;

import java.util.*;
import java.util.stream.*;

public class AnagramCheck {
    public static void main(String[] args) {
        String[] arr = {"bat", "tab", "tap", "cat"};
        String note = "atb";
        // Sort characters of note once
        String sortedNote = sortString(note);
        // Find matches
   List<String> result = Arrays.stream(arr).filter(word -> sortString(word).equals(sortedNote))
                .collect(Collectors.toList());

        System.out.println(result); // [bat, tab]
    }

    // Helper method to sort string characters
    private static String sortString(String str) {
        return str.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
