package com.ankit.poc.logical.programming;

public class SumOfArray {

	public static void main(String[] args) {
		int a[] = { 2, 3, 2, 1, 1, 3 };
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		System.out.println(sum);
		sum = 0;
		for (int val : a) {
			sum = sum + val;
		}
		System.out.println(sum);
	}

}
