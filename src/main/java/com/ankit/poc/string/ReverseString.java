package com.ankit.poc.string;

public class ReverseString {

  // Using toCharArray() method
  // Using charAt(int index) method
  // Using java.lang.StringBuilder class provide reverse() method
  // Using java.lang.StringBuffer class provide reverse() method
  //


  public static void main(String[] args) {
    String value = "ankit";


    // Approach 1
    char[] chars = value.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      System.out.print(chars[i]);
    }
    System.out.println();

    // Approach2
    for (int i = value.length() - 1; i >= 0; i--) {
      System.out.print(value.charAt(i));
    }

    System.out.println();

    // Approach3
    StringBuilder sb = new StringBuilder(value);
    StringBuffer sf = new StringBuffer(value);
    System.out.println(sb.reverse());
    System.out.println(sf.reverse());
  }
}
