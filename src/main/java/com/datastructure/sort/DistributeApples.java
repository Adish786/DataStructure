package com.datastructure.sort;
import java.util.Arrays;
/*
Apple Redistribution into Boxes
Input: apple = [2, 3, 1], capacity = [4, 2, 5, 1]
Expected Output: 2
Explanation: Box 1 can take apples from packs 1 and 2 partially (totaling 5 apples), and Box 2 can take the rest of 2 apples

 */

public class DistributeApples {
    public int distributeApples(int[] apples, int[] boxCapacities) {
        Arrays.sort(boxCapacities);
        int totalApples = 0;
        for (int count : apples) {
            totalApples += count;
        }
        int i = boxCapacities.length - 1;
        while (i >= 0 && totalApples > 0) {
            totalApples -= boxCapacities[i];
            i--;
        }
        return boxCapacities.length - i - 1;
    }

    public static void main(String[] args) {
        DistributeApples sol = new DistributeApples();
        int[] apples1 = {2, 3, 1};
        int[] capacities1 = {4, 2 ,5, 1};
        System.out.println("Example 1: Expected output is 1, Actual output is " + sol.distributeApples(apples1, capacities1));
        int[] apples2 = {4, 5, 6};
        int[] capacities2 = {5, 10};
        System.out.println("Example 2: Expected output is 2, Actual output is " + sol.distributeApples(apples2, capacities2));
        int[] apples3 = {1, 2, 5, 6};
        int[] capacities3 = {2, 3, 7, 4, 5, 2, 4};
        System.out.println("Example 3: Expected output is 3, Actual output is " + sol.distributeApples(apples3, capacities3));
    }
}
