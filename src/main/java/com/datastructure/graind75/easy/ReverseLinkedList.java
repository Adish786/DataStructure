package com.datastructure.graind75.easy;

import com.datastructure.graind75.MergeTwoSortedLists;

public class ReverseLinkedList {
    /*
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
     */

    public class ListNode {
        int val;
        MergeTwoSortedLists.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, MergeTwoSortedLists.ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
}
