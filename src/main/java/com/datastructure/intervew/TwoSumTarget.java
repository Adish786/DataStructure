package com.datastructure.intervew;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
target = 9
2 + x = target
2 + 7 = 9
x = target - 2
x = target - ar[i]
 */
public class TwoSumTarget {
    public static int[] twoSum(int[] n, int target) {
        for(int i =0,j=n.length-1;i<j;){
            if(n[i]+n[j]==target){
                return new int[]{i+1,j+1};
            }
            else if (n[i]+n[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[] {0,0};
    }
    /*
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

     */

    /*
    public static int[] twoSum(int[] nums, int target) {
        // Create an array to store original indices and values
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i]; // value
            indexedNums[i][1] = i;       // original index
        }
        // Sort the array based on the values
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));
        // Initialize two pointers
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = indexedNums[left][0] + indexedNums[right][0];

            if (sum == target) {
                // Return the original indices of the two numbers
                return new int[]{indexedNums[left][1], indexedNums[right][1]};
            } else if (sum < target) {
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }
        // If no solution is found (should not happen due to constraints)
        throw new IllegalArgumentException("No solution found");
    }

     */
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // Output: [0, 1]
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // Output: [1, 2]
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); // Output: [0, 1]
    }


}
