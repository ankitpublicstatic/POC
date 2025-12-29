package com.ankit.poc.inner_class;

public class BillPhugSingletonClass {
  private BillPhugSingletonClass() {
    // Private constructor to prevent object creation outside
  }

  private static class HelperClass {
    private static final BillPhugSingletonClass INSTANCE = new BillPhugSingletonClass();
  }

  public BillPhugSingletonClass getInstance() {
    return HelperClass.INSTANCE;
  }
}
