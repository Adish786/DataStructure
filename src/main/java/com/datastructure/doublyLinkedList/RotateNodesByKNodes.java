package com.datastructure.doublyLinkedList;

public class RotateNodesByKNodes {
    class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        k = k % length;
        int stepsToNewHead = length - k;
        Node newTail = current;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }
}
