package com.ankit.poc.logical.programming;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {
	public static void main(String[] args) {

		String test = "A O K B Z Z A A S S J";
		char[] charArray = test.toCharArray();

		List<String> charList = Arrays.stream(test.split("")).collect(Collectors.toList());

		System.out.println(charList);
//		for (int i = 0; i > charArray.length; i++) {
//			if (!charList.contains(charArray[i])) {
//
//			}
//		}
		LinkedHashMap<String, Long> countMap = Arrays.stream(test.split(""))
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));

		for (String key : countMap.keySet()) {
			if (countMap.get(key) == 1) {
				System.out.println(key);
				break;
			}
		}

//	select id, name, sal, rownum r from emp Where rownum = 3 order by sal desc;
	}

}
