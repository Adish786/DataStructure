package com.datastructure.matrix;
/*
You are given an m x n matrix accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank
Return the wealth that the richest customer has.
Imagine every customer has multiple bank accounts, with each account holding a certain amount of money. The total wealth of a customer is calculated by summing all the money across all their multiple.
Examples
Example 1:
Input: [[5,2,3],[0,6,7]]
Expected Output: 13
Justification: The total wealth of the first customer is 10 and of the second customer is 13. So, the output is 13 as it's the maximum among all customers.
Example 2:
Input: [[1,2],[3,4],[5,6]]
Expected Output: 11
Justification: Total wealth for each customer is [3, 7, 11]. Maximum of these is 11.
Example 3:
Input: [[10,100],[200,20],[30,300]]
Expected Output: 330
Justification: Total wealth for each customer is [110, 220, 330]. The wealthiest customer has 330
 */
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
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
        RichestCustomerWealth sol = new RichestCustomerWealth();
        System.out.println(sol.maximumWealth(new int[][]{{5,2,3},{0,6,7}}));  // 13
        System.out.println(sol.maximumWealth(new int[][]{{1,2},{3,4},{5,6}}));  // 11
        System.out.println(sol.maximumWealth(new int[][]{{10,100},{200,20},{30,300}}));  // 330
    }

}
