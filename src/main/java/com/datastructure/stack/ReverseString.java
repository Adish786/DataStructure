package com.datastructure.stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Adish Ansari";
        System.out.println(reverseString(str));
    }
    public static String reverseString(String string) {
        java.util.Stack<Character> stack = new Stack<>();
        String reversedString = "";

        for (char c : string.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }
        return reversedString;
    }
}
