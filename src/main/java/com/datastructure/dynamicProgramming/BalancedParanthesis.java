package com.datastructure.dynamicProgramming;
/*
Given a number n representing a pair of parentheses (closed and open), your task is to print the total number of balanced parenthesis pairs possible. A balanced parenthesis refers to the proper nesting and matching of open and close parentheses in an expression. An expression is considered balanced if every opening parenthesis has a corresponding closing parenthesis.
For Example:
Balanced: (), ((())), ()()(), (())()
Unbalanced: (, ((), )()(, (((
Input Format:
The first line contains the integer n denoting the number of pairs of parentheses.
Output Format:
A single integer denoting the total number of balanced parenthesis pairs possible.
Sample Input 1:
3
Sample Output 1:
5
Explanation:
The possible balanced parenthesis pairs are: ((())), ()()(), (())(), ()((), (()())
 */
public class BalancedParanthesis {
   // static int cnt=0;
 public static int printParenthesis(int n) {
        if (n == 0) {
            return 1;
        }
          int result = 0;
        for (int i = 0; i < n; i++) {
            result += printParenthesis(i) * printParenthesis(n - 1 - i);
        }
        return result;
    }
    public static void main(String[] args) {
        int n =3;
        System.out.println(printParenthesis(n));
    }
}
