package com.datastructure.sort;

/*
Time Complexity
Best: O(n)
Average: O(n^2)
Worst: O(n^2)
Space Complexity	Worst: O(1)
stable  yes
inplace yes
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,6,5,7,9};
        printArry(arr);
        System.out.println(" Befor Sorting");
        bubbleSort(arr);
        System.out.println("After Sorting");
        printArry(arr);
    }
    private static void printArry(int[] arr){
        for(int ent :arr){
            System.out.print(ent);
        }
    }
    private static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean isSwapped = false;
        for(int i =n-1;n>=0;i--){
            for(int j =0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    isSwapped =true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(isSwapped) break;
        }
        }

        //TODO Third Ways GURU
    public void bubbleSort3(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
