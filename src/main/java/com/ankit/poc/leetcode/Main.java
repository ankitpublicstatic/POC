package com.ankit.poc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    System.out.println(hasPathagorenTriplets(new int[] {1, 2, 3, 4, 5}, 5));
    System.out.println(reduceDuplicateRepetative("tesset"));
  }

  ExecutorService es = Executors.newFixedThreadPool(50);
  Semaphore sem = new Semaphore(40); // limit concurrency

  public CompletableFuture<String> callLLM(String payload) {
    if (!sem.tryAcquire()) {
      return CompletableFuture.failedFuture(new RejectedExecutionException("too many LLM calls"));
    }
    return CompletableFuture.supplyAsync(() -> {
      try {
        return llmClient.call(payload);
      } finally {
        sem.release();
      }
    }, es).orTimeout(5, TimeUnit.SECONDS);
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      count[c - 'a']--;
    }
    for (int i : count) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }

  public static String reduceDuplicateRepetative(String input) {
    StringBuilder stack = new StringBuilder();
    for (char c : input.toCharArray()) {
      int len = stack.length();
      if (len > 0 && stack.charAt(len - 1) == c) {
        stack.deleteCharAt(len - 1);
      } else {
        stack.append(c);
      }
    }
    return stack.toString();
  }

  public static void findMaxCount() {
    int[] nums = {2, 4, 5, 2, 4, 3, 6, 4, 2};

    Entry<Integer, Long> maxCountEntry = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() > 1).findFirst().get();
    System.out.println("Array: " + Arrays.toString(nums));
    System.out.printf("Number = %d%n Maximum comes %d time.", maxCountEntry.getKey(),
        maxCountEntry.getValue());
  }

  private static boolean hasPathagorenTriplets(int[] arr, int n) {
    // square all value
    for (int i = 0; i < n; i++) {
      arr[i] = (int) Math.sqrt(arr[i]);
    }
    // sort
    Arrays.sort(arr);
    // check
    for (int i = n - 1; i >= 2; i--) {
      int left = 0, right = i - 1;
      while (left < right) {
        if (arr[left] + arr[right] == arr[i]) {
          return true;
        }
        if (arr[left] + arr[right] < arr[i]) {
          left++;
        } else {
          right--;
        }
      }
    }
    for (int i = n - 1; i >= 2; i--) {
      int left = 0, right = i - 1;
      while (left < right) {

      }
    }
    return false;
  }


  public static void targetSum() {
    int[] nums = {3, 4, 6, 7, 8, 2};
    int target = 10;
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int number = target - nums[i];
      if (indexMap.containsKey(number)) {
        System.out.print("[" + i + ", " + indexMap.get(number) + "], ");
        System.out.println("[" + nums[i] + ", " + number + "]");
      }
      indexMap.put(nums[i], i);
    }
  }

  public static void printRepeatedPattern(int n) {
    for (int i = n; i >= 1; i--) {
      int repetedValue = n - i + 1;
      for (int j = 0; j < repetedValue; j++) {
        System.out.print(i);
      }
    }
  }

  public static void moveZero() {
    int[] nums = {3, 0, 1, 0, 8, 0};
    int insertPos = 0;

    for (int i : nums) {
      if (i != 0) {
        nums[insertPos++] = i;
      }
    }
    while (insertPos < nums.length) {
      nums[insertPos++] = 0;
    }
    System.out.println(Arrays.toString(nums));
  }
}
