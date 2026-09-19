package com.ankit.poc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoDArrayHandling {

  public static void main(String[] args) {
    int[][] arr2d = new int[][] {};

    arr2d[0] = new int[] { 2, 3, 4 };
    arr2d[1] = new int[] { 4, 5, 6 };
    arr2d[2] = new int[] { 7, 8, 9 };

    // int[][] sumOfTriplets = findSumOfTriplets2(new int[] { -1, 0, 1, 2, -1, -4 },
    // 0);
    // for (int[] arr : sumOfTriplets) {
    // System.out.println(Arrays.toString(arr));
    // }
  }

  public static int[][] findSumOfTriplets2(int[] arr, int sum) {

    Set<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            set.add(Arrays.asList(arr[i], arr[j], arr[k]));
          }
        }
      }

    }
    return set.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
  }

  public static int[][] findSumOfTriplets(int[] arr, int sum) {

    Set<int[]> set = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            set.add(new int[] { arr[i], arr[j], arr[k] });
          }
        }
      }

    }
    return set.toArray(new int[0][]);
  }
}
