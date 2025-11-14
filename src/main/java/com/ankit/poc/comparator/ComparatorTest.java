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
        return student1.getName().compareToIgnoreCase(student2.getName());
      } else if (student1.getId() > student2.getId()) {
        return 1;
      } else {
        return -1;
      }
    };
    Collections.sort(studentList, nameComparator);
    System.out.println(studentList);
    System.out.println(factorial(3));
    moveZeros(new int[] {1, 0, 1, 0, 3, 6, 12});
    System.out.println();
  }

  public static long factorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public static int[] moveZeros(int[] nums) {
    int lastInsertPosition = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[lastInsertPosition++] = num;
      }
    }
    while (lastInsertPosition < nums.length) {
      nums[lastInsertPosition++] = 0;
    }
    return nums;
  }

  public static BigInteger factorialBigInt(int n) {
    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}
