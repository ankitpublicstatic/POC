package com.ankit.poc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ankit.poc.java8.Student;

public class Test {
  public static void main(String[] args) {

    List<Student> studentList = Stream.of(
        new Student(2, "ankit", 87, 23, "M", "IT", "Begusarai",
            Arrays.asList("788456465465", "894132654654")),
        new Student(2, "sonam", 45, 23, "F", "HR", "Pune", Arrays.asList("78678678", "4878778788")),
        new Student(2, "leena", 98, 23, "M", "IT", "Delhi",
            Arrays.asList("457878784545", "457875")),
        new Student(2, "suraj", 98, 23, "M", "IT", "Delhi",
            Arrays.asList("457878784545", "457875")),
        new Student(2, "mongia", 34, 23, "M", "IT", "Goa",
            Arrays.asList("5478877854445", "4587878")),
        new Student(2, "ram", 56, 23, "M", "IT", "Pune", Arrays.asList("4545454545", "854454545")),
        new Student(2, "sita", 99, 23, "M", "HR", "Dehu", Arrays.asList("454545", "4545454545")),
        new Student(2, "getta", 65, 23, "M", "BD", "Guhati",
            Arrays.asList("1224878787", "87787878")),
        new Student(2, "hena", 43, 23, "M", "BD", "Asam",
            Arrays.asList("7787833264", "8778787844")),
        new Student(2, "suresh", 33, 28, "M", "IT", "Bangluru",
            Arrays.asList("4477833233", "47878111")),
        new Student(2, "shri", 43, 23, "M", "HR", "Mumbai",
            Arrays.asList("4457878778", "877821211")),
        new Student(2, "akshay", 82, 22, "M", "IT", "Katak",
            Arrays.asList("78785332", "7878454454")))
        .collect(Collectors.toList());
    System.out.println(Test.findNthByIndex(studentList, 2));


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
