package com.datastructure.stack;
/*
Given a string s containing (, ), [, ], {, and } characters. Determine if a given string of parentheses is balanced.
A string of parentheses is considered balanced if every opening parenthesis has a corresponding closing parenthesis in the correct order.
Example 1:
Input: String s = "{[()]}";
Expected Output: true
Explanation: The parentheses in this string are perfectly balanced. Every opening parenthesis '{', '[', '(' has a corresponding closing parenthesis '}', ']', ')' in the correct order.
 */

import java.util.Stack;

public class BalancedParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        BalancedParentheses bp = new BalancedParentheses();
        String test1 = "{[()]}";
        String test2 = "{[}]";
        String test3 = "(]";
        System.out.println("Test 1: " + bp.isValid(test1));
        System.out.println("Test 2: " + bp.isValid(test2));
        System.out.println("Test 3: " + bp.isValid(test3));
    }

}
