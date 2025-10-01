package com.ankit.poc.logical.programming;

public class LargestOf3Numbers {
	public static void main(String[] args) {
		int a = 4, b = 1, c = 9;

		// Approach 1 simple
//		if ((a > b) && (a > c)) {
//			System.out.println("a is largest : " + a);
//		} else if ((b > a) && (b > c)) {
//			System.out.println("b is largest : " + b);
//		} else {
//			System.out.println("c is largest : " + c);
//		}

		// Approach 2 Ternary operator
		int largest = a > b ? a : b;

		largest = c > largest ? c : largest;
		System.out.println("Largest is " + largest);

		int large = c > (a > b ? a : b) ? c : (a > b ? a : b);
		System.out.println("Largest is " + large);
	}
}
