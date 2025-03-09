package com.datastructure.sort;
/*
Time Complexity
Best Case: O(N)
Average Case: O(N^2)
Worst Case: O(N^2)

stable    yes
inplace   yes
 */

import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]){
        InsertionSort sort = new InsertionSort();
        int[] myArray = {22, 16, 12, 15, 29, 39};
        sort.insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
            // TODO First Ways GURU
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // TODO  Second Ways
    public void insertionSort2(int[] array){
        //int array[] = {10, 20, 25, 63, 96, 57};
        int size = array.length;
        for (int i=1 ;i< size; i++){
            int val = array[i];
            int pos = i;
            while(array[pos-1]>val && pos>0){
                array[pos] = array[pos-1];
                pos = pos-1;
            }
            array[pos] = val;
        }
        for (int i=0 ;i< size; i++){
            System.out.print(" "+array[i]);
        }
    }
}
