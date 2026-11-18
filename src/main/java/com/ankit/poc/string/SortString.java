package com.ankit.poc.string;

import java.util.Arrays;

public class SortString {
  // 1. without using sort method
  // 2. Using sort method
  public static void main(String[] args) {
    // Approach 1. without using sort method
    String value = "java";
    char[] charArray = value.toCharArray();

    for (int i = 0; i < value.length(); i++) {
      for (int j = i + 1; j < value.length(); j++) {
        if (charArray[i] > charArray[j]) {
          char temp = charArray[i];
          charArray[i] = charArray[j];
          charArray[j] = temp;
        }
      }
    }
    System.out.println(new String(charArray));


    // Approach 2. using sort method
    Arrays.sort(charArray);
    System.out.println(new String(charArray));
  }
}
