package com.datastructure.stack;

/*
Tunnel
There is a tunnel which is under construction. Workers go inside in a sequence and come out in reverse sequence, i.e., the person going in last will come out first.
You have been given two sequences, IN and OUT. If any worker does not obey the sequence, other workers will be trapped. Determine if all the workers came out safely.
Sample Input 1:
5
1 2 3 4 5
5 4 3 2 1
Sample Output 1:
1
Explanation:
The workers go inside the tunnel in the sequence [1, 2, 3, 4, 5] and come out in the reverse sequence [5, 4, 3, 2, 1]. Since the sequence is obeyed, all workers come out safely.
 */

import java.util.Stack;
import java.util.Vector;

public class Tunnel {
   public static boolean calculateTotalTrappedWorkers(Vector<Integer> in, Vector<Integer> out) {
        int j=0;
        Stack<Integer> stack = new Stack<>();
        for(Integer i :in){
            stack.push(i);
        }
        while (!stack.isEmpty() && stack.peek() == out.get(0)) {
            stack.pop();
            j++;
        }
        return true;
    }
    //TODO Second ways
   public static boolean calculateTotalTrappedWorkers1(Vector<Integer> in, Vector<Integer> out) {
        int j = 0;  // Pointer for the out vector
        Stack<Integer> stack = new Stack<>();

        for (Integer i : in) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == out.get(j)) {
                stack.pop();
                j++;
            }
        }
        return j == out.size();
    }
    public static void main(String[] args) {
        Vector<Integer> in = new Vector<>();
        in.add(1);
        in.add(1);
        in.add(2);
        in.add(3);
        in.add(4);
        in.add(5);
        Vector<Integer> out = new Vector<>();
        out.add(1);
        out.add(1);
        out.add(2);
        out.add(3);
        out.add(4);
        out.add(5);
        System.out.println(calculateTotalTrappedWorkers(in,out));
    }
}
