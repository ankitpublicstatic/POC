package com.ankit.poc.design_pattern;

public enum EnumSingleton {
  INSTANCE;

  public void showMessage() {
    System.out.println("hello from Enum Singleton");
  }
}
// ✅ Why it’s perfect:

// Enum guarantees only one instance by JVM spec.
//
// Automatically thread-safe.
//
// Handles serialization & reflection attacks.

