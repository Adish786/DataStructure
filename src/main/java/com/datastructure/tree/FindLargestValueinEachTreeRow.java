package com.datastructure.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Example 1
Input: root = [1, 2, 3, 4, 5, null, 6]
Expected Output: [1, 3, 6]
Image
Justification:
The first row contains 1. The largest value is 1.
The second row has 2 and 3, and the largest is 3.
The third row has 4, 5, and 6, and the largest is 6.
Example 2
Input: root = [7, 4, 8, 2, 5, null, 9, null, 3]
Expected Output: [7, 8, 9, 3]
Image
Justification:
The first row contains 7, and the largest value is 7.
The second row has 4 and 8, and the largest is 8.
The third row has 2, 5, and 9, and the largest is 9.
The fourth row has 3, and the largest is 3.
 */
public class FindLargestValueinEachTreeRow {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    // Method to find the largest value in each row of the binary tree
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // Return an empty list if the root is null
        if (root == null) return result;
        // Initialize a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Perform level order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;
            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // Find the maximum value at the current level
                maxVal = Math.max(maxVal, node.val);
                // Add left and right children to the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // Store the largest value of the current level
            result.add(maxVal);
        }

        return result;
    }



    public static void main(String[] args) {
          //  TreeNode treeNode = new int[]{7, 4, 8, 2, 5, null, 9, null, 3};
    }

}
