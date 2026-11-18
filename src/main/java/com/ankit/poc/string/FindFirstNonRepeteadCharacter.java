package com.ankit.poc.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindFirstNonRepeteadCharacter {
  public static void main(String[] args) {
    String value = "javacj";

    // Approach 1 without using collections
    for (int i = 0; i < value.length(); i++) {
      boolean unique = true;
      for (int j = 0; j < value.length(); j++) {
        if (i != j && value.charAt(i) == value.charAt(j)) {
          unique = false;
          break;
        }
      }
      if (unique) {
        System.out.println("First non repeated character : " + value.charAt(i));
        break;
      }
    }


    // Approach 2 using Map
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }
    System.out.println(map);
    for (Entry<Character, Integer> entrySet : map.entrySet()) {
      if (entrySet.getValue() == 1) {
        System.out.println("First non-repeated character : " + entrySet.getKey());
        break;
      }
    }
  }
}
