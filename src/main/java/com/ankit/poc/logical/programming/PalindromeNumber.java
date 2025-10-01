package com.ankit.poc.logical.programming;

import java.util.Scanner;

public class PalindromeNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int num = sc.nextInt();

    int rev = 0;
    int orgNum = num;

    while (num != 0) {
      rev = rev * 10 + num % 10;
      num = num / 10;
    }

    if (orgNum == rev) {
      System.out.println(rev + " Number is Palindrome");
    } else {
      System.out.println(rev + "Number is not Palindrome");
    }
    System.out.println(rev);
  }
}
