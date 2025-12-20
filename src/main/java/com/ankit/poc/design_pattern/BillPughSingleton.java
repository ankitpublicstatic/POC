package com.ankit.poc.design_pattern;

public class BillPughSingleton {
  private BillPughSingleton() {

  }

  // Inner static helper class not loaded until getInstance() is called
  private static class SingletonHelper {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}
// ✅ Advantages:

// Lazy initialization (inner class loaded only when needed).

// Thread-safe (JVM class loader guarantees single initialization).

// No synchronization overhead.
