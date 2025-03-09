package com.datastructure.stack;

import java.util.Stack;

public class ParenthesesBalancer {



    public static boolean isBalanced(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String expression1 = "{[()]}";  // Balanced
        String expression2 = "{[(])}";  // Not Balanced
        String expression3 = "((()))";  // Balanced
        String expression4 = "{[(";     // Not Balanced
        System.out.println("Expression 1 is balanced: " + isBalanced(expression1)); // true
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2)); // false
        System.out.println("Expression 3 is balanced: " + isBalanced(expression3)); // true
        System.out.println("Expression 4 is balanced: " + isBalanced(expression4)); // false
    }
}
