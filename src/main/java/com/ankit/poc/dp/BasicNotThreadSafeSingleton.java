package com.ankit.poc.dp;

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
