package com.datastructure.set;
import java.util.*;
/*
Union and Intersection
Given two arrays, find their intersection and union and print the result in the solution function. A union between two arrays is defined as all the elements that occur in any one of the arrays. For example, if a = [1, 2, 2, 3, 4] and b = [1, 1, 3, 5, 6, 6], the union of these arrays is U = [1, 2, 3, 4, 5, 6]. The intersection between two arrays is defined as all the elements that are present in both arrays. Considering the same example, the intersection of those arrays is I = [1, 3].
Note: You have to print the union array first and then in the next line print the intersection array. Also, while printing, make sure these things are followed:
There is a space after each element except the last one.
First, the union array should be printed, then in the next line, the intersection array.
Input Format:
The first line contains two integers n and m, denoting the number of elements in the two arrays.
The second line contains n space-separated integers representing the elements of the first array.
The third line contains m space-separated integers representing the elements of the second array.
Output Format:
Print the union array first and then the intersection array in the next line.
Sample Input 1:
3 4
1 5 9
1 4 6 8
Sample Output 1:
1 4 5 6 8 9
1
Explanation 1:
The union of the arrays is [1, 4, 5, 6, 8, 9] and the intersection is [1].
Sample Input 2:
3 4
1 2 2
2 3 4 5
Sample Output 2:
1 2 3 4 5
2
Explanation 2:
The union of the arrays is [1, 2, 3, 4, 5] and the intersection is [2]

*/

public class UnionAndIntersection {
    public static   void unionAndIntersection(int[] arr1, int[] arr2, int n, int m) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            setB.add(arr2[i]);
        }
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        List<Integer> unionList = new ArrayList<>(union);
        List<Integer> intersectionList = new ArrayList<>(intersection);
        Collections.sort(unionList);
        Collections.sort(intersectionList);
        for (int i = 0; i < unionList.size(); i++) {
            System.out.print(unionList.get(i));
            if (i != unionList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < intersectionList.size(); i++) {
            System.out.print(intersectionList.get(i));
            if (i != intersectionList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
            int[] arr1 = {1,5,9};
            int[] arr2 = {1,4,6,8};
            int n=3;
            int m =4;
        unionAndIntersection(arr1,arr2,n,m);
    }
}
