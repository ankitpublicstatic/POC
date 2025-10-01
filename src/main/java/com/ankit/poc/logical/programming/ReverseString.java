package com.ankit.poc.logical.programming;

public class ReverseString {
	public static void main(String[] args) {
		// 1. String concatenation operator
		String val = "Java";
		String rev = "";
		/*
		 * for(int i = val.length()-1;i>=0;i--) { rev = rev+val.charAt(i); }
		 */

		/*
		 * char[] charArray = val.toCharArray(); for(int i =
		 * charArray.length-1;i>=0;i--) { rev = rev + charArray[i]; }
		 */

		StringBuilder sb = new StringBuilder(val);
		rev = sb.reverse().toString();
		System.out.println(rev);
	}
}
