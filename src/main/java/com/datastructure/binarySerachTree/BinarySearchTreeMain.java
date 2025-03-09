package com.datastructure.binarySerachTree;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree myBT = new BinarySearchTree();
        myBT.insert(47);
        myBT.insert(21);
        myBT.insert(76);
        myBT.insert(18);
        myBT.insert(27);
        myBT.insert(52);
        myBT.insert(82);
       /*
        myBT.rInsert(1);
        myBT.rInsert(2);
        myBT.rInsert(3);

        */
        System.out.println(myBT.contains(27));  //true
        System.out.println(myBT.contains(47)); // true
    }

}
