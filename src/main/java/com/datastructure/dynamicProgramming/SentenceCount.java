package com.datastructure.dynamicProgramming;
import java.util.*;
/*
Sentence Count
Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. Each dictionary word can be used more than once. Return the number of such possible sentences.
Input Format:
The first line contains the number of words in the dictionary denoted by the integer n.
The second line contains n space-separated strings for the dictionary.
The third line contains the string s which is to be transformed into a sentence.
Output Format:
A single integer denoting the number of possible sentences.
Sample Input 1:
8
he hebrew brew bible isa book is a hebrewbibleisabook
Sample Output 1:
4
Explanation:
The possible sentences are:
he brew bible isa book
hebrew bible isa book
hebrew bible is a book
he brew bible is a book
 */

public class SentenceCount {

    public static int wordBreak(int n, List<String> dict, String S) {
        Set<String> dictSet = new HashSet<>(dict);
        Map<String, Integer> memo = new HashMap<>();
        return countSentencesHelper(S, dictSet, memo);
    }
    private static int countSentencesHelper(String s, Set<String> dict, Map<String, Integer> memo) {
        if (s.isEmpty()) {
            return 1;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                count += countSentencesHelper(s.substring(i), dict, memo);
            }
        }
        memo.put(s, count);
        return count;
    }
    public static void main(String[] args) {
        int n=8;
        List<String> dict=  new ArrayList<>();
        dict.add("he hebrew brew bible isa book is a");
        String S= "hebrewbibleisabook";
        System.out.println(wordBreak(n,dict,S));
    }
}
