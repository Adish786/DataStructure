package com.datastructure.intervew;
/*
Maximum Population Year
You are given a 2D integer array logs containing the birth and death years of n people. In logs array, logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
Input: logs = [[1980, 1990], [1975, 1985], [1985, 1995], [1990, 2000], [1999, 2020], [1994, 2032]]
Expected Output: 1994
Explanation: The population in the year 1994 was the highest. In that year,
3 people were alive (born in 1985, 1990, and 1994)

 */

public class MaximumPopulation {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101]; // Array to store population changes
        for (int[] log : logs) {
            population[log[0] - 1950]++; // Increment population at birth year
            population[log[1] - 1950]--; // Decrement population at death year
        }
        int maxPop = 0;
        int maxYear = 1950;
        int currentPop = 0;
        // Calculate maximum population year
        for (int year = 0; year < 101; year++) {
            currentPop += population[year];
            if (currentPop > maxPop) {
                maxPop = currentPop;
                maxYear = 1950 + year;
            }
        }
        return maxYear;
    }
    public static void main(String[] args) {
        MaximumPopulation sol = new MaximumPopulation();
        int[][] logs1 = {{1980, 1990}, {1975, 1985}, {1985, 1995}, {1990, 2000}, {1999, 2020}, {1994, 2032}};
        int[][] logs2 = {{1970, 1990}, {1980, 2009}, {1960, 1970}, {1959, 1982}};
        int[][] logs3 = {{2000, 2010}, {2005, 2015}, {2010, 2020}, {2015, 2025}};

        System.out.println(sol.maximumPopulation(logs1)); // Output: 1994
        System.out.println(sol.maximumPopulation(logs2)); // Output: 1980
        System.out.println(sol.maximumPopulation(logs3)); // Output: 2005
    }
}