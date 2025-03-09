package com.datastructure.doublyLinkedList;


public class InsertionAtBeginningMiddleEnd {
    class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }

    public Node addVal(Node head, int val) {
        if (head == null) return null;
        head = insertAtBeginning(head, val);
        head = insertInMiddle(head, val);
        head = insertAtEnd(head, val);
        return head;
    }

    private Node insertAtBeginning(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    private Node insertInMiddle(Node head, int val) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newNode = new Node(val);
        Node prevNode = slow.prev;
        newNode.next = slow;
        newNode.prev = prevNode;
        if (prevNode != null) {
            prevNode.next = newNode;
        }
        slow.prev = newNode;
        return head;
    }
    private Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

}
