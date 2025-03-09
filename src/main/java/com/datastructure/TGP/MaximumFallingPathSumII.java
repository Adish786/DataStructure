package com.datastructure.TGP;
/*
Given an n×n integer matrix grid, find the maximum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of the grid such that no two elements chosen in adjacent rows are in the same column.
Example:
Input:
3
grid = [[1,2,3],
    [4,5,6],
    [7,8,9]
]
Output:
17
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the largest sum is [3,5,9], so the answer is 17
 */
public class MaximumFallingPathSumII {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(maxFallingPathSum(arr));
    }

    public static int maxFallingPathSum(int[][] grid) {
        int n = grid.length;
        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, findMaxPath(grid, 0, j));
        }
        return maxSum;
    }
    private static int findMaxPath(int[][] grid, int i, int j) {
        int n = grid.length;
        if (i >= n || j >= n || j < 0) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1) {
            return grid[i][j];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            if (k != j) {
                maxSum = Math.max(maxSum, findMaxPath(grid, i + 1, k));
            }
        }
        return grid[i][j] + maxSum;
    }
}
