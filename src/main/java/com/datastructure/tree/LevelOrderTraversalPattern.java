package com.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Example 1:
Input: root = [4, 5, 10, 5, 7]
Image
Output: [4, 5, 10, 5, 7]
Justification: The binary tree's first level contains the root node 4. The second level contains the nodes 5 and 10. The third level contains nodes 5 and 7.
Example 2:
Input: root = [5]
Output: [5]
Justification: The binary tree's first level is the root 5. The tree contains only 1 level.
 */
public class LevelOrderTraversalPattern {

    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
   public void printLevelOrder(TreeNode root) {
        // If the tree is empty, there's nothing to print
        if (root == null) {
            return;
        }
        // Initialize a queue to keep track of nodes to visit
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Iterate through all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Dequeue the next node
                System.out.print(node.val + " ");
                // If the left child exists, enqueue it for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // If the right child exists, enqueue it for the next level
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    public static void main(String[] args) {

    }

}
