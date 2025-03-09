package com.datastructure.array;
/*
SOLO SUM
Ramesh is working on a problem given by his teacher. He is given an array (nums ). He has to find such an array (ans ) such that (ans[i] =leftsum[i] +rightsum[i] ). Help Ramesh to solve the problem.
(leftsum[i] ) is the sum of all the elements to the left of index ( i ) in the array (nums ). If there is no such element, (leftsum[i] = 0 ).
(rightsum[i] ) is the sum of all the elements to the right of index ( i ) in the array (nums ). If there is no such element, (rightsum[i] = 0 ).
Input Format:
The first line contains an integer ( n ), representing the number of elements in the array.
The second line contains ( n ) space-separated integers representing the elements of the array (nums ).
Output Format:
Print the elements of the array (ans ).
Sample Input 1:
5
1 2 3 4 5
Sample Output 1:
14 13 12 11 10
Explanation:
For the first sample input:
(leftsum[0] = 0 ), (rightsum[0] = 14 ) (sum of elements to the right of index 0).
(leftsum[1] = 1 ), (rightsum[1] = 12 ) (sum of elements to the right of index 1).
(leftsum[2] = 3 ), (rightsum[2] = 9 ) (sum of elements to the right of index 2).
(leftsum[3] = 6 ), (rightsum[3] = 5 ) (sum of elements to the right of index 3).
(leftsum[4] = 10 ), (rightsum[4] = 0 ) (no elements to the right of index 4).
Thus, (ans = [14, 13, 12, 11, 10] )

 */
public class SoloSum {
    public static int[] leftRightSum(int[] nums) {
        int[] ans = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
        int totalRightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalRightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            totalRightSum -= nums[i];
            ans[i] = leftSum + totalRightSum;
            leftSum += nums[i];
        }
        if(leftSum>rightSum){
            return ans;
        }
        else {
            return ans;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(leftRightSum(arr));
    }
}
