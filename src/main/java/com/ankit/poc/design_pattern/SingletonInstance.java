package com.ankit.poc.design_pattern;

public class SingletonInstance {
  private static SingletonInstance instance;

  private SingletonInstance() {
    // Private constructor to prevent external instantiation
  }

  public SingletonInstance getInstance() {
    synchronized (instance) {
      if (instance == null) {
        instance = new SingletonInstance();
        return instance;
      } else {
        return instance;
      }
    }
  }
}
