package com.ankit.poc.abc1;
public class POC {

  // input = "AABBBCCDD";

  // output : ABBBCCDD, ABCCDD, ABCDD, ABCD

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder("AABBBCCDD");

    for (int i = 1; i < sb.length(); i++) {

      if (sb.charAt(i) == sb.charAt(i - 1)) {
        sb.deleteCharAt(i);
        System.out.println(sb);
        i = 0; // restart from beginning
      }
    }
  }
}
