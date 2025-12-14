package com.ankit.poc.dsa;

import com.ankit.poc.dsa.tree.BinaryTree;

public class Runner {
  public static void main(String[] args) {
    Runner.testLinkedList();
  }

  public static void testLinkedList() {
    LinkedList list = new LinkedList();
    list.insert(8);
    list.insert(80);
    list.insert(9);
    list.insert(11);
    // list.insertAt(3, 25);
    list.reverse();
    list.show();
  }

  public static void testBinaryTree() {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.insert(3);
    binaryTree.insert(2);
    binaryTree.insert(7);
    binaryTree.insert(1);
    binaryTree.insert(9);
    binaryTree.showInOrder();
  }

  private static void testQueue() {
    Queue queue = new Queue();
    queue.enQueue(2);
    queue.enQueue(8);
    queue.enQueue(9);
    queue.enQueue(22);
    queue.enQueue(88);
    queue.enQueue(99);
    queue.enQueue(199);
    queue.show();
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());

    queue.show();
  }

  public static void testDynamicStack() {
    DynamicStack stack = new DynamicStack();
    stack.push(8);
    stack.show();
    stack.push(888);
    stack.show();
    stack.push(9);
    stack.show();
    stack.push(91);
    stack.show();
    stack.push(2);
    stack.show();
    stack.push(22);
    stack.show();
  }

  public static void testStack() {
    Stack stack = new Stack();
    stack.push(8);
    stack.show();
    stack.push(888);
    stack.show();
    stack.push(9);
    stack.show();
    stack.push(91);
    stack.show();
    stack.push(2);
    stack.show();
    stack.push(22);
    stack.show();


    // System.out.println(stack.pop());
    // stack.show();
    // System.out.println(stack.peek());
    // System.out.println("Size is " + stack.size());
  }

}
