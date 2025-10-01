package com.ankit.poc.logical.programming;

public class FactorialNumber {
	public static void main(String[] args) {
		int num = 5, factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial = factorial * i;
		}
		System.out.println(factorial + " Factorial of number is : " + num);
		factorial = 1;
		for (int i = num; i >= 1; i--) {
			factorial = factorial * i;
		}
		System.out.println(factorial + " Factorial of number is : " + num);
	}
}
