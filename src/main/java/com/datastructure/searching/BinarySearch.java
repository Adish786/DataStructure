package com.datastructure.searching;
/*
Time Complexity: O( long n)
Space Complexity: O(1)

 */

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
//TODO Using Recursan
    public static boolean binarySearch1(int[] nums, int target) {
        return binarySearchHelper(nums, target, 0, nums.length - 1);
    }
    private static boolean binarySearchHelper(int[] nums, int target, int low, int high) {
        if (low > high) {
            return false; // Base case: key not found
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return true; // Base case: key found
        } else if (nums[mid] > target) {
            return binarySearchHelper(nums, target, low, mid - 1); // Recursive call on left half
        } else {
            return binarySearchHelper(nums, target, mid + 1, high); // Recursive call on right half
        }
    }
//TODO Using Brout Force Approch
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;  // Target found, return its index
            } else if (array[middle] < target) {
                left = middle + 1;  // Target is on the right half
            } else {
                right = middle - 1;  // Target is on the left half
            }
        }
        return left;  // Target not found
    }
    /*
    public int searchPosition(ArrayList<Integer> array, int target) {
        int left = 0;
        int right = array.size() - 1;
      //  int[] right = new int[array.size()-1];
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array.indexOf(middle) == target) {
                return middle;
            } else if (array.indexOf(middle) < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

     */
    public static void main(String[] args) {
        //TODO Brout Force Approch First One Example
        BinarySearch solution = new BinarySearch();
        int[] myArray = {1, 3, 5, 7, 9};
        int target = 7;
        int result = solution.binarySearch(myArray, target);
        System.out.println("Element found at index: " + result);

        //TODO Second One Example inputs
        int[][] examples = {
                {1, 2, 3, 4, 5},
                {2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15}
                                };
        int[] keys = {4, 5, 15};
        for (int i = 0; i < examples.length; i++) {
            int[] nums = examples[i];
            int target1 = keys[i];
            boolean result1 = binarySearch1(nums, target);
            System.out.println("Example " + (i + 1) + ": " + target1 + " found? " + result1);
        }
    }
}
