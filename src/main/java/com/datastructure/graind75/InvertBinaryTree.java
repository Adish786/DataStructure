package com.datastructure.graind75;
/*
Given the root of a binary tree, invert the tree, and return its root.
Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode next;
        TreeNode left,right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {

    }
}
