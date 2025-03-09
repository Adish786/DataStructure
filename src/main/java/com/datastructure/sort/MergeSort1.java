package com.datastructure.sort;

import java.util.Arrays;

/*
Time Complexity:  consistently in all cases.
Space Complexity:  due to the temporary arrays used during the merge process.
In place :- not
stable :- yes
 */
public class MergeSort1 {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        printArray(arr);
        MergeSort1 ob = new MergeSort1();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array");
        printArray(arr);
        //TODO Example of Recursion
        int[] arr1 = {5, 2, 8, 3, 1, 6};
        System.out.println("Input Array:");
        System.out.println(Arrays.toString(arr1));
        mergeSort(arr);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr1));
    }

    public void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //TODO Recursion Approch

    public static int[] mergeSort(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length - 1);
        return arr;
    }
    public static void mergeSortRecursive(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortRecursive(arr, start, mid); // Recursive call for the left half
            mergeSortRecursive(arr, mid + 1, end); // Recursive call for the right half
            merge1(arr, start, mid, end); // Merge the sorted halves
        }
    }

    public static void merge1(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i)
            left[i] = arr[start + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

}
