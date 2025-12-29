package com.ankit.poc.inner_class;

class Outer {
  private int x = 10;

  class Inner {
    void show() {
      System.out.println(x);
    }
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    inner.show();
  }
}
// What JVM Actually Does
// Inner gets a hidden reference to Outer
// Bytecode roughly becomes:


class Inner {
  final Outer this$0;// synthentic field

  Inner(Outer outer) {
    this.this$0 = outer;
  }
}
// Every inner object carries its outer object
// 🔹 Key Rules

// ✔ Can access private members of outer class
// ✔ Cannot have static members
// ✔ Requires outer instance to exist
// ✔ Causes tight coupling
