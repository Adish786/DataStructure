package com.datastructure.intervewPattern2025;
/*
1 -> 2 -> 3 -> 4 -> 5 -> 6
     |         |
     7 -> 8    9 -> 10
          |    |
          11   12 -> 13
The flattened list will be:
1 -> 2 -> 7 -> 8 -> 11 -> 3 -> 4 -> 9 -> 12 -> 13 -> 10 -> 5 -> 6
Output:
For the provided example, the output will be:
Original multi-level linked list:
1 2 3 4 5 6
Flattened linked list:
1 2 7 8 11 3 4 9 12 13 10 5 6
Complexity Analysis:
Time Complexity:
O(n): We traverse each node in the list once, where n is the total number of nodes.
Space Complexity:
O(1): We use constant extra space (no additional data structures)
 */
class MultiLevelListNode {
    int val;
    MultiLevelListNode next;
    MultiLevelListNode child;
    // Constructor
    MultiLevelListNode(int val, MultiLevelListNode next, MultiLevelListNode child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }
}

public class FlattenMultiLevelLinkedList {
    public static MultiLevelListNode flattenMultiLevelList(MultiLevelListNode head) {
        if (head == null) {
            return null;
        }
        // Find the tail of the linked list at the first level
        MultiLevelListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // Process each node at the current level
        MultiLevelListNode curr = head;
        while (curr != null) {
            // If the current node has a child linked list
            if (curr.child != null) {
                // Append the child linked list to the tail
                tail.next = curr.child;

                // Disconnect the child linked list from the current node
                curr.child = null;

                // Update the tail to the end of the extended linked list
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
            // Move to the next node in the current level
            curr = curr.next;
        }

        return head;
    }

    // Helper function to print the flattened linked list (for testing)
    public static void printList(MultiLevelListNode head) {
        MultiLevelListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example multi-level linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //      |         |
        //      7 -> 8    9 -> 10
        //           |    |
        //           11   12 -> 13

        MultiLevelListNode node13 = new MultiLevelListNode(13, null, null);
        MultiLevelListNode node12 = new MultiLevelListNode(12, node13, null);
        MultiLevelListNode node11 = new MultiLevelListNode(11, null, null);
        MultiLevelListNode node10 = new MultiLevelListNode(10, null, null);
        MultiLevelListNode node9 = new MultiLevelListNode(9, node10, node12);
        MultiLevelListNode node8 = new MultiLevelListNode(8, null, node11);
        MultiLevelListNode node7 = new MultiLevelListNode(7, node8, null);
        MultiLevelListNode node6 = new MultiLevelListNode(6, null, null);
        MultiLevelListNode node5 = new MultiLevelListNode(5, node6, null);
        MultiLevelListNode node4 = new MultiLevelListNode(4, node5, node9);
        MultiLevelListNode node3 = new MultiLevelListNode(3, node4, null);
        MultiLevelListNode node2 = new MultiLevelListNode(2, node3, node7);
        MultiLevelListNode node1 = new MultiLevelListNode(1, node2, null);

        System.out.println("Original multi-level linked list:");
        printList(node1);

        // Flatten the multi-level linked list
        MultiLevelListNode flattenedHead = flattenMultiLevelList(node1);

        System.out.println("Flattened linked list:");
        printList(flattenedHead);
    }
}
