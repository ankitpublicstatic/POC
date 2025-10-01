package com.ankit.poc.logical.programming;

import java.util.Scanner;

public class ReverseNumber {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a Number: ");

    int num = sc.nextInt();

    // 1. Using algorithm
    int rev = 0;

    while (num != 0) {
      rev = rev * 10 + num % 10; // 0*10 + 1234%10 = 4, 4*10 + 123%10 = 43, 43*10 + 12%10 = 432,
                                 // 432*10 + 1/10 = 4321
      num = num / 10; // 1234/10 = 123, 123/10 = 12, 12/10=1, 1/10 = 0
    }



    // 2. Using String buffer class
    StringBuilder rev1;
    StringBuilder sb = new StringBuilder(String.valueOf(num));
    rev1 = sb.reverse();

    // 3. Using String builder class
    StringBuilder sbl = new StringBuilder(String.valueOf(num));
    StringBuilder rev2 = sbl.reverse();
    System.out.println("Rev Number is : " + rev2.toString());
  }
}
