package com.ankit.poc.logical.programming;

public class ThreadTest extends Thread {
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println(
				"My new Thread " + Thread.currentThread().getId() + " Name: " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		threadTest.start();
		threadTest.setPriority(MAX_PRIORITY);
	}
}
