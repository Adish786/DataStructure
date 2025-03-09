package com.datastructure.heap;
import java.util.PriorityQueue;
/*
Kth Largest Element
You have an array of strings arr where each string represents an integer without leading zeros. Given an integer k, find the string that represents the kth largest integer in the array.
Remember that duplicates are counted separately. For example, if arr is ["1", "3", "5"], the first largest integer is "5", the second largest is also "3", and the third largest is "1". Return the string for the kth largest integer.
Example 1:
Input:
arr = ["1", "2", "3"], k = 2
Output:
2
Explanation:
1st largest is "3", 2nd largest is "2". Return "2".
Example 2:
Input:
arr = ["12","2","21","1"], k = 3
Output:
2
Explanation:
The numbers in arr sorted in non-decreasing order are ["1","2","12","21"].
The 3rd largest integer in nums is "2".
 */

public class KthLargestElement {
    public static String kthLargestElement(String[] arr, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return Integer.compare(a.length(), b.length());
            }
        });
        for (String num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        String[] arr ={"1", "2", "3"};
        int k =2;
        System.out.println(kthLargestElement(arr,k));
    }
}
