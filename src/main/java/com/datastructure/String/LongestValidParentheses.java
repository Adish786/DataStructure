package com.datastructure.String;

import java.util.Stack;
/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring.
Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:
Input: s = ""
Output: 0
Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s =")()())";
        System.out.println(longestValidParentheses(s));
    }
}
