package com.datastructure.String;
import java.util.Arrays;
/*
Count Occurences of Anagrams
Raman is a keen observer, he can easily see the jumbled words so one day one of his friend challenged him to count the occurrences of all the anagrams of string C in a given string S. Raman accepted the challenge but he is facing some problems in it . Can you help them ?
Input:
S=fororfrdofr
C=for
Output: 3
Input :
 S=aabaabaa
 C=aaba
Output: 4
 */

public class CountOccurencesOfAnagrams {
    public static int countAnagrams(String S, String C) {
        int n = S.length();
        int m = C.length();
        if (m > n) {
            return 0;
        }
        int[] windowFreq = new int[26];
        int[] targetFreq = new int[26];
        for (char c : C.toCharArray()) {
            targetFreq[c - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            windowFreq[S.charAt(i) - 'a']++;
        }
        int count = 0;
        if (Arrays.equals(windowFreq, targetFreq)) {
            count++;
        }
        for (int i = m; i < n; i++) {
            windowFreq[S.charAt(i) - 'a']++;
            windowFreq[S.charAt(i - m) - 'a']--;
            if (Arrays.equals(windowFreq, targetFreq)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String S = "aabaabaa";
        String C = "aaba";
        System.out.println(countAnagrams(S,C));
    }
}
