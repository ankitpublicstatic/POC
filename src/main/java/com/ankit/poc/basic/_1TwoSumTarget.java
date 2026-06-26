package com.ankit.poc.basic;

import java.util.Arrays;

public class _1TwoSumTarget {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSumTarget(new int[] {2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(twoSumTarget(new int[] {3, 2, 4}, 6)));
    System.out.println(Arrays.toString(twoSumTarget(new int[] {3, 3}, 6)));
    System.out.println(Arrays.toString(twoSumTarget(new int[] {1, 8, 2, 15, 5}, 13)));
    // [0, 1]
    // [1, 2]
    // [0, 1]

  }

  // O(n2) time complexity
  public static int[] twoSumTarget(int[] arr, int sum) {
    for (int i = 0; i < arr.length; i++) {
      int target = sum - arr[i];
      for (int j = 1; j < arr.length; j++) {
        if (target == arr[j]) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }
}
