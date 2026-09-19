package com.ankit.poc.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Data;

@Data
class Employee {
  private Long id;
  private String name;
  private String department;
  private double salary;
}


public class StreamTest {
  public static void main(String[] args) {
    List<Employee> employees = null;
    List<Employee> resuemployeeEarningGreaterThan10000 =
        employees.stream().filter(emp -> emp.getSalary() > 10000).toList();

    List<Employee> sortedEmployee =
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();

    List<Employee> sortedReversedEmployee = employees.stream()
        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
    // Sort by multiple fields
    employees.stream()
        .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getId))
        .toList();

    // Grouping
    Map<String, List<Employee>> depEmpl =
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

    Map<String, Long> count = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

    employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet()
        .stream().filter(x -> x.getValue() > 1).toList();

    // Highest salary per department
    Map<String, Optional<Employee>> collect =
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.maxBy(Comparator.comparing(Employee::getSalary))));


    Map<Long, Employee> mapEmployee =
        employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));

    // If duplicate IDs are possible:
    Map<Long, Employee> uniqueIdMap = employees.stream().collect(Collectors.toMap(Employee::getId,
        Function.identity(), (existing, replacement) -> replacement));
  }
}
