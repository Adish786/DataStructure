package com.datastructure.TGP;
import java.util.Stack;
/*
Basic Calculator
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Note:
You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
Example 1:
Input: s = "1 + 1"
Output:
2
Example 2:
Input: s = " 2-1 + 2 "
Output:
 3
Example 3:
Input:
s = "(1+(4+5+2)-3)+(6+8)"</br>
Output:
  23
Constraints:
1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '. s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer
 */

public class BasicCalculator {
    public static int calculate(String s) {
        return evaluateExpression(s.replaceAll("\\s", ""), 0)[0];
    }
    private static int[] evaluateExpression(String s, int index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (ch == '(') {
                int[] result = evaluateExpression(s, index + 1);
                num = result[0];
                index = result[1];
            }
            if (!Character.isDigit(ch) || index == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                }
                sign = ch;
                num = 0;
            }
            if (ch == ')') {
                break;
            }
            index++;
        }
        int result = 0;
        for (int number : stack) {
            result += number;
        }
        return new int[]{result, index};
    }
    public static void main(String[] args) {
        String s = " 2-1 + 2 ";
        System.out.println(calculate(s));
    }
}
