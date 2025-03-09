package com.datastructure.google;
/*
Search a 2D Matrix
you are given an m x n integer matrix matrix with the following two properties;
1:- Each row is sorted in non-descreasing order
2:- the first integer of each row is greater than the last integer of the previous row
given an integer target, return true if target is in matrix or false otherwise
you must write a solution in O(log(m*n)) time complexity
input matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]] , target =3
output :- true
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));  // Output: true
        target = 13;
        System.out.println(searchMatrix(matrix, target));  // Output: false
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // Perform binary search
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];  // Convert mid index to 2D matrix indices
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
