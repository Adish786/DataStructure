package com.datastructure.SessionTest;
/*
You're a renowned mathematician on a quest to unlock the secrets of the Tribonacci sequence. This ancient sequence, unlike its Fibonacci cousin, involves three past terms instead of two. Your mission is to travel through time, unraveling the mysteries of each Tribonacci number.
Given an integer n representing a point in time, calculate the nth Tribonacci number. Remember, T0 = 0, T1 = 1, T2 = 1, and for n >= 0, Tn+3 = Tn + Tn+1 + Tn+2. Conquer larger and larger challenges with n values ranging from 0 to 37. Show off your computational prowess and unveil the hidden patterns within the sequence!
Input:
An integer n representing a point in time (0 <= n <= 37).
Output:
The Tribonacci number Tn corresponding to the chosen point in time. Remember: T0 = 0 T1 = 1 T2 = 1 Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0
Example 1:
Input: n = 4 Output: 4 Explanation: T_3 = 0 + 1 + 1 = 2 T_4 = 1 + 1 + 2 = 4
Example 2:
Input: n = 25 Output: 1389537
Constraints:
n must be an integer between 0 and 37 (inclusive).
The output Tn is guaranteed to fit within a 32-bit integer (maximum value: 2^31 - 1)
 */
public class AlienSequence {
    public static void main(String[] args) {
            int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}
