package com.datastructure.hashTable;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("Adish",12);
        hashTable.set("Ansari",32);
        hashTable.set("Java",11);
        hashTable.set("developer",16);
        hashTable.printTable();
        System.out.println(hashTable.keys());

    }
}
