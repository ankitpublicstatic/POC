package com.ankit.poc.string;

public class ReverseWord {
  public static void main(String[] args) {
    String value = "java documents";
    System.out.println("Original String: " + value);
    String[] words = value.split(" ");
    StringBuilder reverseOutput = new StringBuilder();
    for (String word : words) {
      StringBuilder revWord = new StringBuilder();
      for (int i = word.length() - 1; i >= 0; i--) {
        revWord.append(word.charAt(i));
      }
      reverseOutput.append(" ").append(revWord.toString());
    }
    System.out.println("Reversed String: " + reverseOutput.toString());
  }
}
