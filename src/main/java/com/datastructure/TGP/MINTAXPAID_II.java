package com.datastructure.TGP;
/*
Given a n x n grid filled with non-negative numbers, A explorer is at top left cell and he has to find a path from top left to bottom right, but there is a condition he has to pay an amount equal to the cell if he choose to include a particular cell in his path, suggest a falling path which minimizes the money paid by the explorer. The explorer can move down, right or diagonally down.
Example
Input:
3 3
1 2 3
4 5 6
7 8 9
Output:
15
Explanation:
The explorer will start from matrix[0][0] that is from 1 then move to 5 then finally to 9 which is at matrix[n-1][n-1]. The total cost is 16 which is the minimum possible achievable
 */
public class MINTAXPAID_II {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int m =3;
        int k =3;
        System.out.println(solve(arr,m,k));
    }
    public static int solve(int[][] ar, int m, int n) {
        int j = ar.length;
        return findMinPath(ar, 0, 0, j);
    }

    private static int findMinPath(int[][] matrix, int i, int j, int n) {
        if (i >= n || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1 && j == n - 1) {
            return matrix[i][j];
        }
        int moveRight = findMinPath(matrix, i, j + 1, n);
        int moveDown = findMinPath(matrix, i + 1, j, n);
        int moveDiagonal = findMinPath(matrix, i + 1, j + 1, n);
        return matrix[i][j] + Math.min(moveRight, Math.min(moveDown, moveDiagonal));
    }
}
