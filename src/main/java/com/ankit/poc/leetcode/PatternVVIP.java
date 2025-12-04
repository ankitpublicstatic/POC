package com.ankit.poc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PatternVVIP {
  public static void main(String[] args) {
    printRepeatCount(4);
    moveZero(new int[] {1, 0, 1, 0, 3, 12});
    targetOfSum(new int[] {4, 2, 6, 3, 7, 8}, 10);
  }

  // Input 1 : tesst > test
  // output : tet
  //
  // Input 2 : tesset > teet > tt >
  // output :
  //
  // Input 3 : test
  // output : test


  public static String removeRepetativeCharacter(String input) {
    StringBuilder stack = new StringBuilder();

    for (char c : input.toCharArray()) {
      int len = stack.length();
      if (len > 0 && stack.charAt(len - 1) == c) {
        // Remove the adjacent duplicate
        stack.deleteCharAt(len - 1);
      } else {
        stack.append(c);
      }
    }

    return stack.toString();
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
