package com.datastructure.array;

/*
Sliding Window Maximum (Maximum of all subarrays of size K)
Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
Output: 10 10 10 15 15 90 90
Explanation: Maximum of first 4 elements is 10, similarly for next 4
elements (i.e from index 1 to 4) is 10, So the sequence  generated is 10 10 10 15 15 90 90
Time Complexity:-    O(n * k)
Space Complexity :-  O(1)

 */
public class MaximumSubArrays {
    static void printKMax(int arr[], int N, int K)
    {
        int j, max;
        for (int i = 0; i <= N - K; i++) {
            max = arr[i];
            for (j = 1; j < K; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int K = 3;
        printKMax(arr, arr.length, K);
    }
}