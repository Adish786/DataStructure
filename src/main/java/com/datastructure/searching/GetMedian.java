package com.datastructure.searching;
/*
Median of 2 Sorted Arrays
Sample Input 1:
2 1
1 3
2
Sample Output 1:
2
Explanation:
Merged array = [1, 2, 3] and the median is 2.
 */

public class GetMedian {
    public static void main(String[] args) {
            int[] arr1 = {2,1};
            int[] arr2 = {1,3};
        System.out.println(getMedian(arr1,arr2,0,0));
    }
    public static int getMedian(int[] nums1, int[] nums2, int n, int m)  {
        int i = nums1.length;
        int j = nums2.length;
        if (i > j) {
            return getMedian(nums2, nums1,n,m);
        }
        int partitionX, partitionY;
        int low = 0, high = i;
        while (low <= high) {
            partitionX = low + (high - low) / 2;
            partitionY = (i + j + 1) / 2 - partitionX;
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == i) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == j) ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((i + j) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0;
    }
}
