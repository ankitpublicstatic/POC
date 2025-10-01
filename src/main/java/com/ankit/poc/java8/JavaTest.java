package com.ankit.poc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaTest {
  public static void main(String[] args) {
    String value = "abcdefghabaac";

    List<String> valList = Arrays.stream(value.split("")).collect(Collectors.toList());
    List<String> result = new ArrayList<>();
    for (String val : valList) {
      if (!result.contains(val)) {
        result.add(val);

      }
    }
    result.stream().map(x -> x).forEach(System.out::print);
  }
}
