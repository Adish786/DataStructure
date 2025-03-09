package com.datastructure.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/*
First Non Repeating
Given a string str which denotes a stream of characters, your task is to find a new string output_str. output_str is formed such that we have to find the first non-repeating character at each instance when a character is inserted into the stream and append it at the end of output_str. If no such non-repeating character is found, then append 'X' at the end of output_str
Sample Input 1:
dabc
Sample Output 1:
dddd
Explanation:
"d" - first non-repeating character 'd'.
"da" - first non-repeating character 'd'.
"dab" - first non-repeating character 'd'.
"dabc" - first non-repeating character 'd'.
Sample Input 2:
bbe
Sample Output 2:
bXe
Explanation:
"b" - first non-repeating character 'b'.
"bb" - no non-repeating character so 'X'.
"bbe" - first non-repeating character 'e'.
 */

public class FirstNonRep {
    public static void main(String[] args) {
        String str ="dabc";
        System.out.println(firstNonRep(str));
    }
    public static String firstNonRep(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder outputStr = new StringBuilder();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            queue.offer(ch);
            while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                outputStr.append('X');
            } else {
                outputStr.append(queue.peek());
            }
        }
        return outputStr.toString();
    }
}
