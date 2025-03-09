package com.datastructure.DP;
/*
Given the weights and profits of 'N' items, we are asked to put these items in a knapsack that has a capacity 'C'. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don't have multiple quantities of any item.
Let's take Merry's example, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:
Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5
Let's try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:
Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit
This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
Problem Statement
Given two integer arrays to represent weights and profits of 'N' items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number 'C'. Write a function that returns the maximum profit. Each item can only be selected once, which means either we put an item in the knapsack or skip it.
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] profits = {4, 5, 3, 7 };
        int[] weights = {2, 3, 1, 4};
        int capacity = 5;
        System.out.println(solveKnapsack(profits,weights,capacity));
    }
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return knapsackRecursive(profits, weights, capacity, 0);
    }
    public static int knapsackRecursive(int[] weights,int[]profits,int capacity,int currentIndex){
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;
        int profit1=0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);
        int profit2 = knapsackRecursive(profits,weights,capacity,currentIndex+1);
        return Math.max(profit1,profit2);
    }
}
