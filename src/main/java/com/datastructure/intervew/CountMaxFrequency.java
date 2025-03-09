package com.datastructure.intervew;
import java.util.HashMap;
import java.util.Map;
/*
Count Elements With Maximum Frequency
Input: nums = [3, 2, 2, 3, 1, 4]
Output: 4
Explanation: Both 2 and 3 appear twice, which is the highest frequency. So, the total frequency is 2 + 2 = 4.
time complexity:- O(n)
space complexity:- O(m)
 */

public class CountMaxFrequency {
    public int countMaxFrequency(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0;
        int totalFrequencies = 0;
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
            int frequency = frequencies.get(num);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                totalFrequencies = frequency;
            } else if (frequency == maxFrequency) {
                totalFrequencies += frequency;
            }
        }
        return totalFrequencies;
    }
    public static void main(String[] args) {
        CountMaxFrequency solution = new CountMaxFrequency();
        int[] nums1 = {3, 2, 2, 3, 1, 4};
        System.out.println(solution.countMaxFrequency(nums1));  // Output: 4
        int[] nums2 = {5, 5, 5, 2, 2, 3};
        System.out.println(solution.countMaxFrequency(nums2));  // Output: 3
        int[] nums3 = {7, 8, 8, 7, 9, 9};
        System.out.println(solution.countMaxFrequency(nums3));  // Output: 6
    }
}
