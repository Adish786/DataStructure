package com.datastructure.intervew;
/*
Matrix Diagonal Sum
Given a square matrix (2D array), calculate the sum of its two diagonals.
Input:[[1,2,3],
      [4,5,6],
      [7,8,9]]
Expected Output: 25
Justification: Summing up the two diagonals (1+5+9+3+7), we get 25.
Please note that the element at [1][1] = 5 is counted only once.

 */

public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;  // Get the size of the matrix
        int totalSum = 0;  // Initialize the total sum
        for (int i = 0; i < n; i++) {
            totalSum += mat[i][i] + mat[i][n-i-1];  // Add primary and secondary diagonal elements
        }
        if (n % 2 != 0) {
            totalSum -= mat[n/2][n/2];
        }
        return totalSum;  // Return the calculated total sum
    }
    public static void main(String[] args) {
        DiagonalSum sol = new DiagonalSum();
        System.out.println(sol.diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));  // Output: 25
        System.out.println(sol.diagonalSum(new int[][]{{1,0},{0,1}}));  // Output: 2
        System.out.println(sol.diagonalSum(new int[][]{{5}}));  // Output: 5
    }
}
