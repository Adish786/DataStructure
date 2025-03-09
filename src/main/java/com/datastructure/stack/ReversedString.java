package com.datastructure.stack;
import java.util.Stack;
/*
Given a string, write a function that uses a stack to reverse the string. The function should return the reversed string.
Examples
Example 1:
Input: "Hello, World!"
Output: "!dlroW ,olleH"
 */

public class ReversedString {
    public String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        ReversedString rs = new ReversedString();
        System.out.println(rs.reverseString("Hello, World!")); // Output: "!dlroW ,olleH"
        System.out.println(rs.reverseString("OpenAI")); // Output: "IAnepO"
        System.out.println(rs.reverseString("Stacks are fun!")); // Output: "!nuf era skcatS"
    }
}

