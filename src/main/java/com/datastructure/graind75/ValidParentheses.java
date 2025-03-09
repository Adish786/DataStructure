package com.datastructure.graind75;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char top = s.charAt(i);
            if(top=='('|| top=='['||top=='{')
                stack.push(top);
            else if(top==')'||top==']'||top=='}')
            {
               if(stack.isEmpty())
                   return false;
               char ch = stack.pop();
                if(!isMatched(ch,top))
                    return false;
            }
        }
        return (stack.isEmpty());
    }
    private static boolean isMatched(char a, char b) {
        return ((a=='{'&& b=='}') || (a=='(' && b==')') || (a=='[' && b==']'));
    }
}














