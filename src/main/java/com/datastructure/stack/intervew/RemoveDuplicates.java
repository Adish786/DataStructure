package com.datastructure.stack.intervew;


import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
    public String removeStars(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c:str.toCharArray()){
            if(c=='*' && !stack.isEmpty()){
                stack.pop();
            }else if (c != '*') {
                    stack.push(c);
            }
        }
        StringBuilder result= new StringBuilder();
        while (!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        System.out.println(sol.removeDuplicates("abbaca"));  // Output: "ca"
        System.out.println(sol.removeDuplicates("azxxzy"));  // Output: "ay"
        System.out.println(sol.removeDuplicates("abba"));    // Output: ""
    }


}
