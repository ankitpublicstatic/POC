package com.ankit.poc.design_pattern;

public class BillPushSingleton {
  private BillPushSingleton() {

  }

  // Inner static helper class not loaded until getInstance() is called
  private static class SingletonHelper {
    private static final BillPushSingleton INSTANCE = new BillPushSingleton();
  }

  public static BillPushSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}
// ✅ Advantages:

// Lazy initialization (inner class loaded only when needed).

// Thread-safe (JVM class loader guarantees single initialization).

// No synchronization overhead.
