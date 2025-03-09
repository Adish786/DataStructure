package com.datastructure.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Example 1
Input: root = [1, 2, 3, 4, 5, 6, 7]
Expected Output: [[4, 5, 6, 7], [2, 3], [1]]
Justification:
The third level has 4, 5, 6, and 7 nodes.
The second level has 2 and 3 nodes.
The first level has a single node with the value 1.
Example 2
Input: root = [12, 7, 1, null, 9, 10, 5]
Expected Output: [[9, 10, 5], [7, 1], [12]]
Justification:
The third level has 9, 10, and 5 nodes.
The second level has 7 and 1 nodes.
The first level has a single node with the value 12.
 */

public class ReverseOrderTraversalPattern {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node to the current level
                currentLevel.add(currentNode.val);
                // insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            // append the current level at the beginning
            result.add(0, currentLevel);
        }

        return result;
    }
    }
    public static void main(String[] args) {

    }
}
