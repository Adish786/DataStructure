package com.datastructure.TGP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Professor white wants his students to help each other in the chemistry lab. He suggests that every student should help out another student who scored less marks than him in chemistry and whose roll number appears after him. But the students are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria. Find the marks of the student that each student picks.
Note: one student may be selected by multiple classmates.
Example 1
Input
N = 5, arr = [3, 8, 5, 2, 25]
Output
[2,5,2,-1,-1]
Explanation
1. Roll number 1 has 3 marks. The first person who has less marks than him is roll number 4, who has 2 marks.
2. Roll number 2 has 8 marks, he helps student with 5 marks.
3. Roll number 3 has 5 marks, he helps student with 2 marks.
4. Roll number 4 and 5 can not pick anyone as no student with higher roll number has lesser marks than them. This is denoted by -1.Output shows the marks of the weaker student that each roll number helps in order. i.e.- 2,5,2,-1,-1
Example 2:
Input:
N = 4, a = [1, 2, 3, 4]
Output:
[-1,-1,-1,-1]
Explanation
As the marks are in increasing order. None of the students can find a classmate who has
a higher roll number and less marks than them.
Input Format
The first input line has one integer n
The Second line contain n integers which are array elements
Output Format
Output the array which shows marks of the student that each student picks.
Constraints:
1 <= a.length <= 10000
1 <= a[i] <= 100000
 */
public class HelpStudents {
    public static List<Integer> helpStudents(List<Integer> arr, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(findHelp(arr, i, n));
        }
        return result;
    }

    private static int findHelp(List<Integer> arr, int currentIndex, int n) {
        if (currentIndex >= n - 1) {
            return -1;
        }
        for (int i = currentIndex + 1; i < n; i++) {
            if (arr.get(i) < arr.get(currentIndex)) {
                return arr.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        int N = 4;
        System.out.println(helpStudents(arr, N));
    }
}
