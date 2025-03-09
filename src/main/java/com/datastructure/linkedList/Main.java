package com.datastructure.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.remove(2);
        myLinkedList.reverse();
        myLinkedList.printList();
    }
}
