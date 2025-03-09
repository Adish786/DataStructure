package com.datastructure.sort;
/*

Best Case    O(n*logn)
Average Case O(n*logn)
Worst Case   O(n*logn)
In place :- not
stable :- yes
*/

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {3, 9, 10, 1, 8, 7, 5, 2};
        mergeSort(array);
        for (int element: array) {
            System.out.print(element + " ");
        }
    }
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];
        System.arraycopy(array, 0, leftArray, 0, mid);
        if (array.length - mid >= 0)
            System.arraycopy(array, mid, rightArray, 0, array.length - mid);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }



    void merge(int arr[], int l, int m, int r) {
        // Calculate the sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temporary arrays back into arr[l..r]

        // Initial indexes of the first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
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

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Main function that sorts arr[l..r] using merge()
     */
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point to divide the array into two halves
            int m = (l + r) / 2;

            // Recursively sort the first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
