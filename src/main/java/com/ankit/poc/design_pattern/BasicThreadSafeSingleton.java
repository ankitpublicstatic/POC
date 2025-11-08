package com.ankit.poc.design_pattern;

public class BasicThreadSafeSingleton {
  private static BasicThreadSafeSingleton instance;

  private BasicThreadSafeSingleton() {
    // Private constructor to prevent instantiation
  }

  public static synchronized BasicThreadSafeSingleton getInstance() {
    if (instance == null) {
      instance = new BasicThreadSafeSingleton();
    }
    return instance;
  }
}
// ✅ Thread-safe but ⚠️ slow — synchronized makes every access serialized, even after the instance
// is created.
