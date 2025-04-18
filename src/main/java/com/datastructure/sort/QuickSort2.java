package com.datastructure.sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {3,7,2,1,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] array,int firstIndex,int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex-1);
            quickSortHelper(array, pivotIndex+1, right);
        }
    }
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length-1);
    }


}








