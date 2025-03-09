package com.datastructure.google;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        if (nextPermutation(arr)) {
            System.out.println("Next permutation: " + Arrays.toString(arr));
        } else {
            System.out.println("No next permutation available.");
        }
    }

    public static boolean nextPermutation(int[] arr) {
        int k = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            reverse(arr, 0, arr.length - 1);
            return false; // No next permutation
        }

        int l = -1;
        for (int i = arr.length - 1; i > k; i--) {
            if (arr[i] > arr[k]) {
                l = i;
                break;
            }
        }

        swap(arr, k, l);
        reverse(arr, k + 1, arr.length - 1);
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
