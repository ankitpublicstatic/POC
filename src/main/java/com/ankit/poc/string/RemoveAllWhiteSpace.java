package com.ankit.poc.string;

public class RemoveAllWhiteSpace {
  public static void main(String[] args) {
    String value = "  j  a  v  a lan  g";
    System.out.println(value.replaceAll("\\s", ""));
  }
}
