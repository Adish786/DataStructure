package com.datastructure.TGP;

import java.util.Stack;
/*
Given a non-negative integer represented as a string num and an integer k, remove k digits from the number so that the new number is the smallest possible. The remaining digits should maintain their original order in the string. Return the result as a string.
Input Format:
The first line contains the string num, representing the non-negative integer.
The second line contains the integer k.
Output Format:
Print the smallest possible integer as a string after removing k digits.
Sample Input 1:
1432219
3
Sample Output 1:
1219
Explanation:
Removing the digits 4, 3, and 2 from "1432219" leads to the new number "1219", which is the smallest possible result.
Sample Input 2:
10200
1
Sample Output 2:
200
Explanation:
Removing one digit (the leading 1) from "10200" results in "0200", and removing the leading zeroes gives "200" as the smallest possible result.
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k =3;
        System.out.println(removeKdigits(num,k));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
