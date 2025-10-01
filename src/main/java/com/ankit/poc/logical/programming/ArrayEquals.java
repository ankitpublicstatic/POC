package com.ankit.poc.logical.programming;

import java.util.Arrays;

public class ArrayEquals {
	public static void main(String[] args) {
		int a1[] = { 1, 2, 3, 4, 5, 6 };
		int a2[] = { 1, 2, 3, 4, 5, 6 };

		boolean status = Arrays.equals(a1, a2);

		if (status) {
			System.out.println(status + " Arrays are equals");
		} else {
			System.out.println(status + " Arrays are not equals");
		}

		status = true;

		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {
				if (a1[i] != a2[i]) {
					status = false;
					break;
				}
			}
		} else {
			System.out.println(status + " Arrays are not equals");

		}

		if (status) {
			System.out.println(status + " Arrays are equals");
		} else {
			System.out.println(status + " Arrays are not equals");
		}
	}
}
