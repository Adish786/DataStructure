package com.datastructure.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public void bucketSort(float[] arr) {
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (float elem : arr) {
            int bucketIndex = (int) (n * elem); // Assuming the elements are from 0 to 1
            buckets[bucketIndex].add(elem);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float elem : bucket) {
                arr[index++] = elem;
            }
        }
    }

    public static void main(String[] args) {
        BucketSort solution = new BucketSort();
        float[] myArray = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        solution.bucketSort(myArray);
        System.out.println("Sorted array: ");
        for (float elem : myArray) {
            System.out.print(elem + " ");
        }
    }
}
