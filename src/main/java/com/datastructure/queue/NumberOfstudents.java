package com.datastructure.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Number of students unable to eat lunch
The school cafeteria offers circular and square sandwiches at lunch break, represented by numbers 0 and 1, respectively. All students stand in a queue, expressing their preference for either square or circular sandwiches.
The number of sandwiches in the cafeteria is equal to the number of students, and these sandwiches are placed in a stack. The lunch process unfolds as follows:
If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue. Otherwise, they will leave the sandwich on the top of the stack and go to the end of the queue. This process continues until none of the students in the queue want to take the top sandwich, rendering them unable to eat.
You are given two integer arrays, students and sandwiches, where sandwiches[i] represents the type (0 or 1) of the i​​​​​​th sandwich in the stack, and students[j] represents the preference (0 or 1) of the j​​​​​​th student in the initial queue. Your task is to return the number of students who are unable to eat.
Example:1
students = [1, 1, 1, 0, 0, 1]
sandwiches = [1, 0, 0, 0, 1, 1]
Output:
3
Example2:
students = [1, 1, 0, 0] sandwiches = [0, 1, 0, 1]
Output:
0
 */
public class NumberOfstudents {
    public static void main(String[] args) {
        List<Integer> students = Arrays.asList(1, 1, 1, 0, 0, 1);
        List<Integer> sandwiches = Arrays.asList(1, 0, 0, 0, 1, 1);
        System.out.println(countStudents(students,sandwiches));
    }
    public static int countStudents(List<Integer> students, List<Integer> sandwiches){
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }
        int index = 0;
        int failedAttempts = 0;
        while (!studentQueue.isEmpty()) {
            if (studentQueue.peek() == sandwiches.get(index)) {
                studentQueue.poll();
                index++;
                failedAttempts = 0;
            } else {
                studentQueue.add(studentQueue.poll());
                failedAttempts++;
            }
            if (failedAttempts == studentQueue.size()) {
                break;
            }
        }
        return studentQueue.size();
    }
}
