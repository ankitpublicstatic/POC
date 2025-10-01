package com.ankit.poc.dsa;

public class DynamicStack {
  int capacity = 2;
  int[] stack = new int[capacity];

  int top = 0;

  public void push(int data) {
    if (capacity == size()) {
      expandStack();
    }
    stack[top] = data;
    top++;
  }

  public void expandStack() {
    int length = size();
    int[] newStack = new int[capacity * 2];
    System.arraycopy(stack, 0, newStack, 0, length);
    stack = newStack;
    capacity = capacity * 2;
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
      if (size() <= capacity / 2 / 2) {
        shrink();
      }
      return data;
    }
    return 0;
  }

  private void shrink() {
    int length = size();
    if (length <= capacity / 2 / 2) {
      capacity = capacity / 2;
    }
    int[] newStack = new int[capacity];
    System.arraycopy(stack, 0, newStack, 0, length);
    stack = newStack;

  }

  public int peek() {
    return stack[top - 1];
  }

  public int size() {
    return top;
  }

}
