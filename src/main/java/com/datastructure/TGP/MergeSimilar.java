package com.datastructure.TGP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Merge Similar
Diwali is coming so you have to clear all your stock so that you can bring new arrival goods at your store. You have 2 stores in store 1 you have n goods and in store 2 you have m goods. Each goods have 2 components written on it 1st value and weight. You have to find the total weight of the goods with respect to value number in both store. You are given two 2D integer arrays, items1 and items2, representing two sets of items. Each array items has the following properties:

items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
The value of each item in items is unique.
Input Format:
first line contains 2 integers n(size of the first store) and m(size of the second store).
next (n+m) lines contains 2 integers value and weight respectively. first n lines are the goods of the 1st store and next m lines are the goods of 2nd store.
Output Format:
Print all the goods with their value and weights (with single space separated).
each goods in new line.
Example:
Input:
3 2
1 1
4 5
3 8
3 1
1 5
Output:
1 6
3 9
4 5
Contraints:
1 <=n,m <= 1000
items1[i].length == items2[i].length == 2
1 <= valuei, weighti <= 1000
Each valuei in items1 is unique.
Each valuei in items2 is unique
 */
public class MergeSimilar {
    public void mergeSimilarItems(List<List<Integer>> item1, List<List<Integer>> item2) {
        Map<Integer, Integer> itemMap = new HashMap<>();
        for (int i = 0; i < item1.size(); i++) {
            int value = item1.get(i).get(0);
            int weight = item1.get(i).get(1);
            itemMap.put(value, itemMap.getOrDefault(value, 0) + weight);
        }
        for (int i = 0; i < item2.size(); i++) {
            int value = item2.get(i).get(0);
            int weight = item2.get(i).get(1);
            itemMap.put(value, itemMap.getOrDefault(value, 0) + weight);
        }
        List<Map.Entry<Integer, Integer>> itemList = new ArrayList<>(itemMap.entrySet());
        itemList.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, Integer> entry : itemList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {

    }
}
