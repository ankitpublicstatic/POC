package com.ankit.poc.problems;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPairs {
  public static void main(String[] args) {
    int[] arr = {2, 9, 1, 7, 3, 8, 5, 6, 4};
    Set<Integer> seen = new HashSet<>();
    List<List<Integer>> pairs = new ArrayList<>();

    for (int num : arr) {
      int complement = 10 - num;
      if (seen.contains(complement)) {
        List<Integer> pair = new ArrayList<>();
        if (complement < num) {
          pair.add(complement);
          pair.add(num);
        } else {
          pair.add(num);
          pair.add(complement);
        }
        pairs.add(pair);
      }
      seen.add(num);
    }

    System.out.println("All pairs that sum to 10: " + pairs);
  }
}
