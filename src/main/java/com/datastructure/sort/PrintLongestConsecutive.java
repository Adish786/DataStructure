package com.datastructure.sort;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 print the longest consecutive sequence in an unsorted array in Java
Time Complexity: O(N)
Space Complexity: O(N)
Input :- int[] nums = {100, 4, 200, 1, 3, 2, 101, 102, 103, 104};
Output: Longest consecutive sequence: [100, 101, 102, 103, 104]
 */

public class PrintLongestConsecutive {
    public static List<Integer> findLongestConsecutiveSequence(int[] nums) {
        List<Integer> longestSequence = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return longestSequence;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                List<Integer> currentSequence = new ArrayList<>();
                int currentNum = num;
                while (numSet.contains(currentNum)) {
                    currentSequence.add(currentNum);
                    currentNum++;
                }
                if (currentSequence.size() > longestSequence.size()) {
                    longestSequence = currentSequence;
                }
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 101, 102, 103, 104};
        List<Integer> longestSequence = findLongestConsecutiveSequence(nums);
        System.out.println("Longest consecutive sequence: " + longestSequence);
        // Output: Longest consecutive sequence: [100, 101, 102, 103, 104]
    }
}
