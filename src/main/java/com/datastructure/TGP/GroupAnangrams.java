package com.datastructure.TGP;

import java.util.*;
/*
Given an array of strings strs, group the anagrams together.Print the group of anagrams with a single space between them and each group in new line.Also, Print output the list of anagrams in lexicographically sorted order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Input Format:
first line contains a single integer n (size of the array).
second line contains n strings.
Output Format:
Print the group of anagrams with a single space between them
Each group in new line
Constraints:
1 <= n <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
Example:
Input:
6
eat tea tan ate nat bat
Output:
ate eat tea
bat
nat tan
Explanation:
As ate comes before bat so the group of anagrams of ate should come before group of anagrams of bat. same for others
 */
public class GroupAnangrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> anagrams = new ArrayList<>(map.values());
        for (List<String> group : anagrams) {
            Collections.sort(group);
        }
        anagrams.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return anagrams;
    }

    public static void main(String[] args) {
        String[] str = {"eat tea tan ate nat bat"};
        System.out.println(groupAnagrams(str));
    }
}
