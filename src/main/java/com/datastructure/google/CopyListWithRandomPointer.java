package com.datastructure.google;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
            next = null;
            random = null;
        }
    }
    public static void main(String[] args) {
        // Create the linked list with random pointers
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        // Copy the list
        Node copiedList = copyRandomList(node1);
        // Print copied list
        printList(copiedList);
    }
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and insert them between the original nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Set the random pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the two lists
        Node original = head;
        Node copiedHead = head.next;
        Node copied = copiedHead;

        while (original != null) {
            original.next = original.next.next;
            if (copied.next != null) {
                copied.next = copied.next.next;
            }
            original = original.next;
            copied = copied.next;
        }

        return copiedHead;
    }

    // Helper function to print the copied list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Value: " + current.val);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            current = current.next;
        }
    }
}
