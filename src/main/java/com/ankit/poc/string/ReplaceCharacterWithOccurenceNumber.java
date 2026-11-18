package com.ankit.poc.string;

public class ReplaceCharacterWithOccurenceNumber {
  public static void main(String[] args) {
    String value = "javaaaaaaaaaaaaaaaaaaaaaaa";
    char charReplace = 'a';

    // Check given character is available in string or not
    if (value.indexOf(charReplace) == -1) {
      System.out.println("Given character is not available in String");
      System.exit(0);
    }

    // Find and replace with occurrence

    // Approach 1
    // it won't work after 9 occurrence

    // char[] charArray = value.toCharArray();
    // int count = 1;
    // for (int i = 0; i < charArray.length; i++) {
    // char ch = charArray[i];
    // if (ch == charReplace) {
    // charArray[i] = String.valueOf(count).charAt(0);
    // count++;
    // }
    // }

    // System.out.println(Arrays.toString(charArray));

    // Approach 2
    int count = 1;
    for (int i = 0; i < value.length(); i++) {
      if (value.charAt(i) == charReplace) {
        value = value.replaceFirst(String.valueOf(charReplace), String.valueOf(count));
        count++;
      }
    }
    System.out.println(value);
  }
}
