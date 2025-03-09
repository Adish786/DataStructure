package com.datastructure.stack;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack(7);
        stack.push(12);
        stack.push(26);
        stack.push(15);
        stack.push(20);
        stack.pop();
        stack.printStack();
        stack.getHeight();
        stack.getTop();

    }
}
