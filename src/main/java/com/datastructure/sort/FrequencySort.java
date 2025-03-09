package com.datastructure.sort;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Sort Array by Increasing Frequency
Input: nums = [4, 4, 6, 2, 2, 2]
ExpectedOutput: [6, 4, 4, 2, 2, 2]
Justification: Here, '6' appears once, '4' appears twice, and '2' appears three times. Thus, numbers are first sorted by frequency and then by value when frequencies tie.
 */

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Step 2: Use merge sort for custom sorting
        mergeSort(nums, 0, nums.length - 1, freqMap);
        return nums;
    }
    // Merge Sort Function
    private void mergeSort(int[] nums, int left, int right, Map<Integer, Integer> freqMap) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, freqMap);
            mergeSort(nums, mid + 1, right, freqMap);
            merge(nums, left, mid, right, freqMap);
        }
    }
    // Merge Function
    private void merge(int[] nums, int left, int mid, int right, Map<Integer, Integer> freqMap) {
        // Temporary arrays to hold the values
        int[] leftArray = Arrays.copyOfRange(nums, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            // Comparing frequencies and values for sorting
            if (freqMap.get(leftArray[i]) < freqMap.get(rightArray[j]) ||
                    (freqMap.get(leftArray[i]).equals(freqMap.get(rightArray[j])) && leftArray[i] > rightArray[j])) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy the remaining elements of leftArray, if any
        while (i < leftArray.length) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }
        // Copy the remaining elements of rightArray, if any
        while (j < rightArray.length) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        FrequencySort solution = new FrequencySort();
        int[] nums1 = {4, 4, 6, 2, 2, 2};
        System.out.println(Arrays.toString(solution.frequencySort(nums1))); // [6, 4, 4, 2, 2, 2]
        int[] nums2 = {0, -1, -1, -1, 5};
        System.out.println(Arrays.toString(solution.frequencySort(nums2))); // [5, 0, -1, -1, -1]
        int[] nums3 = {10, 10, 10, 20, 20, 30};
        System.out.println(Arrays.toString(solution.frequencySort(nums3))); // [30, 20, 20, 10, 10, 10]
    }
}
