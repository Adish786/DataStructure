package com.datastructure.heap;

import java.util.PriorityQueue;
/*
Jumble for Treasure
You are on an adventure to find the lost treasure. You come across a cave and decide to enter in, inside you find an old tablet upon which some single digit numbers are written. When u dig you find a chest on which it is written that whoever can use all the numbers on the tablet to form two numbers whose sum is the minimum shall be able to open this chest. Your task is to find the code to open the chest.
Sample Input:
6
1 3 5 9 2 4
Sample output:
384
Explanation:
The two possible numbers that can be formed are 135 and 249 whose sum turns out to be minimum which is 384.
 */

public class JumbleforTreasure {
    public static String solve(int[] arr, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int digit : arr) {
            minHeap.offer(digit);
        }
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        boolean addToFirst = true;
        while (!minHeap.isEmpty()) {
            if (addToFirst) {
                num1.append(minHeap.poll());
            } else {
                num2.append(minHeap.poll());
            }
            addToFirst = !addToFirst;
        }
        int number1 = num1.length() > 0 ? Integer.parseInt(num1.toString()) : 0;
        int number2 = num2.length() > 0 ? Integer.parseInt(num2.toString()) : 0;
        return String.valueOf(number1 + number2);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 9, 2, 4};
        int n = 6;
        System.out.println(solve(arr, n));
    }
}
