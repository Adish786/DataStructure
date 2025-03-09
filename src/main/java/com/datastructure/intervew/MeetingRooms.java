package com.datastructure.intervew;

import java.util.Arrays;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true
Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
 */
public class MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            var a = intervals[i - 1];
            var b = intervals[i];
            if (a[1] > b[0]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(intervals));
    }
}
