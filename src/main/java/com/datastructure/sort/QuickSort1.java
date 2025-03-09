package com.datastructure.sort;

import java.util.Arrays;
/*
Time Complexity: O(n^2)
Space Complexity:  O(n log n)
in place    :- not
stable :- not
 */

public class QuickSort1 {
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element
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
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args) {
        QuickSort1 solution = new QuickSort1();
        int[] myArray = {10, 80, 30, 90, 40, 50, 70};
        solution.quickSort(myArray, 0, myArray.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(myArray));
    }
}
