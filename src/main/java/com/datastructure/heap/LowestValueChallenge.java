package com.datastructure.heap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
/*
Lowest Value Challenge
You are given a 0-indexed integer array arr of even length, and there is also an initially empty array ans. Alice and Bob are playing a game with the following rules:
In each round, Alice and Bob each make one move.
First, Alice removes the minimum element from arr.
Then, Bob removes the minimum element from the remaining arr.
Next, Bob appends the element he removed to ans.
After that, Alice appends the element she removed to ans.
The game continues in this manner until arr is empty. Return the resulting array ans after the game ends.
Example 1:
nums = [6,1,9,2,8,3]
Output:
[2,1,6,3,9,8]
Explanation:
- In the first round, Alice removes 1 and then Bob removes 2. Bob appends 2 to ans, followed by Alice appending 1. So, ans = [2,1].
- At the beginning of the second round, arr = [6,9,8,3]. Alice removes 3 and then Bob removes 6. Bob appends 6 to ans, followed by Alice appending 3. So, ans = [2,1,6,3].
- In the final round, arr = [9,8]. Alice removes 8 and then Bob removes 9. Bob appends 9 to ans, followed by Alice appending 8. So, ans = [2,1,6,3,9,8].
Thus, the resulting array ans is [2,1,6,3,9,8].
 */

public class LowestValueChallenge {
    public static int[] lowestValueChallenge(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }
        List<Integer> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int aliceRemove = minHeap.poll();
            int bobRemove = !minHeap.isEmpty() ? minHeap.poll() : aliceRemove;
            ans.add(bobRemove);
            ans.add(aliceRemove);
        }
        int[] resultArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            resultArray[i] = ans.get(i);
        }
        return resultArray;
    }
    public static void main(String[] args) {
        int[] arr ={6,1,9,2,8,3};
        System.out.println(Arrays.toString(lowestValueChallenge(arr)));

    }
}
