package com.ankit.poc.leetcode;

public class PatternGenerator {
  public static void main(String[] args) {
    int n = 4; // You can change input here

    StringBuilder result = new StringBuilder();

    // Loop from n down to 1
    for (int i = n; i >= 1; i--) {
      int repeatCount = n - i + 1; // repetition increases step by step
      for (int j = 0; j < repeatCount; j++) {
        result.append(i);
      }
    }

    System.out.println("Input: " + n);
    System.out.println("Output: " + result.toString());
  }
}
