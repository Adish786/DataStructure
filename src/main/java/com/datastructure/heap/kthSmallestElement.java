package com.datastructure.heap;
import java.util.*;
/*
kth smallest element
Given an input stream arr of n integers. Find the Kth smallest element for each element in the stream and if the Kth smallest element doesn't exist, then print -1.
Example 1
Input:
n = 6, k = 4, arr = [1,2,3,4,5,6]
Output:
[-1,-1,-1,4,4,4]
 */

public class kthSmallestElement {
    public static int[] kthSmallest(int k, int[] arr, int n) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            maxHeap.offer(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            if (maxHeap.size() < k) {
                result.add(-1);
            } else {
                result.add(maxHeap.peek());
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
    public static void main(String[] args) {
        int k=4;
        int[] arr={1,2,3,4,5,6};
        int n=6;
        System.out.println(Arrays.toString(kthSmallest(k, arr, n)));
    }
}
