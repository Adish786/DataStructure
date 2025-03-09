package com.datastructure.dynamicProgramming;
/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time. An obstacle and space are marked as 1 or 0 respectively in the grid. A path that the robot takes cannot include any square that is an obstacle. Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
Example
Input : obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
public class GridPuzzleII {
    public static void main(String[] args) {
            int[][] arr = { {0,0,0}, {0,1,0}, {0,0,0} };
            int m=0;
            int n=0;
        System.out.println(gridPuzzleII(n,m,arr));
    }


    public static int gridPuzzleII(int n, int m, int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] memo = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                memo[i][j] = -1;
            }
        }
        return uniquePathsHelper(obstacleGrid, x - 1, y - 1, memo);
    }
    private static int uniquePathsHelper(int[][] grid, int m, int n, int[][] memo) {
        if (m < 0 || n < 0 || grid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        int pathsFromAbove = uniquePathsHelper(grid, m - 1, n, memo);
        int pathsFromLeft = uniquePathsHelper(grid, m, n - 1, memo);
        memo[m][n] = pathsFromAbove + pathsFromLeft;
        return memo[m][n];
    }
}
