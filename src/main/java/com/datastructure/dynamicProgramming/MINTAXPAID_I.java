package com.datastructure.dynamicProgramming;
/*
Given a m x n grid filled with non-negative numbers, A explorer is at top left cell and he has to find a path from top left to bottom right, but there is a condition he has to pay an amount equal to the cell if he choose to include a particular cell in his path, suggest a path which minimizes the money paid by the explorer
Example
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Note: You can only move either down or right at any point in time.
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */
public class MINTAXPAID_I {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(mintaxpaid_I(matrix));
    }

    public static int mintaxpaid_I(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return minPathHelper(matrix, m - 1, n - 1, memo);
    }
    private static int minPathHelper(int[][] grid, int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        int minCostFromAbove = minPathHelper(grid, m - 1, n, memo);
        int minCostFromLeft = minPathHelper(grid, m, n - 1, memo);
        memo[m][n] = grid[m][n] + Math.min(minCostFromAbove, minCostFromLeft);
        return memo[m][n];
    }
}
