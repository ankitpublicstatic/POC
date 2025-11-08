package com.ankit.poc.design_pattern;

public class BasicNotThreadSafeSingleton {
  private static BasicNotThreadSafeSingleton instance;

  private BasicNotThreadSafeSingleton() {
    // Private constructor to prevent external instantiation
  }

  public static BasicNotThreadSafeSingleton getInstance() {
    if (instance == null) {
      instance = new BasicNotThreadSafeSingleton();
    }
    return instance;
  }
}
// ❌ Problem:
// If two threads call getInstance() at the same time, they might both create a new instance →
// violating the Singleton rule.
