package com.datastructure.sort;
/*
sort an array containing only 0s, 1s, and 2s, we can use the Dutch National Flag algorithm proposed by Edsger Dijkstra.
time complexity :- O(n)
space complexity:- O(1)
input :- int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
output :- 0 0 0 1 1 1 2 2 2
 */

public class Sort012 {
    public static void sortArray(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        sortArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 0 0 0 1 1 1 2 2 2
    }
}
