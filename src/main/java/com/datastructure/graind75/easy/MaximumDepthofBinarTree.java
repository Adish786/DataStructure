package com.datastructure.graind75.easy;

import com.datastructure.graind75.MergeTwoSortedLists;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2
 */
public class MaximumDepthofBinarTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public class TreeNode {
        int val;
        TreeNode next;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
