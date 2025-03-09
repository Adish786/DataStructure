package com.datastructure.sort;


import java.util.ArrayList;

public class MergeSort2 {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        mergeSort(arr, 0, arr.size() - 1);
        return arr;
    }
    public static void mergeSort(ArrayList<Integer> arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid); // Recursive call for the left half
            mergeSort(arr, mid + 1, end); // Recursive call for the right half
            merge(arr, start, mid, end); // Merge the sorted halves
        }
    }
    public static void merge(ArrayList<Integer> arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; ++i)
            left[i] = arr.get(start + i);
        for (int j = 0; j < n2; ++j)
            right[j] = arr.get(mid + 1 + j);
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr.set(k, left[i]);
                i++;
            } else {
                arr.set(k, right[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, left[i]);
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, right[j]);
            j++;
            k++;
        }

    }

}
