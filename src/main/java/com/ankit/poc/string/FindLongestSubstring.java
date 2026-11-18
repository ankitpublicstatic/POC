package com.ankit.poc.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindLongestSubstring {
  public static void main(String[] args) {
    String longestSubString = null;
    int longestSubStringSize = 0;
    String value = "java";
    char[] chArr = value.toCharArray();
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < chArr.length; i++) {
      char ch = chArr[i];
      if (!map.containsKey(ch)) {
        map.put(ch, i);
      } else {
        i = map.get(ch);
        map.clear();
      }

      if (map.size() > longestSubStringSize) {
        longestSubStringSize = map.size();
        longestSubString = map.keySet().toString();
      }
    }

    System.out.println(longestSubString);
    System.out.println(longestSubStringSize);

  }
}
