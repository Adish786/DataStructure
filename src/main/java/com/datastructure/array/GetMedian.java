package com.datastructure.array;

/*
Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of sizes m and n respectively, return the median of the two sorted arrays. You have to return an integer kind of value.
The overall run time complexity should be O(log (m+n)).
Example:
Input:
nums1 = [1,3], nums2 = [2]
Output:
2
Explanation:
Merged array = [1,2,3] and the median is 2.
 */
public class GetMedian {
    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        int n =0;
        int m=0;
        System.out.println(getMedian(arr1,arr2,n,m));
    }

    public static int getMedian(int[] nums1, int[] nums2, int n, int m) {
        if (nums1.length > nums2.length) {
            return getMedian(nums2, nums1, n, m);
        }
        int imin = 0, imax = m, mid = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = mid - i;
            if (i < m && nums1[i] < nums2[j - 1]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                // i is perfect
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
