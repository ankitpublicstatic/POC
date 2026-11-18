package com.ankit.poc.string.leetcode;

public class FindLastWordLength {
  public static void main(String[] args) {
    String value = " fly on the moon";
    value = value.trim();
    int count = 0;
    for (int i = value.length() - 1; i >= 0; i--) {
      if (value.charAt(i) != ' ') {
        count++;
      } else {
        break;
      }
    }
    System.out.println(count);
  }
}
