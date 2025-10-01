package com.ankit.poc.leetcode;

import java.util.Arrays;

public class ProductExceptSelfDebug {

  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, 1);

    int pre = 1, post = 1;

    for (int i = 0; i < n; i++) {
      int j = n - 1 - i; // index from the right

      // Apply prefix product
      result[i] *= pre;
      pre *= nums[i];

      // Apply postfix product
      result[j] *= post;
      post *= nums[j];

      // Debug output
      System.out.printf("Step %d:%n  pre=%d, post=%d%n  result=%s%n", i + 1, pre, post,
          Arrays.toString(result));
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int[] output = productExceptSelf(nums);
    System.out.println("Final result: " + Arrays.toString(output));
    // Expected: [24, 12, 8, 6]
  }
}
