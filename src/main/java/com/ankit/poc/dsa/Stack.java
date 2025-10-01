package com.ankit.poc.dsa;

public class Stack {
  int[] stack = new int[5];

  int top = 0;

  public void push(int data) {
    if (top == 5) {
      System.out.println("Stack is full");
    } else {
      stack[top] = data;
      top++;
    }
  }

  public void show() {
    for (int s : stack) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  public boolean isEmpty() {
    return top <= 0;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
    } else {
      top--;
      int data = stack[top];
      stack[top] = 0;
      return data;
    }
    return 0;
  }

  public int peek() {
    return stack[top - 1];
  }

  public int size() {
    return top;
  }

}
