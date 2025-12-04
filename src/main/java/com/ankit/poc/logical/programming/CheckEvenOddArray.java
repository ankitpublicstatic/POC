package com.ankit.poc.logical.programming;

public class CheckEvenOddArray {
  public static void main(String[] args) {
    int nums = 6;
    int[] num = {7, 4, 4, 8};
    int arr[] = {23, 43, 542, 293, 54, 98};
    for (int element : arr) {
      if (element % 2 == 0) {
        System.out.println("Number is even. :" + element);
      } else if (element != 0) {
        System.out.println("Number is odd. : " + element);
      }
    }
    for (int i : arr) {
      if (i % 2 == 0) {
        System.out.println("Number is even. :" + i);
      } else if (i != 0) {
        System.out.println("Number is odd. : " + i);
      }
    }
  }
}
