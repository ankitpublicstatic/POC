package com.ankit.poc.inner_class;

// Non static inner class real world use for iterator class
public class MyList {
  private int[] data = {1, 2, 3};

  class MyIterator {
    int index = 0;

    boolean hasNext() {
      return index < data.length;
    }
  }
}


// static nested inner class POC
class Outer {

  static int x = 10;

  static class Inner {
    void show() {
      System.out.println(x);
    }
  }

  public static void main(String[] args) {
    Outer.Inner = new Outer.Inner();
  }
}
// No outer instance required.
// ✔ No this$0 reference
// ✔ Lighter and safer
// 🔹 Rules
//
// ✔ Can access only static members of outer class
// ✔ Can have static fields/methods
// ✔ No memory leak risk
// ✔ Loosely coupled
