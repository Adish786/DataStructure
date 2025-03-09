package com.datastructure.doublyLinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.printList();
    }
}