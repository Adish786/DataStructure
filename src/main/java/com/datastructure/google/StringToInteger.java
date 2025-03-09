package com.datastructure.google;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));         // Output: 42
        System.out.println(myAtoi("   -42"));     // Output: -42
        System.out.println(myAtoi("4193 with words")); // Output: 4193
        System.out.println(myAtoi("words and 987"));   // Output: 0
        System.out.println(myAtoi("-91283472332"));    // Output: -2147483648 (overflow case)
    }
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, n = s.length();
        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // Check for optional sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // Convert digits to integer
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Check for overflow and underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}
