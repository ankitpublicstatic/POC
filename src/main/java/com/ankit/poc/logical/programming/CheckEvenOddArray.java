package com.ankit.poc.logical.programming;

public class CheckEvenOddArray {
	public static void main(String[] args) {
		int arr[] = { 23, 43, 542, 293, 54, 98 };
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] % 2) == 0) {
				System.out.println("Number is even. :" + arr[i]);
			} else if (arr[i] != 0) {
				System.out.println("Number is odd. : " + arr[i]);
			}
		}
		for (int i : arr) {
			if ((i % 2) == 0) {
				System.out.println("Number is even. :" + i);
			} else if (i != 0) {
				System.out.println("Number is odd. : " + i);
			}
		}
	}
}
