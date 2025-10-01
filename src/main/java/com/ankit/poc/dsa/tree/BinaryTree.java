package com.ankit.poc.dsa.tree;

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

  public Node insertRecursion(Node root, int data) {
    if (root == null) {
      root = new Node(data);
    } else if (data < root.data) {
      root.left = insertRecursion(root.left, data);
    } else if (data > root.data) {
      root.right = insertRecursion(root.right, data);
    }
    return root;
  }

  public void showInOrder() {
    inOrderRecursion(root);
  }

  public void inOrderRecursion(Node root) {
    if (root != null) {
      inOrderRecursion(root.left);
      System.out.print(root.data + " ");
      inOrderRecursion(root.right);
    }
  }

  public void showPreOrder() {
    inOrderRecursion(root);
  }

  public void showPostOrder() {
    postOrderRecursion(root);
  }

  public void preOrderRecursion(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      inOrderRecursion(root.left);

      inOrderRecursion(root.right);
    }
  }

  public void postOrderRecursion(Node root) {
    if (root != null) {
      inOrderRecursion(root.right);
      System.out.print(root.data + " ");
      inOrderRecursion(root.left);
    }
  }

}
