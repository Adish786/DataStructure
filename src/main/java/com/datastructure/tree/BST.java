package com.datastructure.tree;

public class BST<T extends Comparable<T>> {
    private Node<T> root;
    //  public void insert(T node);
    //  public void deleteMethod(T node);
    //  public boolean search(T node);
    //  private Node<T> findMin(Node<T> node);
    //  private Node<T> deleteNode(Node<T> root, T node);
    //  public void inOrder();
    //  public void preOrder();
    //  public void postOrder();
    //  private void inOrderHelper(Node<T> p);
    //  private void preOrderHelper(Node<T> p);
    //  private void postOrderHelper(Node<T> p);
    // public BST();

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            Node<T> parent = null;
            while (current != null) {
                parent = current;
                if (value.compareTo(current.data) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            if (value.compareTo(parent.data) < 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }
    private Node<T> findMin(Node<T> node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    private Node<T> deleteNode(Node<T> root, T value) {
        if (root == null) {
            return root;
        }

        if (value.compareTo(root.data) < 0) {
            root.left = deleteNode(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node<T> temp = findMin(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    public void deleteMethod(T value) {
        root = deleteNode(root, value);
    }

    public boolean search(T value) {
        Node<T> current = root;
        while (current != null) {
            if (value.compareTo(current.data) == 0) {
                return true;
            } else if (value.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    private void inOrderHelper(Node<T> node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    public void inOrder() {
        inOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    public void preOrder() {
        preOrderHelper(root);
        System.out.println();
    }

    private void postOrderHelper(Node<T> node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void postOrder() {
        postOrderHelper(root);
        System.out.println();
    }
}
