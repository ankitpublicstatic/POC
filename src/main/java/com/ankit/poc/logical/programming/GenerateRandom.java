package com.ankit.poc.logical.programming;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandom {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextDouble());
		System.out.println(random.nextInt(10));

		System.out.println(Math.random());
		System.out.println(RandomStringUtils.randomNumeric(4));
		System.out.println(RandomStringUtils.randomAlphabetic(5));
	}
}
