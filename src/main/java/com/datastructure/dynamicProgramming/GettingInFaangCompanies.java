package com.datastructure.dynamicProgramming;
/*
A learner at HeyCoach wants to grab a job in a FAANG company, so they start following a schedule (learning DSA, practicing questions, and learning CS fundamentals).
Each day, they perform one of these three activities and can’t perform the same activity on two consecutive days. Each activity has some merit points on each day.
These merit points will decide whether they are eligible to get into a FAANG company or not. The learner wants to improve everything to get a good job as early as possible.
Can you help the learner in finding out the maximum merit points they can earn?
Input Format:
The first line contains a single integer ( n ) denoting the number of days.
The next ( n ) lines contain three space-separated integers denoting the merit values of each of the three activities on that day.
Output Format:
Return the maximum amount of merit points achievable.
Sample Input 1:
3
1 2 5
3 1 1
3 3 3
Sample Output 1:
11
Explanation 1:
On day 1, the learner can choose activity 3 (5 points). On day 2, they can choose activity 1 (3 points). On day 3, they can choose activity 3 (3 points). Total merit points = 5 + 3 + 3 = 11.
Sample Input 2:
4
1 2 3
3 2 1
1 2 3
3 2 1
Sample Output 2:
12
Explanation 2:
On day 1, the learner can choose activity 3 (3 points). On day 2, they can choose activity 1 (3 points). On day 3, they can choose activity 3 (3 points). On day 4, they can choose activity 1 (3 points). Total merit points = 3 + 3 + 3 + 3 = 12
 */
public class GettingInFaangCompanies {
    public static int maxPoints(int n, int[][] points) {
        int[][] memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j] = -1;
            }
        }
        return Math.max(maxPoint(points, n - 1, 0, memo),
                Math.max(maxPoint(points, n - 1, 1, memo),
                        maxPoint(points, n - 1, 2, memo)));
    }
    private static int maxPoint(int[][] points, int day, int lastActivity, int[][] memo) {
        if (day < 0) {
            return 0;
        }
        if (memo[day][lastActivity] != -1) {
            return memo[day][lastActivity];
        }
        int maxPoints = 0;
        for (int i = 0; i < 3; i++) {
            if (i != lastActivity) {
                maxPoints = Math.max(maxPoints, points[day][i] + maxPoint(points, day - 1, i, memo));
            }
        }
        memo[day][lastActivity] = maxPoints;
        return maxPoints;
    }


    public static void main(String[] args) {
        int n=3;
        int[][] arr = { { 1, 2, 5}, {3, 1, 1}, {3, 3, 3} };
        System.out.println(maxPoints(n,arr));
    }
}
