package com.ankit.poc.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import com.ankit.poc.Test;
import com.ankit.poc.java8.Java8QA;
import com.ankit.poc.java8.Student;

public class FindNthSalaryList {
  public static void main(String[] args) {

    List<Student> studentList = Java8QA.studentList;

    System.out.println(FindNthSalaryList.findNthByIndex(studentList, 2));


  }

  public static Entry<Integer, List<String>> findDynamciNthHighestSalary(int index,
      Map<String, Integer> map) {
    return map.entrySet().stream()
        .collect(Collectors.groupingBy(Map.Entry::getValue,
            Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
        .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
        .collect(Collectors.toList()).get(index - 1);
  }

  public static Object findNthBy(List<Student> studentList, Integer n) {
    return studentList.stream().filter(emp -> emp.getRank() != null)
        .sorted(Collections.reverseOrder(Comparator.comparing(Student::getRank)))
        .collect(Collectors.toList()).get(n - 1);
  }

  public static Object findNthByIndex(List<Student> studentList, Integer n) {
    return studentList.stream().filter(x -> x.getRank() != null)
        .collect(Collectors.groupingBy(Student::getRank,
            Collectors.mapping(x -> x, Collectors.toList())))
        .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
        .collect(Collectors.toList()).get(n - 1);
  }
}
