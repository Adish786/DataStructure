package com.datastructure.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
/*
Queue Functions
You are given an array of integers and another integer 'k'. Your task is to perform the following operations in the given order
Sample Input 1:
5 4
1 9 11 3 2
Sample Output 1:
9
No
9 11 3 2
 */

public class QueueFunctions {
    public static void main(String[] args) {
            Vector<Integer> add = new Vector<>();
            add.add(1);
            add.add(9);
            add.add(11);
            add.add(3);
            add.add(2);
            int k =5;
        System.out.println(solve(add,k));
    }
    public static Queue<Integer> solve(Vector<Integer> v, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : v) {
            queue.offer(num);
        }
        queue.poll();
        if (!queue.isEmpty()) {
            System.out.println(queue.peek());
        }
        if (queue.contains(k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        return queue;
    }
}
