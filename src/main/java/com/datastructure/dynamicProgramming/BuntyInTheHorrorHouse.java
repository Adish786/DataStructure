package com.datastructure.dynamicProgramming;
/*
Bunty in the horror house
Bunty is stuck in a horror house that consists of an (N * N) maze with Bunty starting at room ([0][0]). Find the total number of paths that Bunty can follow to reach the exit, i.e., room ([N-1][N-1]).
He can move in any direction (left, right, up, and down). The value of every room in the maze can either be 0 or 1. Rooms with value 0 are blocked and cannot be accessed, while rooms with value 1 are open.
Input Format:
The first line of input contains an integer N representing the dimension of the maze.
The next N lines of input contain N space-separated integers representing the type of the cell.
Output Format:
For each test case, print the total number of paths possible from start to exit.
Sample Input 1:
3
1 0 1
1 0 1
1 1 1
Sample Output 1:
1
Explanation: Only 1 path is possible which is:
1 0 0
1 0 0
1 1 1
(1 representing the path he took) which is printed from left to right and then top to bottom in one line
 */
public class BuntyInTheHorrorHouse {
    private static int sum = 0;
    public static void escape(int n, int[][] arr) {
        int N = arr.length;
        boolean[][] visited = new boolean[N][N]; // To keep track of visited cells
        countPaths(arr, 0, 0, visited);
        System.out.println(sum);
    }
    private static void countPaths(int[][] maze, int x, int y, boolean[][] visited) {
        int N = maze.length;
        if (x == N - 1 && y == N - 1) {
            sum += 1;
            return;
        }
        if (x < 0 || x >= N || y < 0 || y >= N || maze[x][y] == 0 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        countPaths(maze, x, y + 1, visited);
        countPaths(maze, x + 1, y, visited);
        countPaths(maze, x, y - 1, visited);
        countPaths(maze, x - 1, y, visited);
        visited[x][y] = false;
    }
    public static void main(String[] args) {
        int n =3;
        int[][] arr = { {1,0,1}, {1,0,1}, {1,1,1} };
        escape(n,arr);
    }
}
