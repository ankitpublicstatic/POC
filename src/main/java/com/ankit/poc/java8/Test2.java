package com.ankit.poc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;

@Data
public class Test2 {

  public static void main(String[] args) {
    String s = "ABA";


    Arrays.stream(s.split("")).sorted(Collections.reverseOrder()).collect(Collectors.toList());
    // id,type; : officer

    List<Employee> empList = new ArrayList<>();

    Set<Employee> empFilteredByType = empList.stream()
        .filter(emp -> "Officer".equalsIgnoreCase(emp.getType()) || emp.getType() == null)
        .collect(Collectors.toSet());
    List<Integer> numbers = new ArrayList<>();
    numbers.add(23);
    numbers.add(43);
    numbers.add(67);
    numbers.add(33);
    numbers.add(9);
    numbers.add(99);

    Collections.sort(numbers);
    System.out.println("Smallest number from given list :" + numbers.get(1)
        + ", Largest number from given list: " + numbers.get(numbers.size() - 2));

    IntStream numbersIntStream = IntStream.rangeClosed(1, 10);
    int sum = numbersIntStream.filter(i -> i % 2 == 0).sum();
    System.out.println("Total sum: " + sum);

    // name,designation,dob;
    // @Query(value ="",nativeQuery=true )
    // List<Employee> employees = empRepo.findAllByDesignationAndDobBetween(String designation, Date
    // dob1, Date dob2);
  }

}
