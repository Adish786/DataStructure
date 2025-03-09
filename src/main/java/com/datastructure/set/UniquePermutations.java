package com.datastructure.set;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
/*
Unique Permutations
Given a string 's', return all the unique permutations of string 's' arranged in a lexicographical manner.
Input Format:
A single line containing string s.
Output Format:
Print all the unique permutations of string s sorted in a lexicographically sorted manner, each on a new line.
Sample Input 1:
abe
Sample Output 1:
abe
aeb
bae
bea
eab
eba
Sample Input 2:
aba
Sample Output 2:
aab
aba
baa
 */

public class UniquePermutations {
    public static void solve(String s) {
        Set<String> permutations = new TreeSet<>();
        generatePermutations(s.toCharArray(), 0, permutations);
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
    private static void generatePermutations(char[] chars, int index, Set<String> permutations) {
        if (index == chars.length) {
            permutations.add(new String(chars));
            return;
        }

        Set<Character> seen = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (!seen.contains(chars[i])) {
                seen.add(chars[i]);
                swap(chars, index, i);
                generatePermutations(chars, index + 1, permutations);
                swap(chars, index, i);  // backtrack
            }
        }
    }
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static void main(String[] args) {
        String str = "abe";
        solve(str);
    }
}
