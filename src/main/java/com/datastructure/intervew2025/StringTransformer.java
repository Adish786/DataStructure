package com.datastructure.intervew2025;

import java.util.*;
import java.util.stream.*;

//TODO String str = "My Name is Adish"; output= Adish name is my
public class StringTransformer {
    public static void main(String[] args) {
        String str = "My Name is Adish";

        List<String> words = Arrays.asList(str.split(" "));

        // Swap first and last words, then adjust capitalization
        String result = IntStream.range(0, words.size())
                .mapToObj(i -> {
                    String word;
                    if (i == 0) { // Original first word becomes last
                        word = words.get(words.size() - 1);
                        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                    } else if (i == words.size() - 1) { // Original last word becomes first
                        word = words.get(0);
                        return word.toLowerCase();
                    } else {
                        word = words.get(i);
                        return word.toLowerCase();
                    }
                })
                .collect(Collectors.joining(" "));

        System.out.println("Input: " + str);
        System.out.println("Output: " + result);
    }
}
