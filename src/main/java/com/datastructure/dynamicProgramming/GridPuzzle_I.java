package com.datastructure.dynamicProgramming;
/*
There is a robot on an ( m * n ) grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time. Given the two integers ( m ) and ( n ), return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to ( 2 * 10^9 ).
Input Format:
The first line contains two integers ( m ) and ( n ) denoting the dimensions of the grid.
Output Format:
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
Sample Input 1:
3 2
Sample Output 1:
3
Explanation 1:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
Right -> Down -> Down
Down -> Down -> Right
Down -> Right -> Down
 */
public class GridPuzzle_I {
    public static void main(String[] args) {
            int m =3;
            int n =2;
        System.out.println(gridpuzzle_I(m,n));
    }

    public static int gridpuzzle_I(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return gridpuzzle_I(m - 1, n) + gridpuzzle_I(m, n - 1);
    }
}
