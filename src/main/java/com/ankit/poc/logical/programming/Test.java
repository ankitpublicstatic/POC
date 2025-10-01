package com.ankit.poc.logical.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();

		numbers.add(-3);
		numbers.add(-2);
		numbers.add(-1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		Map<Boolean, List<Integer>> segrigateNumbersMap = numbers.stream()
				.collect(Collectors.partitioningBy(x -> x > 0));
		System.out.println(segrigateNumbersMap);
		numbers.stream().filter(x -> (x % 2) != 0).map(x -> x * x).collect(Collectors.counting());
	}
}
