package com.ankit.poc.design_pattern;

public class DoubleCheckedLokingSingleton {
  // volatile ensures changes are visible to all threads
  private static volatile DoubleCheckedLokingSingleton instance;

  private DoubleCheckedLokingSingleton() {

  }

  public static DoubleCheckedLokingSingleton getInstance() {
    if (instance == null) {// First check no locking
      synchronized (DoubleCheckedLokingSingleton.class) {
        if (instance == null) { // Second check with lock
          instance = new DoubleCheckedLokingSingleton();

        }
      }

    }
    return instance;
  }
}
// ✅ Why this is ideal:

// volatile prevents instruction reordering during object creation.
//
// Synchronization only happens on first initialization (performance gain).
//
// Fully thread-safe and lazy-loaded.
