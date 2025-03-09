package com.datastructure.sort;

public class InsertionSort1 {
   /*
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }
*/
 public static void sort(int a[])
   {
       int n = a.length;
       for (int i = 1; i < n; ++i) {
           int k = a[i];
           int j = i - 1;
           while (j >= 0 && a[j] > k) {
               a[j + 1] = a[j];
               j = j - 1;
           }
           a[j + 1] = k;
       }
   }
    public static void main(String a[]){
        int[] arr1 = {9,14,3,2,43,11,58,22};
        System.out.println("Before Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();

       // insertionSort(arr1);//sorting array using insertion sort
        sort(arr1);
        System.out.println("After Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
    }
}
