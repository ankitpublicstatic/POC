package com.ankit.poc.string;

public class ReplaceSpecialCharacters {
  public static void main(String[] args) {

    String value = "$ja!va$&st%ar";
    String value2 = "\"Pr!ogra#am%m*in&g Lan?#guag(e\"";

    String replace = value.replaceAll("[^a-zA-Z0-9]", "");
    System.out.println(replace);

    String replace2 = value2.replaceAll("[^a-zA-Z0-9]", "");
    System.out.println(replace2);

    // RemoveAllWhiteSpace
    value = "  j  a  v  a lan  g";
    System.out.println(value.replaceAll("\\s", ""));
  }
}
