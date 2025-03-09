package com.datastructure.dynamicProgramming;
/*
You and your friend have decided to exchange messages in the form of secret codes. You will be communicating in numbers where number '1' represents 'a', number '2' represents 'b', and so on until the number '26' that represents 'z'. Every message has a difficulty which is represented as the total number of ways your message can be interpreted. For example: 23 can be interpreted as 'bc' as well as 'w' so it has a difficulty of 2. Given an array ar containing ( n ) number of integers, calculate its difficulty.
Input Format:
The first line contains a single integer ( n ) denoting the size of the array.
The second line contains ( n ) space-separated integers.
Output Format:
Return the difficulty of the secret code which would be an integer.
Sample Input 1:
3
1 2 3
Sample Output 1:
3
Explanation 1:
Since there are a total of 3 ways the message can be interpreted which are 'abc', 'lc', and 'aw'. Thus, the difficulty would be 3.
 */
public class SecretCodes {
    public static int solve(int n,int[] ar) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return calculateDifficultyRec(ar, n, 0, memo);
    }
    public static int calculateDifficultyRec(int[] ar, int n, int index, int[] memo) {
        if (index == n) {
            return 1;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int totalWays = 0;
        if (ar[index] > 0) {
            totalWays += calculateDifficultyRec(ar, n, index + 1, memo);
        }
        if (index + 1 < n && (ar[index] == 1 || (ar[index] == 2 && ar[index + 1] <= 6))) {
            totalWays += calculateDifficultyRec(ar, n, index + 2, memo);
        }
        memo[index] = totalWays;
        return totalWays;
    }
    public static void main(String[] args) {
     int[] arr = {1,2,3};
     int n=3;
        System.out.println(solve(n,arr));
    }
}
