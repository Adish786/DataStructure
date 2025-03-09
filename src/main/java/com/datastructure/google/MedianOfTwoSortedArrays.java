package com.datastructure.google;
/*
Median of two sorted arrays
given two soted arrays nums1 and nums2 of size m and n respectively the median of the two
sorted arrays the overall run time complexity should be O(log (m+n)).
input nums1 = [1,3], nums2 = [2]
output :- 2.000000
explanation :- merged array = [1,2,3] and median is 2 .
input nums1 = [1,2], nums2 = [3,4]
output :- 2.50000
explanation :- merged array = [1,2,3,4] and median is (2+3) = 2.5

 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));  // Output: 2.00000
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1_2, nums2_2));  // Output: 2.50000
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        while (left <= right) {
            int partition1 = left + (right - left) / 2;  // Partition index for nums1
            int partition2 = (m + n + 1) / 2 - partition1;  // Partition index for nums2
            // Get the max and min values around the partition
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is odd
                if ((m + n) % 2 != 0) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                // If total length is even
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            }
            // Adjust binary search window
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

}
