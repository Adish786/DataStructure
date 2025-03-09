package com.datastructure.stack;
import java.util.Stack;
/*
We are given an integer array asteroids of size N representing asteroids in a row. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed. Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are of the same size, both will explode. Two asteroids moving in the same direction will never meet.
Input Format:
The first line contains an integer N (the size of the array).
The second line contains N space-separated integers representing the array asteroids.
Output Format:
Return the state of the asteroids after all collisions.
Sample Input 1:
3
3 5 -3
Sample Output 1:
3 5
Explanation:
The asteroid 5 and -3 collide resulting in 5. The 5 and 3 never collide.
Sample Input 2:
2
10 -10
Sample Output 2:
[]
Explanation:
The asteroid 10 and -10 collide resulting in both exploding
 */
public class Collisions {
    public static int[] asteroidCollision(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : arr) {
            boolean alive = true;
            while (alive && !stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.pop();
                if (top > -asteroid) {
                    asteroid = top;
                } else if (top == -asteroid) {
                    alive = false;
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, -3};
        int n =3;
        System.out.println(asteroidCollision(n,arr));
    }
}
