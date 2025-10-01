package com.ankit.poc.logical.programming;

import java.util.Scanner;

public class PalindromeString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a String: ");
    String value = scanner.next();

    String rev = "";

    for (int i = value.length() - 1; i >= 0; i--) {
      rev = rev + value.charAt(i);
    }

    if (value.equals(rev)) {
      System.out.println(rev + " is Palindrome String");
    } else {
      System.out.println(rev + " is not Palindrome String");
    }
  }
}
