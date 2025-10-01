package com.ankit.poc.logical.programming;

public class CountSumOfDigits {
	public static void main(String[] args) {
		int sum = 0;
		int num = 123456789;
		while (num > 0) {
			sum = sum + (num % 10);
			num = num / 10;

		}
		System.out.println("Total sum: " + sum);
	}
}
