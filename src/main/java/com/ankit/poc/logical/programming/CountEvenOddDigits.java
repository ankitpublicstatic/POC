package com.ankit.poc.logical.programming;

public class CountEvenOddDigits {
	public static void main(String[] args) {
		int num = 3245349;
		int evenCount = 0;
		int oddCount = 0;
		while (num > 0) {
			int digit = num % 10;
			if ((digit % 2) == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
			num = num / 10;
		}
		System.out.println("Even count: " + evenCount + " Odd Count: " + oddCount);
	}
}
