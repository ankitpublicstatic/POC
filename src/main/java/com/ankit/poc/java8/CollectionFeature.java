package com.ankit.poc.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionFeature {
  public static void main(String[] args) {
    // 1 Collections.nCopies

    List<String> nCopies = Collections.nCopies(5, "ankit");// It gives immutable list
    // System.out.println(nCopies);

    // List.of() method will give immutable list set map so we can't write on this collection, only
    // we can perform read operation on .of() method
    List<Integer> numbers = List.of(3, 2, 35, 54, 65, 2, 2, 2);

    // 2 Collections.frequency
    int frequency = Collections.frequency(numbers, 2);
    // System.out.println("number 2 presents : " + frequency);

    // find occurrence of each element in given list
    Map<Integer, Integer> collect = numbers.stream().collect(Collectors.toMap(num -> num,
        num -> Collections.frequency(numbers, num), (existingValue, newValue) -> existingValue));

    numbers.stream().collect(Collectors.toMap(num2 -> num2,
        num -> Collections.frequency(numbers, num), (existingValue, newValue) -> existingValue));
    // System.out.println(collect);

    // Collections.disjoint(nCopies, numbers)

    List<Integer> list1 = new ArrayList<>();
    Collections.addAll(list1, 1, 2, 3, 4, 5);

    List<Integer> list2 = new ArrayList<>();
    Collections.addAll(list2, 2, 3, 4, 5, 6, 7);

    boolean disjoint = Collections.disjoint(list1, list2);
    if (disjoint) {
      // System.out.println("The list have common value");
    } else {
      // System.out.println("The list have no common value");
    }

    // Collections.singleton()

    Set<String> singleton = Collections.singleton("ankit");
    try {
      // singleton.add("ram");

    } catch (UnsupportedOperationException e) {
      // System.out.println(e.getMessage());
      // System.out.println("Set is immutable, it can't be modify.");
    }
    // Collections.rotate(list2, frequency);
    List<Integer> listNumbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

    System.out.println("original " + listNumbers);
    Collections.rotate(listNumbers, -5);
    System.out.println("-5 " + listNumbers);
    Collections.rotate(listNumbers, listNumbers.size());
    System.out.println("listRotate.size( )" + listNumbers);
    Collections.rotate(listNumbers, -15);
    System.out.println("-15 " + listNumbers);


  }
}
