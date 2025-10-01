package com.ankit.poc.problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCombinations {
  public static List<int[]> findCombinations(int[] arr, int target) {
    List<int[]> pairs = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();

    for (int num : arr) {
      int complement = target - num;
      if (seen.contains(complement)) {
        pairs.add(new int[] {complement, num});
      }
      seen.add(num);
    }

    return pairs;
  }

  public static void main(String[] args) {
    int[] arr = {2, 9, 1, 7, 3, 8, 5, 6, 4};
    int target = 10;
    List<int[]> result = findCombinations(arr, target);

    System.out.println("Pairs summing to 10:");
    for (int[] pair : result) {
      System.out.println(Arrays.toString(pair));
    }
  }
  // All pairs that sum to 10: [[1, 9], [3, 7], [2, 8], [4, 6]]
  // Pairs summing to 10:
  // [9, 1]
  // [7, 3]
  // [2, 8]
  // [6, 4]
}
