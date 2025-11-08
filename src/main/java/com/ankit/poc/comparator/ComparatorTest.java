package com.ankit.poc.comparator;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.ankit.poc.StaticData;
import com.ankit.poc.java8.Student;

public class ComparatorTest {

  public static void main(String[] args) {
    List<Student> studentList = StaticData.studentList;

    Comparator<Student> nameComparator = (student1, student2) -> {
      if (student1.getId() == student2.getId()) {
        return student1.getName().compareTo(student2.getName());
      } else if (student1.getId() > student2.getId()) {
        return 1;
      } else {
        return -1;
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
