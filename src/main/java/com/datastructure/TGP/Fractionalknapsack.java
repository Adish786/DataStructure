package com.datastructure.TGP;

import java.util.ArrayList;
import java.util.List;
/*
Fractional knapsack
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note: Unlike 0/1 knapsack, you are allowed to break the item.
Example 1
Input
N = 3, W = 50
values = [60,100,120]
weight = [10,20,30]
Output
240.00
Explanation:
Initial W = 50. take item 1 with weight 10 and value 60 so W is now 50 - 10 = 40. take item 2 with weight 20 and value 100 so W is now 40 - 20 = 20. Now, we cannot take item 3 completely so we will just take W = 20 amount of it and the value we will get out of it is 80 and W becomes 20 - 20 = 0. so total value is 60 + 100 + 80 = 240. So,Total maximum value of item we can have is 240.00 from the given capacity of sack.
Example 2
Input
N = 2, W = 50
values = [60,100]
weight = [10,20]
Output
160.00
Explanation:
Total maximum value of item we can have is 160.00 from the given capacity of sack.
Constraints:
1 <= Items.length <= 10000
1 <= Items.value , Items.weight <= 100000

 */
public class Fractionalknapsack {
    public double fractionalKnapsack(int N, int W, List<Integer> values, List<Integer> weight) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            items.add(new Item(values.get(i), weight.get(i)));
        }
        items.sort((a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));
        double totalValue = 0.0;
        int remainingWeight = W;

        for (Item item : items) {
            if (remainingWeight == 0) {
                break;
            }
            if (item.weight <= remainingWeight) {
                totalValue += item.value;
                remainingWeight -= item.weight;
            } else {
                totalValue += item.valuePerWeight * remainingWeight;
                remainingWeight = 0;
            }
        }
        return totalValue;
    }
    private static class Item {
        int value;
        int weight;
        double valuePerWeight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double) value / weight;
        }
    }
    public static void main(String[] args) {

    }
}
