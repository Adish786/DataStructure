package com.datastructure.stack;
/*
Max Partitions To Make Array Sorted
You are given an integer array arr of length n that represents a permutation of the integers in the range ([0, n - 1]).
We split arr into some number of partitions, and individually sort each partition. After concatenating them, the result should equal the sorted array.
Return the largest number of partitions we can make to sort the array.
Input Format:
The first line contains an integer n denoting the length of the array.
The second line contains n space-separated integers denoting the array arr.
Output Format:
A single integer denoting the largest number of partitions.
Sample Input 1:
5
4 3 2 1 0
Sample Output 1:
1
Explanation:
Splitting into two or more partitions will not return the required result. For example, splitting into ([4, 3], [2, 1, 0]) will result in ([3, 4, 0, 1, 2]), which isn't sorted.
Sample Input 2:
5
1 0 2 3 4
Sample Output 2:
4
Explanation:
We can split into two partitions, such as ([1, 0], [2, 3, 4]). However, splitting into ([1, 0], [2], [3], [4]) is the highest number of partitions possible.
 */
public class MaxPartitionsToMakeArraySorted {
    public static int maxPartition(int n, int[] arr) {
        int maxSeen = 0;
        int partitions = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            if (maxSeen == i) {
                partitions++;
            }
        }
        return partitions;
    }
    public static void main(String[] args) {
        int[] arr = {4 ,3 ,2 ,1 ,0};
        int n = 5;
        System.out.println(maxPartition(n,arr));
    }
}
