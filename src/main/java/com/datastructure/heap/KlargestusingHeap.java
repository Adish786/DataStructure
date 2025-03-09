package com.datastructure.heap;

import java.util.PriorityQueue;

/*
Given an array of N positive integers, return the sum of k largest elements from the array using Heap.
Input Format:
First line contains two space separated integers representing the size of array and the number of largest elements from array whose sum needs to be figured out.
The second line contains N space-separated positive integers representing the elements of the array.
Output Format:
Print a single integer representing the sum of the K largest elements in the array.
Example 1
Sample Input:
5 3
3 11 2 4 6
Sample Output:
21
Explanation :
Since we have to find the sum of k largest which in this case is 3 and the elements are 11,6,4 whose sum is equal to 21, thus the output is 21.

 */
public class KlargestusingHeap {
    public static void main(String[] args) {
        int[] arr = {3, 11, 2, 4, 6};
        int n=5;
        int k=3;
        System.out.println(kSum(arr,n,k));
    }

  public static int kSum(int[] v, int N, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : v) {
            if (minHeap.size() < K) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        return sum;
    }
}
