package com.datastructure.TGP;
/*
Board Filling
You have given a rectangular board of squares. You also have unlimited number of standard block pieces of  2 x1 squares. You are allowed to rotate the pieces. You are asked to place as many blocks as possible on the board so as to meet the following conditions:
Each block completely covers two squares.
No two blocks overlap.
Each block lies entirely inside the board. It is allowed to touch the edges of the board.
Find the maximum number of blocks, which can be placed under these restrictions.
Input
In a single line you are given two integers M and N — board sizes in squares. Output
Output one number — the maximal number of block of wood, which can be placed.
Sample Input
2 4
Sample Output
4
Explanation
We are given the board of size 2x4 which is given as:
----
----
We can place two blocks which are placed horizontally, in each row making a total of 4 in this way:
==
==
 */
public class BoardFilling {
    public static int boardFill(int n, int m) {
        int maxBlocks = (m * n) / 2;
        return maxBlocks;
    }

    public static void main(String[] args) {
int n=2;
int m=4;
        System.out.println(boardFill(n,m));
    }
}
