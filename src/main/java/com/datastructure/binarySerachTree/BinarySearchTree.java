package com.datastructure.binarySerachTree;

import com.datastructure.test.Solution;

import java.util.*;

public class BinarySearchTree {
    private  Node root;
    class Node {
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }


    public BinarySearchTree(){
        root = null;
    }
    //TODO Insert Method
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root==null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if(newNode.value ==temp.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else {
                if(temp.right ==null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    //TODO Contains method
    public boolean contains(int value){
        if(root ==null) return false;
        Node temp = root;
        while (temp != null){
            if(value < temp.value){
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            }
            else {
                return true;
            }
        }
        return false;
    }

    //TODO recursive ways contains method

    private boolean rContains(Node currentNode , int value){
        if(currentNode==null) return  false;
        if(currentNode.value == value) return  true;
        if(value < currentNode.value){
            return rContains( currentNode.left,value);
        }
        else {
            return rContains(currentNode.right,value);
        }
    }
    public boolean rContains(int value){
        return rContains(root,value);
    }
//TODO Insert recursive method
        public void rInsert(int value){
            if(root ==null) root = new Node(value);
            rInsert(root,value);
        }
    private Node rInsert(Node currentNode , int value){
    if(currentNode ==null) return new Node(value);
    if(value <currentNode.value){
        currentNode.left = rInsert(currentNode.left,value);
    }
    else if(value > currentNode.value){
        currentNode.right = rInsert(currentNode.right,value);
    }
    return currentNode;
    }
    //TODO minimul value

    public int minValue(Node curruntNode){
        while (curruntNode.left !=null){
            curruntNode = curruntNode.left;
        }
        return curruntNode.value;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
//TODO sorted array to bst Intervew question
    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);

        node.right = sortedArrayToBST(nums, mid + 1, right);

        return node;
    }
                //TODO delete node
    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }
    private Node deleteNode(Node currentNode,int value){
        if(currentNode ==null) return null;
        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left,value);
        }
        else if(value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right,value);
        }
        else {
            if(currentNode.left ==null && currentNode.right ==null){
                currentNode = null;
            }
            else if(currentNode.left ==null){
                currentNode = currentNode.right;
            }
            else if(currentNode.right ==null){
                currentNode = currentNode.left;
            }
            else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right,subTreeMin);
            }
        }
        return currentNode;
    }

//TODO invert node
    public void invert() {
        root = invertTree(root);
    }

    private Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    //TODO BFS

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while (queue.size()>0){
            currentNode = queue.remove();
            results.add(currentNode.value);
            if(currentNode.left !=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right !=null){
                queue.add(currentNode.right);
            }
        }
        return  results;
    }
            //TODO  DFS Pre Order  (root-left-right)

    public  ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Travers{
            Travers(Node currentNode){
                results.add(currentNode.value);
                if(currentNode.left !=null){
                    new Travers(currentNode.left);
                }
                if(currentNode.right !=null){
                    new Travers(currentNode.right);
                }

            }
        }
        new Travers(root);
        return results;
    }

    //TODO DFS Post Order (left-right-root)

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Travers{
            Travers(Node currentNode){
                if(currentNode.left !=null){
                    new Travers(currentNode.left);
                }
                if(currentNode.right !=null){
                    new Travers(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Travers(root);
        return results;
    }

    //TODO DFS In Order (left-root.right)
    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Travers{
            Travers(Node currentNode){
                if(currentNode.left!=null){
                    new Travers(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right!=null){
                    new Travers(currentNode.right);
                }
            }
        }
        new Travers(root);
        return results;
    }
//TODO Intervew
    public boolean isValidBST() {
        ArrayList<Integer> nodeValues = DFSInOrder();
        for (int i = 1; i < nodeValues.size(); i++) {
            if (nodeValues.get(i) <= nodeValues.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    //TODO Intervew
    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }

    public int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
//find path
    public static List<Node> findPath(Node root, int target) {
        List<Node> path = new ArrayList<>();
        findPathRecursive(root, target, path);
        return path;
    }
    private static boolean findPathRecursive(Node node, int target, List<Node> path) {
        if (node == null) {
            return false;
        }
        path.add(node);
        if (node.value == target) {
            return true;
        }
        if (node.value > target) {
            if (findPathRecursive(node.left, target, path)) {
                return true;
            }
        } else {
            if (findPathRecursive(node.right, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    //TODO Method to find the longest path using BFS
    public static List<Node> findLongestPath(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<List<Node>> pathQueue = new LinkedList<>();
        nodeQueue.add(root);
        List<Node> rootPath = new ArrayList<>();
        rootPath.add(root);
        pathQueue.add(rootPath);
        List<Node> longestPath = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();
            List<Node> currentPath = pathQueue.poll();
            if (currentPath.size() > longestPath.size()) {
                longestPath = currentPath;
            }
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
                List<Node> newPath = new ArrayList<>(currentPath);
                newPath.add(currentNode.left);
                pathQueue.add(newPath);
            }
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
                List<Node> newPath = new ArrayList<>(currentPath);
                newPath.add(currentNode.right);
                pathQueue.add(newPath);
            }
        }
        return longestPath;
    }
    //TODO Zigzagging through the Binary Tree
    public int maxZigzagStudents(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (leftToRight)
                    currentLevel.add(currentNode.value);
                else
                    currentLevel.add(0, currentNode.value);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result.size();
    }
    //TODO Optional Tree Escape
    public int escapeTree(Node root) {
        if (root == null) {
            return 0;
        }
        int ramDepth = getLeftmostDepth(root);
        int shyamDepth = getRightmostDepth(root);

        if (ramDepth == shyamDepth) {
            return 0;
        } else if (ramDepth < shyamDepth) {
            return -1;
        } else {
            return 1;
        }
    }
    private int getLeftmostDepth(Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
    private int getRightmostDepth(Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
//TODO Maximum Sum of a Subarray in Topview of Binary Tree
class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
    public int maxSumTopView(Node root) {
    if (root == null) return 0;
    Map<Integer, Integer> topViewMap = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root, 0));
    while (!queue.isEmpty()) {
        Pair current = queue.poll();
        Node node = current.node;
        int hd = current.hd;
        if (!topViewMap.containsKey(hd)) {
            topViewMap.put(hd, node.value);
        }
        if (node.left != null) {
            queue.offer(new Pair(node.left, hd - 1));
        }
        if (node.right != null) {
            queue.offer(new Pair(node.right, hd + 1));
        }
    }
    List<Integer> topView = new ArrayList<>(topViewMap.values());
    return maxSumSubarray(topView);
}
    private int maxSumSubarray(List<Integer> nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

//TODO Concatenate the Nodes
public void Concatenate(Node root) {
    if (root == null) {
        System.out.println("");
        return;
    }
    List<String> values = new ArrayList<>();
    collectValues(root, values);
    Collections.sort(values, new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    });
    StringBuilder result = new StringBuilder();
    for (String value : values) {
        result.append(value);
    }
    System.out.println(result.toString());
}
    private void collectValues(Node node, List<String> values) {
        if (node == null) {
            return;
        }
        values.add(String.valueOf(node.value));
        collectValues(node.left, values);
        collectValues(node.right, values);
    }



//TODO Watchmen of Binary Tree
private static final int NOT_MONITORED = 0;
    private static final int MONITORED_WITHOUT_CAMERA = 1;
    private static final int MONITORED_WITH_CAMERA = 2;
    public int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int[] watchmen = new int[1];
        int rootState = postOrder(root, watchmen);
        if (rootState == NOT_MONITORED) {
            watchmen[0]++;
        }
        return watchmen[0];
    }
    private int postOrder(Node node, int[] watchmen) {
        if (node == null) {
            return MONITORED_WITHOUT_CAMERA;
        }
        int left = postOrder(node.left, watchmen);
        int right = postOrder(node.right, watchmen);
        if (left == NOT_MONITORED || right == NOT_MONITORED) {
            watchmen[0]++;
            return MONITORED_WITH_CAMERA;
        }
        if (left == MONITORED_WITH_CAMERA || right == MONITORED_WITH_CAMERA) {
            return MONITORED_WITHOUT_CAMERA;
        }
        return NOT_MONITORED;
    }


//TODO Peak Element
public int findPeakElement(List<Integer> nums) {
    int n = nums.size();
    if (n == 1) {
        return 0;
    }
    int greatestPeakIndex = -1;
    int greatestPeakValue = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        if ((i == 0 || nums.get(i) >= nums.get(i-1)) && (i == n - 1 || nums.get(i) >= nums.get(i+1))) {
            if (nums.get(i) > greatestPeakValue) {
                greatestPeakValue = nums.get(i);
                greatestPeakIndex = i;
            }
        }
    }
    return greatestPeakIndex;
}

//TODO Minimum Risk Path in a BST
private static int minDiff = Integer.MAX_VALUE;
    private static Integer prev = null;
    public int minimumRisk(Node root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.value - prev);
        }
        prev = root.value;
        inorder(root.right);
    }
    public Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.value) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

//TODO Three Numbers Product - Input is a BST
public static void inorder(Node root, List<Integer> nums) {
    if (root == null) return;
    inorder(root.left, nums);
    nums.add(root.value);
    inorder(root.right, nums);
}
    public static boolean findTarget(Node root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int n = nums.size();
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int product = nums.get(i) * nums.get(left) * nums.get(right);
                if (product == k) {
                    return true;
                } else if (product < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

//TODO Index of target

    public int findTargetPosition(Node root, int target) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderHelper(root, inOrderList);
        for (int i = 0; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) == target) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void inOrderHelper(Node root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, inOrderList);
        inOrderList.add(root.value);
        inOrderHelper(root.right, inOrderList);
    }



}








