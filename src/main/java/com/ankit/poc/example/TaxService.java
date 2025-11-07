package com.ankit.poc.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

  public static List<Employee> evaluateTaxUsers(String input) {
    return "tax".equalsIgnoreCase(input)
        ? DataBase.getEmployees().stream().filter(emp -> emp.getSalary() > 500000)
            .collect(Collectors.toList())
        : DataBase.getEmployees().stream().filter(emp -> emp.getSalary() <= 500000)
            .collect(Collectors.toList());

  }

  public static void main(String[] args) {
    System.out.println(evaluateTaxUsers("tax"));
  }
}
