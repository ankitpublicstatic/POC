package com.ankit.poc.comparator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ankit.poc.java8.Student;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Student> studentList = Stream.of(
				new Student(32, "ankit", 87, 23, "M", "IT", "Begusarai", Arrays.asList("788456465465", "894132654654")),
				new Student(22, "sonam", 45, 23, "F", "HR", "Pune", Arrays.asList("78678678", "4878778788")),
				new Student(62, "leena", 98, 23, "M", "IT", "Delhi", Arrays.asList("457878784545", "457875")),
				new Student(12, "mongia", 34, 23, "M", "IT", "Goa", Arrays.asList("5478877854445", "4587878")),
				new Student(32, "ram", 56, 23, "M", "IT", "Pune", Arrays.asList("4545454545", "854454545")),
				new Student(92, "sita", 99, 23, "M", "HR", "Dehu", Arrays.asList("454545", "4545454545")),
				new Student(72, "getta", 65, 23, "M", "BD", "Guhati", Arrays.asList("1224878787", "87787878")),
				new Student(82, "hena", 43, 23, "M", "BD", "Asam", Arrays.asList("7787833264", "8778787844")),
				new Student(42, "suresh", 33, 28, "M", "IT", "Bangluru", Arrays.asList("4477833233", "47878111")),
				new Student(2, "shri", 43, 23, "M", "HR", "Mumbai", Arrays.asList("4457878778", "877821211")),
				new Student(1, "akshay", 82, 22, "M", "IT", "Katak", Arrays.asList("78785332", "7878454454")))
				.collect(Collectors.toList());
		
		
		Comparator<Student> nameComparator = new Comparator<Student>() {
		    @Override
			public int compare(Student student1, Student student2) {
		    	 if (student1.getId() == student2.getId()) {
		    	      return student1.getName().compareTo(student2.getName());
		    	    } else if (student1.getId() > student2.getId()) {
		    	      return 1;
		    	    } else {
		    	      return -1;
		    	    }
		    }
		};

		Collections.sort(studentList, nameComparator);
		System.out.println(studentList);
		System.out.println(factorial(5));
	}

	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static BigInteger factorialBigInt(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
