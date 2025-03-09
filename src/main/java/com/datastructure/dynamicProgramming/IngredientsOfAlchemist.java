package com.datastructure.dynamicProgramming;
/*
Ingredients of Alchemist
You are a young alchemist on a quest to brew a magical potion. Each day, you add a specific number of ingredients to the cauldron. Write a function to recursively calculate the total number of ingredients used to brew the potion over a given number of days.

Input Format:

An integer n, representing the number of days you have brewed the potion.
An integer ingredientsPerDay, representing the number of ingredients added to the cauldron each day.
Output Format:
An integer representing the total number of ingredients used over n days.
Sample Input 1:
8 9
Sample Output 1:
72
Explanation 1:
For 8 days, adding 9 ingredients each day results in (8 * 9 = 72) ingredients.
Sample Input 2:
10 6
Sample Output 2:
60
Explanation 2:
For 10 days, adding 6 ingredients each day results in (10 * 6 = 60) ingredients
 */

public class IngredientsOfAlchemist {
    public static int solve(int n, int ingredientsPerDay) {
        if (n == 0) {
            return 0;
        }
        return ingredientsPerDay + solve(n - 1, ingredientsPerDay);
    }
    public static void main(String[] args) {
            int n =8;
            int ingredientsPerDay = 9;
        System.out.println(solve(n,ingredientsPerDay));
    }
}
