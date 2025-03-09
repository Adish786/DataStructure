package com.datastructure.array;
import java.util.*;
/*
Find the XOR Connects
You have been given two arrays ( A ) and ( B ) of sizes ( n ) and ( m ) respectively. You need to return the total connects in the arrays. A connect is defined as the XOR of two elements from different arrays which results in 0.

Input Format

The first line contains two integers ( n ) and ( m ), representing the sizes of arrays ( A ) and ( B ) respectively.
The second line contains ( n ) space-separated integers representing the elements of array ( A ).
The third line contains ( m ) space-separated integers representing the elements of array ( B ).
Output Format
Print the total number of connects.
Sample Input 1
5 5
1 2 3 4 5
1 2 3 4 5
Sample Output 1
5
Sample Input 2
5 1
1 2 3 4 5
7
Sample Output 2
0
 */

public class FindTheXORConnects {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Set<Integer> setA = new HashSet<>();
        for (int a : A) {
            setA.add(a);
        }
        int count = 0;
        for (int b : B) {
            if (setA.contains(b)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(solve(A,B));
    }
}
