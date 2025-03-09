package com.datastructure.array;
/*
A bike rider is going on a ride. The road contains n + 1 points at different altitudes. The rider starts from point 0 at an altitude of 0
Input: gain = [-5, 1, 5, 0, -7]
Expected Output: 1
Justification: The altitude changes are [-5, -4, 1, 1, -6], where 1 is the highest altitude reached.
 */

public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;
        for(int i : gain) {
            currentAltitude += i;
            maxAltitude = Math.max(currentAltitude, maxAltitude);
        }
        return maxAltitude;
    }
    public static void main(String[] args) {
        HighestAltitude solution = new HighestAltitude();
        System.out.println(solution.largestAltitude(new int[]{-5, 1, 5, 0, -7})); // Expected: 1
        System.out.println(solution.largestAltitude(new int[]{4, -3, 2, -1, -2})); // Expected: 4
        System.out.println(solution.largestAltitude(new int[]{2, 2, -3, -1, 2, 1, -5})); // Expected: 4
    }
}
