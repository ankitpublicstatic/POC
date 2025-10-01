package com.ankit.poc.logical.programming;

public class StringCompare {
	public static void main(String[] args) {
		String s1 = "Ankit";
		String s2 = new String(s1);
		System.out.println((" == " + s1) == s2);
		System.out.println("equals " + s1.equals(s2));
		System.out.println("intern " + s1.intern().equals(s2.intern()));
	}
}
