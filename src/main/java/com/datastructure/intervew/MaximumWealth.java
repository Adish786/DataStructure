package com.datastructure.intervew;
/*
Richest Customer Wealth
Input: [[5,2,3],[0,6,7]]
Expected Output: 13
Justification: The total wealth of the first customer is 10 and of the second customer is 13.
So, the output is 13 as it's the maximum among all customers.
 */
public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;  // Initialize maxWealth to 0
        // Loop through each customer's accounts
        for (int[] customer : accounts) {
            int wealth = 0;  // Variable to store the wealth of the current customer
            // Loop through each account of the current customer and sum them up
            for (int account : customer) {
                wealth += account;
            }
            // Update maxWealth if the current customer's wealth is greater
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
    public static void main(String[] args) {
        MaximumWealth sol = new MaximumWealth();
        System.out.println(sol.maximumWealth(new int[][]{{5,2,3},{0,6,7}}));  // 13
        System.out.println(sol.maximumWealth(new int[][]{{1,2},{3,4},{5,6}}));  // 11
        System.out.println(sol.maximumWealth(new int[][]{{10,100},{200,20},{30,300}}));  // 330
    }
}
