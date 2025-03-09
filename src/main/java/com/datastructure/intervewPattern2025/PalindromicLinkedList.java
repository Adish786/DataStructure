package com.datastructure.intervewPattern2025;
/*
Given the head of a singly linked list, determine if it is a palindrome.
Example 1:1,2,3,2,1
Output: True
Example 2:1,2,1,2
Output: False
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty list or single node is a palindrome
        }
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        // Step 3: Compare the first half with the reversed second half
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; // Not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true; // It is a palindrome
    }
    // Helper function to reverse a linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    // Helper function to print the linked list (for testing)
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1: 1 -> 2 -> 3 -> 2 -> 1 (Palindrome)
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);

        System.out.println("Example 1:");
        printList(head1);
        System.out.println("Is Palindrome: " + isPalindrome(head1)); // Output: true

        // Example 2: 1 -> 2 -> 1 -> 2 (Not a Palindrome)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);

        System.out.println("\nExample 2:");
        printList(head2);
        System.out.println("Is Palindrome: " + isPalindrome(head2)); // Output: false
    }
}
