package com.datastructure.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Longest Word in the Dictionary
Write a program that takes a dictionary of words as input and finds all the
longest words in the dictionary. If there are multiple longest words of the same length,
the program should output all of them
Input:
apple
banana
orange
mango
pineapple
Output:
pineapple
Explanation:
In the given dictionary, "pineapple" is the longest word with a length of 9 characters.
Therefore, the program outputs "pineapple" as the longest word.
 */

public class LongestWord {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange", "mango", "pineapple");
        System.out.println(findLongestWords(list));
    }
    public static List<String> findLongestWords(List<String> words) {
        return Collections.singletonList(words.stream().reduce((x, y) -> x.length() > y.length() ? x : y).get());
    }
}
