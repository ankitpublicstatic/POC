// Write a program to find Length of the smallest sub-string consisting of maximum distinct
// characters
//
// Input : "AABBBCBB"
//
// Output : 5
//
// Input : "AABBBCBBAC"
//
// Output : 3
package com.ankit.poc.abc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    System.out.println(findSmallestSubstring("AABBBCBBAC"));
  }

  public static void removeDuplicate() {
    StringBuilder builder = new StringBuilder("AABBBCCDD");

    for (int i = 1; i < builder.length(); i++) {
      if (builder.charAt(i) == builder.charAt(i - 1)) {
        builder.deleteCharAt(i);
        if ("ABBCCDD".equalsIgnoreCase(builder.toString())) {

        } else {
          System.out.println(builder);
        }
        i = 1;
      }
    }
  }

  public static int findSmallestSubstring(String str) {
    // Step 1: Find total distinct characters
    Set<Character> distinctSet = new HashSet<>();
    for (char ch : str.toCharArray()) {
      distinctSet.add(ch);
    }
    int totalDistinct = distinctSet.size();
    // Step 2: Sliding window
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int minLength = Integer.MAX_VALUE;

    for (int end = 0; end < str.length(); end++) {
      char endChar = str.charAt(end);
      map.put(endChar, map.getOrDefault(endChar, 0) + 1);

      // If window contains all distinct characters
      while (map.size() == totalDistinct) {
        minLength = Math.min(minLength, end - start + 1);
        char startChar = str.charAt(start);
        map.put(startChar, map.get(startChar) - 1);
        // Remove if frequency becomes 0
        if (map.get(startChar) == 0) {
          map.remove(startChar);
        }
        start++;
      }
    }
    return minLength;
  }
}
