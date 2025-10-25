package com.ankit.poc.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindNthSalaryMap {
  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>();
    map.put("ankit", 1000);
    map.put("ram", 1200);
    map.put("sita", 7865);
    map.put("janak", 1300);
    map.put("laxman", 9832);
    map.put("dev", 1600);
    map.put("danav", 1800);

    Map<String, Integer> map2 = new HashMap<>();
    map2.put("ankit", 1000);
    map2.put("ram", 1200);
    map2.put("sita", 1900);
    map2.put("janak", 1300);
    map2.put("laxman", 1900);
    map2.put("dev", 1600);
    map2.put("danav", 1800);

    Entry<Integer, List<String>> entry = findDynamciNthHighestSalary(1, map);

    System.out.println(entry);

    Entry<Integer, List<String>> entry2 = findDynamciNthHighestSalary(1, map2);
    System.out.println(entry2);
  }

  public static Entry<Integer, List<String>> findDynamciNthHighestSalary(int index,
      Map<String, Integer> map) {
    return map.entrySet().stream()
        .collect(Collectors.groupingBy(Map.Entry::getValue,
            Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
        .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
        .collect(Collectors.toList()).get(index - 1);
  }

  public static Entry<String, Integer> findHighestNthSalary(int index, Map<String, Integer> map) {
    return map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toList()).get(index - 1);
  }
}
