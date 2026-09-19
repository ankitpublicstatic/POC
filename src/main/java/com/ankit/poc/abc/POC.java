package com.ankit.poc.abc;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class POC {
  public static void main(String[] args) {
    // StringBuilder stringBuilder1 = new StringBuilder("abc");
    //
    // StringBuilder stringBuilder2 = new StringBuilder("abc");
    //
    // System.out.println(stringBuilder1.equals(stringBuilder2));
    //
    //
    // System.out.println(stringBuilder1.hashCode() == stringBuilder2.hashCode());

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 1, 6, 3);

    List<Integer> duplicate = numbers.stream()
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey())
        .collect(Collectors.toList());
    System.out.println(duplicate);

  }
}
