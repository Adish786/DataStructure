package com.datastructure.intervew;

public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0; // To store the current altitude during iteration
        int maxAltitude = 0; // To store the maximum altitude encountered
        for(int i : gain) {
            currentAltitude += i;
            maxAltitude = Math.max(currentAltitude, maxAltitude);
        }
        return maxAltitude;
    }
    public static void main(String[] args) {
        LargestAltitude solution = new LargestAltitude();
        System.out.println(solution.largestAltitude(new int[]{-5, 1, 5, 0, -7})); // Expected: 1
        System.out.println(solution.largestAltitude(new int[]{4, -3, 2, -1, -2})); // Expected: 4
        System.out.println(solution.largestAltitude(new int[]{2, 2, -3, -1, 2, 1, -5})); // Expected: 4
    }
}
