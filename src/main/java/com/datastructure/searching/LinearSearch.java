package com.datastructure.searching;
/*

Time Complexity: O(n)
Space Complexity: O(1)

 */

public class LinearSearch {
    public int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] myArray = {5, 3, 8, 6, 1};
        int target = 8;
        LinearSearch sol = new LinearSearch();
        int result = sol.linearSearch(myArray, target);
        System.out.println("Element found at index: " + result);
    }
}
