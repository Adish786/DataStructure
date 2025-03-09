package com.datastructure.TGP;
/*
Power of 2
Tuntun is very lazy and she has got an assignment to check whether a given integer *n is power of two or not. She is not good in coding so please help her to do this.
An integer n is a power of two, if there exists an integer x such that n == 2^x. If the entered number is power of 2 then return true otherwise return false
Input Format:
first and only line contains an integer n.
Output Format:
Print true if it is power of 2 otherwise print false (in lowercase).
Example:
Input:
3
Output:
false
 */

public class PowerOf2 {
    public static void main(String[] args) {
        int n =3;
        System.out.println(solve(n));
    }
    public static boolean solve(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
