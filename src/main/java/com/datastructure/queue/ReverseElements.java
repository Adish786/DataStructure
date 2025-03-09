package com.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
/*
Reverse elements of queue
You are given a queue and an integer 'k'. Your task is to reverse the order of the first 'k' elements of the queue.
Sample Input 1:
5 3
1 2 3 4 5
Sample Output 1:
3 2 1 4 5
Explanation:
The first 3 elements of the queue [1, 2, 3, 4, 5] are reversed to become [3, 2, 1, 4, 5]
 */

public class ReverseElements {
    public static void main(String[] args) {
        Queue<Integer> queue =new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        int k=5;
        System.out.println(solve(queue,k));
    }
    public static Queue<Integer> solve(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            return queue;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        int remainingElements = queue.size() - k;
        for (int i = 0; i < remainingElements; i++) {
            queue.offer(queue.poll());
        }
        return queue;
    }
}
