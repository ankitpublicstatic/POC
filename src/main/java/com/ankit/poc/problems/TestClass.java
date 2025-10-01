package com.ankit.poc.problems;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class TestClass implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getId() > o2.getId()) {
			return 1;
		} else if (o1.getId() < o2.getId()) {
			return -1;
		} else {
			return o1.getName().compareTo(o2.getName());
		}
	}

	private static IntPredicate evenCondition = x -> (x % 2) == 0;
	private static IntPredicate oddCondition = x -> (x % 2) != 0;

	private static Object object = new Object();

	private static void execute(int i) {
		synchronized (object) {

			try {
				System.out.println("Thread name: " + Thread.currentThread().getName() + ", Number: " + i);
				object.notify();
				object.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printNumber(IntPredicate condition) {
		IntStream.rangeClosed(1, 10).filter(condition).forEach(TestClass::execute);
	}

	public static void main(String[] args) {
//		List<Employee> employees = new ArrayList<>();
//		employees.add(new Employee(101, "Ankit Kumar", "IT"));
//		employees.add(new Employee(102, "Ram Kumar", "IT"));
//		employees.add(new Employee(101, "Ankit Kumar", "IT"));
		CompletableFuture.runAsync(() -> TestClass.printNumber(oddCondition));
		CompletableFuture.runAsync(() -> TestClass.printNumber(evenCondition));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
