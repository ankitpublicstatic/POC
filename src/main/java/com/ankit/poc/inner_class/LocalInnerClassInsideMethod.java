package com.ankit.poc.inner_class;

public class LocalInnerClassInsideMethod {
  void process() {
    class Validator {
      boolean isValid() {
        return true;
      }
    }
  }
}
// ✔ Scope limited to method
// ✔ Can access effectively final variables

// Use Case

// One-off helper logic

// Algorithm-specific behavior
