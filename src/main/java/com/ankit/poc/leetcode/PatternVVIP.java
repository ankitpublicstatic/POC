package com.ankit.poc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PatternVVIP {
  // public static void main(String[] args) {
  // printRepeatCount(4);
  // moveZero(new int[] {1, 0, 1, 0, 3, 12});
  // targetOfSum(new int[] {4, 2, 6, 3, 7, 8}, 10);
  // }
  public static void main(String[] args) {
    int[] nums = {3, 4, 6, 7, 8, 2};
    int target = 10;
    Map<Integer, Integer> indexMap = new HashMap<>();
    System.out.println("Initial Array: " + Arrays.toString(nums));

    for (int i = 0; i < nums.length; i++) {
      int number = target - nums[i];
      if (indexMap.containsKey(number)) {
        System.out.print("[" + i + ", " + indexMap.get(number) + "], ");
        System.out.println("[" + nums[i] + ", " + number + "]");
      }
      indexMap.put(nums[i], i);
    }

  }

  public static void moveZero(int[] nums) {
    System.out.println("Initial Array: " + Arrays.toString(nums));
    int insertPosition = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[insertPosition++] = num;
      }
    }
    while (insertPosition < nums.length) {
      nums[insertPosition++] = 0;
    }
    System.out.println("After move 0 to last in array: " + Arrays.toString(nums));
  }

  public static void printRepeatCount(int n) {
    // Input: 4
    // Output: 4332221111
    StringBuilder result = new StringBuilder();

    // Loop from n down to 1
    for (int i = n; i >= 1; i--) {
      int repeatCount = n - i + 1; // repetition increase step by step
      for (int j = 0; j < repeatCount; j++) {
        result.append(i);
      }
    }
    System.out.println("Input: " + n);
    System.out.println("Output: " + result.toString());
  }

  public static void targetOfSum(int[] nums, int target) {
    System.out.println("Array is: " + Arrays.toString(nums) + " Target is: " + target);

    Map<Integer, Integer> valueIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (valueIndex.containsKey(key)) {
        System.out.println("Index: [" + i + ", " + valueIndex.get(key) + "], Value: [" + nums[i]
            + ", " + key + "]");
      }
      valueIndex.put(nums[i], i);
    }
  }
}
