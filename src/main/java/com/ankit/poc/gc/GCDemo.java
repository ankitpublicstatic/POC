package com.ankit.poc.gc;

public class GCDemo {
  public static void main(String[] args) {
    for (int i = 0; i < 10_000_000; i++) {
      byte[] n = new byte[1024]; // allocate 1KB repeatedly
      n = null;
    }

    System.out.println("Requesting GC...");
    System.gc(); // may trigger Full GC
  }
}
