package com.ankit.poc.dsa;
import java.util.*;

public class ComplexityComparison {

  // O(n²) method: nested loops
  public static void pairSumQuadratic(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          // Do nothing, just simulate work
        }
      }
    }
  }

  // O(n) method: using HashSet
  public static void pairSumLinear(int[] nums, int target) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
      int complement = target - num;
      if (seen.contains(complement)) {
        // Do nothing, just simulate work
      }
      seen.add(num);
    }
  }

  public static void main(String[] args) {
    int[] sizes = {1_000, 5_000, 10_000, 20_000};
    int target = 100;

    for (int n : sizes) {
      // Prepare an array of size n with random values
      int[] nums = new int[n];
      Random rand = new Random();
      for (int i = 0; i < n; i++) {
        nums[i] = rand.nextInt(100);
      }

      // Measure O(n²)
      long start = System.nanoTime();
      pairSumQuadratic(nums, target);
      long end = System.nanoTime();
      long quadraticTime = end - start;

      // Measure O(n)
      start = System.nanoTime();
      pairSumLinear(nums, target);
      end = System.nanoTime();
      long linearTime = end - start;

      System.out.printf(
        "Array size: %d -> O(n²): %.2f ms | O(n): %.2f ms%n",
        n, quadraticTime / 1_000_000.0, linearTime / 1_000_000.0
      );
    }
  }
}
