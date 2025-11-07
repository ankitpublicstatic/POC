package com.ankit.poc.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}


public class BinaryTree {
  Node root;

  public void insert(int data) {
    root = insertRecursion(root, data);
  }

  private Node insertRecursion(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }
    if (data < root.data) {
      root.left = insertRecursion(root.left, data);
    } else if (data > root.data) {
      root.right = insertRecursion(root.right, data);
    }
    return root;
  }

  // ✅ In-order traversal (Left → Root → Right)
  public void showInOrder() {
    inOrderRecursion(root);
    System.out.println();
  }

  // ✅ In-order traversal (Left → Root → Right)
  private void inOrderRecursion(Node root) {
    if (root != null) {
      inOrderRecursion(root.left);
      System.out.print(root.data + " ");
      inOrderRecursion(root.right);
    }
  }

  // ✅ Pre-order traversal (Root → Left → Right)
  public void showPreOrder() {
    preOrderRecursion(root);
    System.out.println();
  }

  // ✅ Pre-order traversal (Root → Left → Right)
  private void preOrderRecursion(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preOrderRecursion(root.left);
      preOrderRecursion(root.right);
    }
  }

  // ✅ Post-order traversal (Left → Right → Root)
  public void showPostOrder() {
    postOrderRecursion(root);
    System.out.println();
  }

  // ✅ Post-order traversal (Left → Right → Root)
  private void postOrderRecursion(Node root) {
    if (root != null) {
      postOrderRecursion(root.left);
      postOrderRecursion(root.right);
      System.out.print(root.data + " ");
    }
  }


  // ✅ Level-order traversal (Breadth-First Search)
  public void showLevelOrder() {
    System.out.print("Level-order: ");
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      System.out.print(current.data);

      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    System.err.println();
  }

  // ✅ Search node
  public boolean search(int data) {
    return searchRecursion(root, data);
  }

  private boolean searchRecursion(Node root, int data) {
    if (root == null) {
      return false;
    }
    if (root.data == data) {
      return true;
    }
    return data < root.data ? searchRecursion(root.left, data) : searchRecursion(root.right, data);
  }

  // ✅ Find minimum value
  public int findMin() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty");
    }
    Node current = root;
    while (current.left != null) {
      current = current.left;
    }
    return current.data;
  }

  // ✅ Find maximum value
  public void name() {
    if (root == null) {

    }
  }

  // ✅ Main method for testing
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    tree.insert(3);
    tree.insert(7);
    tree.insert(2);
    tree.insert(4);
    tree.insert(6);
    tree.insert(8);
    // In-order: 2 3 4 5 6 7 8
    // Pre-order: 5 3 2 4 7 6 8
    // Post-order: 2 4 3 6 8 7 5
    System.out.print("In-order: ");
    tree.showInOrder(); // 2 3 4 5 6 7 8

    System.out.print("Pre-order: ");
    tree.showPreOrder(); // 5 3 2 4 7 6 8

    System.out.print("Post-order: ");
    tree.showPostOrder(); // 2 4 3 6 8 7 5
  }
}
