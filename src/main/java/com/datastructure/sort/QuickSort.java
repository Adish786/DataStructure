package com.datastructure.sort;
import java.util.Arrays;
/*
Time Complexity
Best Case	       O(n log n)
Average Case	   O(n log n)
Worst Case	       O(n^2)
Space Complexity
Best Case	       O(n log n)
Average Case	   O(n log n)
Worst Case         O(n)
in place    :- not
stable :- not
 */

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
