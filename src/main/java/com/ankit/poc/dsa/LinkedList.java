package com.ankit.poc.dsa;

class Node {
  int data;
  Node next;
}


public class LinkedList {
  Node head;

  public void insert(int data) {
    Node node = new Node();
    node.data = data;
    node.next = null;

    if (head == null) {
      head = node;
    } else {
      Node n = head;
      while (n.next != null) {
        n = n.next;
      }
      n.next = node;
    }
  }

  public void insertAtStart(int data) {
    Node node = new Node();
    node.data = data;

    node.next = head;
    head = node;
  }

  public void insertAt(int index, int data) {
    if (index == 0) {
      insertAtStart(data);
    } else {
      Node node = new Node();
      node.data = data;
      node.next = null;
      Node n = head;
      for (int i = 0; i < index; i++) {
        n = n.next;
      }
      node.next = n.next;
      n.next = node;
    }
  }

  public void show() {
    Node node = head;
    while (node.next != null) {
      System.out.println(node.data);
      node = node.next;
    }
    System.out.println(node.data);
  }

  public void deleteAt(int index) {
    if (index == 0) {
      head = head.next;
    } else {
      Node n = head;
      for (int i = 0; i < index; i++) {
        n = n.next;
      }
      Node n1 = n.next;
      n.next = n1.next;
      // System.out.println("n1 " + n1.data);
      n1 = null;
    }
  }

  public void reverse() {
    Node prev = null;
    Node curr = head;
    while (curr != null) {
      Node next = curr.next; // Save next
      curr.next = prev; // Reverse link
      prev = curr; // Move previous
      curr = next; // Move current
    }
    head = prev;// New head

  }
}
