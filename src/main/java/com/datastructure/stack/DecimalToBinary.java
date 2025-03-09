package com.datastructure.stack;

import java.util.Stack;

public class DecimalToBinary {
    public String decimalToBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        // Create a StringBuilder to build the binary representation
        StringBuilder sb = new StringBuilder();
        // Convert the decimal number to binary using a stack
        while (num > 0) {
            stack.push(num % 2); // Push the remainder (binary digit) onto the stack
            num /= 2;           // Divide the number by 2 for the next digit
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        DecimalToBinary sol = new DecimalToBinary();
        System.out.println(sol.decimalToBinary(2));   // Output: 10
        System.out.println(sol.decimalToBinary(7));   // Output: 111
        System.out.println(sol.decimalToBinary(18));  // Output: 10010
    }
}
