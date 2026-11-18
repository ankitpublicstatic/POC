package com.ankit.poc.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateChars {
  public static void main(String[] args) {
    // 1. Using java 8
    // 2. Using indexOf()
    // 3. Using Character array
    // 4. Using set interface method

    String value = "programming";

    // Approach 1 java 8
    StringBuilder sb = new StringBuilder();
    value.chars().distinct().forEach(c -> sb.append((char) c));
    System.out.println(sb);

    // Approach 2 indexOf()

    StringBuilder sbIndexOff = new StringBuilder();
    for (int i = 0; i < value.length(); i++) {

      int indexOf = value.indexOf(value.charAt(i), i + 1);
      if (indexOf == -1) {
        sbIndexOff.append(value.charAt(i));
      }
    }

    System.out.println(sbIndexOff);


    // Approach 3 Character array
    StringBuilder sbCharArray = new StringBuilder();
    char[] charArray = value.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      boolean reapted = false;
      for (int j = i + 1; j < charArray.length; j++) {
        if (charArray[i] == charArray[j]) {
          reapted = true;
          break;
        }
      }

      if (!reapted) {
        sbCharArray.append(charArray[i]);
      }
    }

    System.out.println(sbCharArray);


    // Approach 4 Set interface method
    StringBuilder sbSetInterface = new StringBuilder();
    Set<Character> setChar = new LinkedHashSet<>();

    for (char c : value.toCharArray()) {
      setChar.add(c);
    }

    setChar.forEach(ch -> sbSetInterface.append(ch));
    System.out.println(sbSetInterface);
  }
}
