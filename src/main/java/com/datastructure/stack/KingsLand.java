package com.datastructure.stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/*
Kings Land
You have been given a land in the form of an array of size n. On each index, there is a king who wants to determine its property. Land at each index has some value. Every king considers every land to its left and right his property until he does not see land of value bigger than his. Note that the value of individual land does not change based on the consideration of kings. You have to print the value of land that each king considers to be his.

Input Format:

The first line contains an integer n (the size of the array).
The second line contains n space-separated integers representing the array landValues.
Output Format:
Print the value of land that each king considers to be his.
Sample Input 1:
5
1 2 3 4 5
Sample Output 1:
1 3 6 10 15
Explanation:
The king on the 0th index sees no land in value less or equal than his and thus considers his total value as 1 whereas the king on the 4th index sees every land below his value and thus gets a total value of 15.
Sample Input 2:
5
4 3 5 1 2
Sample Output 2:
7 3 15 1 3
Explanation:
The king on the 0th index sees the land values 4 and 3, thus considers his total value as 7. The king on the 2nd index sees all lands, thus considers his total value as 15
 */

public class KingsLand {
    public static void kingsLand(ArrayList<Integer> landValues) {
        int n = landValues.size();
        int[] result = new int[n];
        int[] leftLimit = new int[n];
        int[] rightLimit = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && landValues.get(stack.peek()) <= landValues.get(i)) {
                stack.pop();
            }
            leftLimit[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && landValues.get(stack.peek()) <= landValues.get(i)) {
                stack.pop();
            }
            rightLimit[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int totalValue = 0;
            for (int j = leftLimit[i]; j <= rightLimit[i]; j++) {
                totalValue += landValues.get(j);
            }
            result[i] = totalValue;
        }
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        kingsLand(arrayList);
    }
}
