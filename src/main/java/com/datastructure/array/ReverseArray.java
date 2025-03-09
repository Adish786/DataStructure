package com.datastructure.array;
/*
Reverse Array
Given an integer array ( a ) of length ( n ), you want to create an array ( res ) of length ( 2n ) where ( res[i] = a[i] ) and ( res[i + n] = a[n - i - 1] ) for ( 0 <=i < n ) (0-indexed).
Hint: The ( res ) array is the concatenation of ( a ) and the reverse of ( a ).
Input Format:
The first line contains a single integer ( n ), representing the number of elements in the array.
The second line contains ( n ) space-separated integers representing the elements of the array.
Output Format:
Print the elements of the array ( res ).
Sample Input 1:
5
1 2 3 4 5
Sample Output 1:
1 2 3 4 5 5 4 3 2 1
Explanation:
The ( res ) array is formed by concatenating the array ( a ) with its reverse. Thus, ( res = [1, 2, 3, 4, 5, 5, 4, 3, 2, 1] )
 */
public class ReverseArray {
    public static int[] reverseArray(int n, int[] a) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[i] = a[i];
            res[i + n] = a[n - i - 1];
        }
        return res;
    }
    public static void main(String[] args) {
            int[] arr ={1, 2, 3, 4, 5};
            int n =5;
        System.out.println(reverseArray(n,arr));
    }
}
