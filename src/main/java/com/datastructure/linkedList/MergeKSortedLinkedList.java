package com.datastructure.linkedList;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode mergeKLists(List<ListNode> listArray) {
        if (listArray == null || listArray.size() == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : listArray) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummy.next;

    }
}
