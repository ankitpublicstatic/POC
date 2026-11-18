package com.ankit.poc.java_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.ankit.poc.StaticData;
import com.ankit.poc.java8.Student;

public class Java8StreamHandling {

  public static void main(String[] args) {
    List<Student> studentList = StaticData.getAllStudentsRank();

    // 1. Find the list of students whose rank is in between 50 and 100

    List<Student> students =
        studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
            .collect(Collectors.toList());
    // System.out.println(students);

    // 2. Find the Students who stays in Karnataka and sort them by their names

    List<Student> studentsByCity =
        studentList.stream().filter(student -> "Karnataka".equals(student.getCity()))
            .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
            .collect(Collectors.toList());
    // System.out.println(studentsByCity);

    // 3. Find all departments names

    List<String> deptNames =
        studentList.stream().map(Student::getDept).distinct().collect(Collectors.toList());

    Set<String> deptNamesInSet =
        studentList.stream().map(Student::getDept).collect(Collectors.toSet());

    // System.out.println(deptNames);
    // System.out.println(deptNamesInSet);

    // 4. Find all the contact numbers
    List<String> contacts = studentList.stream().flatMap(student -> student.getContacts().stream())
        .distinct().collect(Collectors.toList());
    System.out.println(contacts);
    // one2one-> map
    // one2many-> flatmap

    // 5. Group The Student By Department Names


    Map<String, List<Student>> studentMap =
        studentList.stream().collect(Collectors.groupingBy(Student::getDept));
    // System.out.println(studentMap);


    // 6. Find the department who is having maximum number of students
    Map.Entry<String, Long> results =
        studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue()).get();

    System.out.println(results);

    // 7. Find the average age of male and female students

    Map<String, Double> avgStudents = studentList.stream().collect(
        Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

    // System.out.println(avgStudents);

    // 8. Find the highest rank in each department

    Map<String, Optional<Student>> stdMap = studentList.stream().collect(Collectors
        .groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getRank))));
    // System.out.println(stdMap);

    // 9 .Find the student who has second rank

    Student student = studentList.stream().sorted(Comparator.comparing(Student::getRank)).skip(2)
        .findFirst().get();
    System.out.println(student);

  }


}
