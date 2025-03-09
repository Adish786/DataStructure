package com.datastructure.heap;
import java.util.PriorityQueue;
/*
FACTORS OF K TH LARGEST
You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth largest factor in this list or return -1 if n has less than k factors.
Input Format:
A single line containing two space-separated integers denoting the value of n and k respectively.
Output Format:
The kth largest factor of 'n'.
Example 1
Input:
12 3
Output:
4
 */

public class factorsOfkthLargest {
    public static int solve(int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                minHeap.offer(i);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
                if (i != n / i) {
                    minHeap.offer(n / i);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                }
            }
        }
        if (minHeap.size() < k) {
            return -1;
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
     int n =12;
     int k=3;
        System.out.println(solve(n,k));
    }

}
