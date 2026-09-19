package com.ankit.poc.abc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given an array of integers, find all unique triplets [a, b, c] such that a + b + c = 0. The array
// may contain duplicates, but your output should not contain duplicate triplets.
// Example:
// Input: [-1, 0, 1, 2, -1, -4]
// Output: [[-1, -1, 2], [-1, 0, 1]]
public class Test {
  public static void main(String[] args) {
    Set<int[]> sumOfTriplets = findSumOfTriplets(new int[] {-1, 0, 1, 2, -1, -4}, 0);
    for (int[] arr : sumOfTriplets) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public static Set<int[]> findSumOfTriplets(int[] arr, int sum) {

    Set<int[]> set = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            set.add(new int[] {arr[i], arr[j], arr[k]});
          }
        }
      }

    }
    return set;
  }
}
