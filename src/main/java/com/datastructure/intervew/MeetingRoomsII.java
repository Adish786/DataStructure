package com.datastructure.intervew;

import java.util.Arrays;

/*
The problem presents a scenario where we have an array of meeting time intervals,
each represented by a pair of numbers [start_i, end_i].
These pairs indicate when a meeting starts and ends. The goal is to find the minimum number
of conference rooms required to accommodate all these meetings without any overlap.
In other words, we want to allocate space such that no two meetings occur in the same
room simultaneously.
Meeting intervals: {{0, 30}, {5, 10}, {15, 20}}
Output :- 2
Time complexity :- O(nlogn)
 */
public class MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Separate the start and end times into two arrays
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        // Sort both arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int startPointer = 0, endPointer = 0;
        int roomsRequired = 0, maxRooms = 0;
        // Compare start and end times to determine overlaps
        while (startPointer < intervals.length) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                // A new meeting starts before the earliest ended meeting ends
                roomsRequired++;
                startPointer++;
            } else {
                // A meeting has ended, free up a room
                roomsRequired--;
                endPointer++;
            }
            // Track the maximum rooms needed
            maxRooms = Math.max(maxRooms, roomsRequired);
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum number of conference rooms required: " + minMeetingRooms(intervals));
    }
}
