package com.datastructure.tree;

public class Solution {
    public static void main(String[] args) {
        BST<Integer> obj = new BST<>();
        obj.insert(5);
        obj.insert(3);
        obj.insert(7);
        obj.insert(2);
        obj.insert(4);
        obj.insert(6);
        obj.insert(8);

        obj.inOrder();
        obj.preOrder();
        obj.postOrder();

        obj.deleteMethod(2);

        obj.inOrder();
    }
}
