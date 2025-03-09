package com.datastructure.TGP;
/*
Number Game
Bholu and Dholu play a game. Initially each player receives one fixed positive integer that doesn't change throughout the game. Bholu receives number a and Dholu receives number b. They also have a heap of n stones. The players take turns to make a move and Bholu starts. During a move a player should take from the heap the number of stones equal to the greatest common divisor of the fixed number he has received and the number of stones left in the heap. A player loses when he cannot take the required number of stones (i. e. the heap has strictly less stones left than one needs to take).
Your task is to determine who wins the game.
Input
The only string contains space-separated integers a, b and n (1100) — the fixed numbers Bholu and Dholu have received correspondingly and the initial number of stones in the pile.
Output
If Bholu wins, print "0" (without the quotes), otherwise print "1" (without the quotes).
Sample Input
3 5 9
Sample Output
0
Explanation
The greatest common divisor of two non-negative integers a and b is such maximum positive integer k, that a is divisible by k without remainder and similarly, b is divisible by k without remainder. Let gcd(a, b) represent the operation of calculating the greatest common divisor of numbers a and b. Specifically, gcd(x, 0) = gcd(0, x) = x.
In the first sample the game will go like that:

 */

public class NumberGame {
    public static  int solve(long a, long b, long n) {
        while (true) {
            long gcdBholu = gcd(a, n);
            if (gcdBholu > n) {
                return 1;
            }
            n -= gcdBholu;
            long gcdDholu = gcd(b, n);
            if (gcdDholu > n) {
                return 0;
            }
            n -= gcdDholu;
        }
    }
    private static long gcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
        /*
        if(y==0){
            return y;
        }
     return gcd(y,x % y);
         */
    }

    public static void main(String[] args) {
        long a=9;
        long b=5;
        long n=3;
        System.out.println(solve(a,b,n));
    }
}
