package com.ankit.poc.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FailFastExample {
  public static void main(String[] args) {

    // protected transient int modCount = 0;
    List<String> names = new ArrayList<>();
    names.add("Ankit");
    names.add("Vaishnavi");
    names.add("Abhishek");

    // Create an iterator
    Iterator<String> iterator = names.iterator();

    while (iterator.hasNext()) {
      String name = iterator.next();
      System.out.println(name);
      if ("ankit".equalsIgnoreCase(name)) {
        names.add("ram"); // ❌ ConcurrentModificationException
        // if (modCount != expectedModCount)
        // throw new ConcurrentModificationException();

        iterator.remove();// ✅ Safe
      }

    }
    Set<Integer> numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    for (Integer num : numbers) {
      if (num == 2) {
        numbers.remove(num); // ❌ ConcurrentModificationException
      }
    }
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "ankit");
    map.put(2, "ram");

    for (Integer key : map.keySet()) {
      if (key == 1) {
        map.put(3, "sita"); // ❌ ConcurrentModificationException
      }
    }

    new Thread(() -> names.add("sita")).start();

    new Thread(() -> {
      for (String name : names) {
        System.out.println(name);
      }
    }).start();

    // This can throw ConcurrentModificationException.
    // Or, worse, show unpredictable results (depending on timing).
  }
}
