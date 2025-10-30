package com.ankit.poc.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.ankit.poc.StaticData;

public class Java8QA {
  public static List<Student> studentList = StaticData.studentList;

  public static void main(String[] args) {
    // Integer id, String name, Integer rank, Integer age, String gender, String dept,
    // String city, List<String> contacts;

    List<Student> studentRank =
        studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
            .collect(Collectors.toList());
    // System.out.println(studentRank);

    List<Student> studentCity =
        studentList.stream().filter(student -> "Pune".equalsIgnoreCase(student.getCity()))
            .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
            .collect(Collectors.toList());
    // System.out.println(studentCity);

    List<String> departmentList = studentList.stream().map(student -> student.getDept()).distinct()
        .collect(Collectors.toList());
    // System.out.println(departmentList);

    Set<String> departmentSet = studentList.stream().map(Student::getDept)
        .sorted(Collections.reverseOrder()).collect(Collectors.toSet());
    // System.out.println(departmentSet);

    // studentList.stream().collect(Collectors.groupingByConcurrent(Student::getContacts),
    // Collectors.mapping(Student::getContacts, Collectors.toList()));

    List<String> contactList =
        studentList.stream().flatMap(x -> x.getContacts().stream()).collect(Collectors.toList());
    // one2one -> map()
    // one2many -> flatMap()
    // System.out.println(contactList);
    Map<String, List<Student>> departmentMap =
        studentList.stream().collect(Collectors.groupingBy(x -> x.getDept()));
    // System.out.println(departmentMap);
    Map<String, Long> deptCount = studentList.stream()
        .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
    // System.out.println(deptCount);

    Entry<String, Long> maxCountDepartment =
        studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    // System.out.println(maxCountDepartment);

    Map<String, Double> averageAgeByGender = studentList.stream().collect(
        Collectors.groupingBy(x -> x.getGender(), Collectors.averagingInt(Student::getAge)));
    // System.out.println(averageAgeByGender);

    Map<String, Optional<Student>> maxRankByDepartMent = studentList.stream().collect(Collectors
        .groupingBy(Student::getDept, Collectors.maxBy(Comparator.comparing(Student::getRank))));
    // System.out.println(maxRankByDepartMent);
    Map<String, Optional<Student>> minRantByDepartment = studentList.stream().collect(Collectors
        .groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getRank))));
    // System.out.println(minRantByDepartment);


    Student student = studentList.stream()
        .sorted(Collections.reverseOrder(Comparator.comparing(Student::getRank)))
        .collect(Collectors.toList()).get(1);
    studentList.stream().sorted(Collections.reverseOrder(Comparator.comparing(Student::getAge)))
        .collect(Collectors.toList()).get(1);


    // System.out.println(student);
    Student student2 = studentList.stream()
        .sorted(Collections.reverseOrder(Comparator.comparing(Student::getRank))).skip(1)
        .findFirst().get();
    System.out.println(student2);
  }
}
