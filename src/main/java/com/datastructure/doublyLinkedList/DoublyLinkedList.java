package com.datastructure.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }
    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }
    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail= newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    public Node removeLast(){
        if(length==0) return null;
        Node temp = tail;
        tail = tail.prev;
        if(length==1){
            head=null;
            tail=null;
        }
        else {
            tail=tail.prev;
            tail.prev=null;
            tail.next=null;
        }
        length--;
        return  temp;
    }

    public void  prepend(int value){
        Node newNode = new Node(value);
        if(length ==0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length ++;
    }
    public  Node removeFirst(){
        if(length ==0) return null;
        Node temp = head;
        if(length ==1){
            head = null;
            tail = null;
        }
        else {
            head =head.next;
            head.prev=null;
            temp.next=null;
        }
        length --;
        return temp;
    }
//TODO  first ways swaped first and last
    public void swapFirstAndLast() {
        if (head == null || head.next == null) {
            return;
        }
        Node first = head;
        Node last = tail;
        if (first.next == last) {
            first.next = null;
            first.prev = last;
            last.prev = null;
            last.next = first;
            head = last;
            tail = first;
            return;
        }
    }
    //TODO secodn ways swaped first and last
    public void swapFirstLast() {
        if (length < 2) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
    }
    public boolean isPalindrome() {
        if (head == null) {
            return true;
        }
        Node left = head;
        Node right = tail;
        while (left != null && right != null && left != right && left.prev != right) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }


    public void swapInPairs() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            int temp = current.value;
            current.value = current.next.value;
            current.next.value = temp;
            current = current.next.next;
        }
    }

}

