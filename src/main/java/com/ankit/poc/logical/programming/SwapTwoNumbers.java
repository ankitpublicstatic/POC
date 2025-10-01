package com.ankit.poc.logical.programming;

public class SwapTwoNumbers {
	public static void main(String[] args) {
		int a = 10, b = 20;
		/*
		 * int t =b; b = a; a=t;
		 */

		/*
		 * a=a+b; b = a-b; a = a-b;
		 */

		/*
		 * a = a*b; b = a/b; a = a/b;
		 */

		/*
		 * a = a^b; b = a^b; a = a^b;
		 */

		b = (a + b) - (a = b);
		System.out.println("a : " + a + " b : " + b);
	}
}
