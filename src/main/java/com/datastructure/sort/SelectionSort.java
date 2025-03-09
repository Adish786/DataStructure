package com.datastructure.sort;

/*
Time Complexity
Best Case    O(N^2)
Average Case O(N^2)
Worst Case   O(N^2)
Space Complexity: O(1)
Stable        No
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr1 = {9,14,3,2,43,11,58,22};
        System.out.println("Before Selection Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();
        selectionSort(arr1);//sorting array using selection sort
        System.out.println("After Selection Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        //TODO second ways
        System.out.print("Original array: ");
        printArray(arr1);
        selectionSort2(arr1);
        System.out.print("Sorted array: ");
        printArray(arr1);
}
        //TODO first ways
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
            //TODO second ways
 public static void selectionSort2(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

   public static void printArray(int[] arr){
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    //TODO Third Ways GURU
    public void selectionSort3(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
