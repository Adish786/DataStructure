package com.datastructure.searching;

public class MaximumCount {
    public int maximumCount(int[] nums) {
        int start = 0, end = nums.length - 1;
        int maxNegatives = 0, maxPositives = 0;
        // First pass to find the count of negative numbers
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < 0) {
                maxNegatives = mid + 1; // Update count of negatives
                start = mid + 1; // Move to the right
            } else {
                end = mid - 1; // Continue searching in the left half
            }
        }
        start = 0;
        end = nums.length - 1;
        // Second pass to find the count of positive numbers
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > 0) {
                maxPositives = nums.length - mid; // Update count of positives
                end = mid - 1; // Continue searching in the left half
            } else {
                start = mid + 1; // Move to the right
            }
        }
        return Math.max(maxNegatives, maxPositives);
    }
    public static void main(String[] args) {
        MaximumCount solution = new MaximumCount();
        int[] nums1 = {-4, -3, -1, 0, 1, 3, 5, 7};
        System.out.println("Example 1: " + solution.maximumCount(nums1)); // Expected Output: 4
        int[] nums2 = {-8, -7, -5, -4, 0, 0, 0};
        System.out.println("Example 2: " + solution.maximumCount(nums2)); // Expected Output: 4
        int[] nums3 = {0, 2, 2, 3, 3, 3, 4};
        System.out.println("Example 3: " + solution.maximumCount(nums3)); // Expected Output: 6
    }
}
