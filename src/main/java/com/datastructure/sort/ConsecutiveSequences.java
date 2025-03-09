package com.datastructure.sort;

import java.util.ArrayList;
import java.util.List;
/*
 print all consecutive sequences in an unsorted array in Java,
 Time complexity :- O(n)
 Space complexity :- O(1)
 input :- int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
 Output :- [1, 2, 3, 4, 5]
           [7, 8, 9]
*/

public class ConsecutiveSequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
        List<List<Integer>> sequences = findConsecutiveSequences(arr);
        for (List<Integer> sequence : sequences) {
            System.out.println(sequence);
        }
    }
    public static List<List<Integer>> findConsecutiveSequences(int[] arr) {
        List<List<Integer>> sequences = new ArrayList<>();
        if (arr.length == 0) {
            return sequences;
        }
        List<Integer> currentSequence = new ArrayList<>();
        currentSequence.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                currentSequence.add(arr[i]);
            } else {
                if (currentSequence.size() > 1) {
                    sequences.add(new ArrayList<>(currentSequence));
                }
                currentSequence.clear();
                currentSequence.add(arr[i]);
            }
        }
        if (currentSequence.size() > 1) {
            sequences.add(currentSequence);
        }
        return sequences;
    }
}
