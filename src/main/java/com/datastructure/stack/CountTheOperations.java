package com.datastructure.stack;
import java.util.Stack;
/*
Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of operations required to convert the string into a balanced expression.
A single operation means changing '{' to '}' or vice-versa.
Return the minimum number of reversals required to balance the bracket sequence. If balancing is not possible, return -1
Sample Input 1:
}{{}}{{{
Sample Output 1:
3
Explanation:
One way to balance is: "{{{}}{}}". There is no balanced sequence that can be formed in fewer reversals.

 */

public class CountTheOperations {

    public static int countop(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        int red_len = stack.size();
        int n = 0;
        while (!stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
            n++;
        }
        return (red_len / 2 + n % 2);

    }

    public static void main(String[] args) {
            String str = "}{{}}{{{";
        System.out.println(countop(str));
    }
}
