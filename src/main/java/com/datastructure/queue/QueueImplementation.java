package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
/*
Sample Input 1:
5
1 3 6 9 8
Sample Output 1:
1 3 6 9 8
 */
public class QueueImplementation {
    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>();
        nums.add(1);
        nums.add(3);
        nums.add(6);
        nums.add(9);
        nums.add(8);
        System.out.println(enqueue(nums));
    }
    private static Queue<Integer> queue = new LinkedList<>();
    public static Queue<Integer> enqueue(Vector<Integer> nums) {
        for (int element : nums) {
            queue.offer(element);
        }
        return queue;
    }
}
