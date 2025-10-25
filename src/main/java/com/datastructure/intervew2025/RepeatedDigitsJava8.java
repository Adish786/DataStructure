package com.datastructure.intervew2025;

import java.util.*;
import java.util.stream.IntStream;
/*
TODO Given an integer n, return the number of positive integers in the range [1, n] that have at least one repeated digit.
n=20
output is 1(11)
n=100
output is 10(11,22,33,44,55,66,77,88,99,100)
 */
public class RepeatedDigitsJava8 {
    public static void main(String[] args) {
        System.out.println(countRepeatedDigits(20));   // 1 -> [11]
        System.out.println(countRepeatedDigits(100));  // 10 -> [11,22,33,44,55,66,77,88,99,100]
    }

    public static long countRepeatedDigits(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(RepeatedDigitsJava8::hasRepeatedDigits)
                .count();
    }

    private static boolean hasRepeatedDigits(int num) {
        String s = String.valueOf(num);
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.add(c)) {
                return true; // duplicate found
            }
        }
        return false;
    }
}

