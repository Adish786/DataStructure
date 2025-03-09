package com.datastructure.google;
/*
Linked List Cycle 11
given the head of a linked list, return the node where the cycle begins . if there is no cycle
return null. do not modity the linked list
input head = [3,2,0,-4] , pos =1
output: tail connects to node index 1
explanation: there is a cycle in the linked list, where tail connects to the second node
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        // Create a linked list with a cycle: [3,2,0,-4], cycle starts at index 1
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Cycle here, tail points to the second node
        ListNode cycleStartNode = detectCycle(head);
        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleStartNode.val);  // Output: 2
        } else {
            System.out.println("No cycle detected.");
        }
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if there is a cycle using Floyd's cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1 step
            fast = fast.next.next;    // Move fast pointer by 2 steps

            if (slow == fast) {  // Cycle detected
                // Step 2: Find the starting node of the cycle
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;  // The node where the cycle starts
            }
        }

        // No cycle detected
        return null;
    }

   static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

}

