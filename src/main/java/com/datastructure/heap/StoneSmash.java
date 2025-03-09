package com.datastructure.heap;

import java.util.Collections;
import java.util.PriorityQueue;
/*
You have an array called stones containing integer values, where each value represents the weight of a stone.
The objective of the game is to smash stones together until there is at most one stone remaining.
During each turn, you select the two heaviest stones and smash them. If the two stones have the same weight, both are destroyed. Otherwise, the lighter stone is destroyed, and the heavier stone's weight is updated to the difference between their weights.
Your task is to determine the weight of the last remaining stone after all possible smashing operations are completed. If there are no stones remaining, return 0.
Input Format
The first line contains a single integer n, representing the number of elements in the array.
The second line contains n space-separated integers representing the elements of the array.
Output Format
Print a single integer representing the difference between the maximum and minimum element of the array.
Examples:
Input 1:
4
5 10 15 20
Output 1:
0
Explanation:
The two heaviest stones 20 and 15 are smashed, leaving a stone of weight 5. The remaining stones are 10, 5, 5. After further smashing, all stones cancel out, resulting in no remaining stone, so the output is 0.
Input 2:
1
5
Output 2:
5
Explanation:
With only one stone 5, no smashing occurs, so the output is the stone's original weight, which is 5.
Constraints:
1 <= stones.length <= 30
1 <= stones[i] <= 1000
 */
public class StoneSmash {
    public static void main(String[] args) {
        int[] stones = {5, 10, 15, 20};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
