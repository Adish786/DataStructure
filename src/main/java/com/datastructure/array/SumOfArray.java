package com.datastructure.array;

/*
Given a one-dimensional array of integers, create a new array that represents the running sum of the original array
Input: [2, 3, 5, 1, 6]
Expected Output: [2, 5, 10, 11, 17]
Justification:
For i=0: 2
For i=1: 2 + 3 = 5
For i=2: 2 + 3 + 5 = 10
For i=3: 2 + 3 + 5 + 1 = 11
For i=4: 2 + 3 + 5 + 1 + 6 = 17
 */
public class SumOfArray {
    private int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        SumOfArray solution = new SumOfArray();
        int[][] testInputs = {
                {1,2,3,4},
                {3,1,4,2,2},
                {-1,-2,-3,-4,-5}
        };
        for (int[] input : testInputs) {
            int[] output = solution.runningSum(input);
            for (int val : output) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
