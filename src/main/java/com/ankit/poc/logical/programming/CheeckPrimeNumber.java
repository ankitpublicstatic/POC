package com.ankit.poc.logical.programming;

public class CheeckPrimeNumber {

	public static void main(String[] args) {
		int num = 19, count = 0;
		if (num > 1) {
			for (int i = 1; i <= num; i++) {
				if ((num % i) == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.println("Number is prime.");
			} else {

				System.out.println("Number is not prime.");
			}
		} else {
			System.out.println("Number is not prime.");
		}

	}

}
