package com.ankit.poc.dsa;

import java.util.Arrays;

public class SearchTimeComplexity {

  public static void pairSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {

        if (nums[i] + nums[j] == target) {
          System.out.println(nums[i] + ", " + nums[j]);
        }
      }
    }
  }

  public static void main(String[] args) {
    // SearchTimeComplexity.pairSum(new int[] {3, 1, 5, 6, 4, 2}, 7);
    int[] nums = {2, 3, 5, 9, 11, 18};
    int target = 18;
    int index = SearchTimeComplexity.binaryRecursiveSearch(nums, target, 0, nums.length - 1);
    if (index == -1) {
      System.out.println("Element not found");
    } else {
      System.out.println("Array is : " + Arrays.toString(nums));
      System.out.println("Element found on Index : " + index + ", Value is : " + nums[index]);
    }
  }

  // Time Complexity = O(n)
  public static int linnearSearch(int[] nums, int target) {
    int steps = 0;
    for (int i = 0; i < nums.length; i++) {
      steps++;
      if (nums[i] == target) {
        System.out.println("Steps taken in Linnear Search : " + steps);
        return i;
      }
    }
    return -1;
  }

  // Time Complexity = O(log n)
  public static int binarySearch(int[] nums, int target) {
    // 2 , 3 , 5, 9, 11, 18
    int left = 0;
    int right = nums.length - 1;
    int steps = 0;
    while (left <= right) {
      steps++;
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        System.out.println("Steps taken in Binary Search : " + steps);
        return mid;
      } else if (nums[mid] < target) { // 5 < 11 :
        left = mid + 1;
      } else if (nums[mid] > target) { // 5 > 11
        right = mid - 1;
      }
    }
    return -1;
  }

  // Time Complexity = O(log n) / O(1)
  public static int binaryRecursiveSearch(int[] nums, int target, int left, int right) {
    int steps = 0;
    while (left <= right) {
      steps++;
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        System.out.println("Steps taken in Binary Recursive Search : " + steps);
        return mid;
      } else if (nums[mid] < target) {
        return binaryRecursiveSearch(nums, target, mid + 1, right);
      } else if (nums[mid] > target) { // 5 > 2
        return binaryRecursiveSearch(nums, target, left, mid - 1);
      }
    }
    return -1;
  }

  public void getSum() {
    //
    // Scanner scn = new Scanner(System.in); // used to take the input
    //
    // System.out.println("Enter the number:");
    // int n = scn.nextInt(); // reads the input
    int n = 5;
    StringBuilder output = new StringBuilder();
    for (int i = n; i >= 1; i--) {
      int repeatCount = n - i + 1; // repetition increases step by step
      for (int j = 0; j < repeatCount; j++) {
        output.append(i);
      }
    }
    System.out.println("Output is " + output.toString());
  }
}
