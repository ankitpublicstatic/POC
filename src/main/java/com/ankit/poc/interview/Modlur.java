package com.ankit.poc.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Modlur {
  public static void main(String[] args) {
    String[] A = {"01-2021"};
    String[] B = {"03-2021"};
    int[] C = {100};

    System.out.println(solution("The Codility Coders Test", "Codility tests the codes of coders"));
    System.out.println(findMinimumRequiredIncome(A, B, C));
  }

  public static int findMaximumNumberOfPointPresentInsideCircleCount(String str, int[] X, int[] Y) {
    int N = str.length();
    List<long[]> points = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      long dist = 1L * X[i] * X[i] + 1L * Y[i] * Y[i];
      points.add(new long[] {dist, str.charAt(i)});
    }

    // sort by distance
    points.sort(Comparator.comparingLong(a -> a[0]));

    Set<Character> used = new HashSet<>();
    int count = 0, i = 0;
    while (i < N) {
      int j = i;
      long dist = points.get(j)[0];
      Set<Character> levelTags = new HashSet<>();
      // collect same-distance points
      while (j < N && points.get(j)[0] == dist) {
        char tag = (char) points.get(j)[1];
        // duplicate inside same distance level
        if (levelTags.contains(tag)) {
          return count;
        }
        // tag already used earlier
        if (used.contains(tag)) {
          return count;
        }
        levelTags.add(tag);
        j++;
      }
      // include this level
      used.addAll(levelTags);
      count += levelTags.size();
      i = j;
    }

    return count;
  }

  public static String solution(String dictionary, String message) {
    // Convert dictionary to lowercase set for fast lookup

    Set<String> dictionarySet = Arrays.stream(dictionary.split(" ")).map(str -> str.toLowerCase())
        .collect(Collectors.toSet());
    // Split message into words
    String[] words = message.split(" ");

    // Process each word
    for (int i = 0; i < words.length; i++) {
      String lowerWord = words[i].toLowerCase();
      if (!dictionarySet.contains(lowerWord)) {
        words[i] = "###";
      }
    }
    // Rebuild sentence
    return String.join(" ", words);
  }

  public static int findMinimumRequiredIncome(String[] A, String[] B, int[] C) {

    Map<Integer, Long> montlyExpense = new HashMap<>();
    int startMonth = Integer.MAX_VALUE;
    int endMonth = Integer.MIN_VALUE;

    // Build monthly expenses
    for (int i = 0; i < A.length; i++) {
      int start = toMonth(A[i]);
      int end = toMonth(B[i]);

      startMonth = Math.min(startMonth, start);
      endMonth = Math.max(endMonth, end);

      for (int m = start; m <= end; m++) {
        montlyExpense.put(m, montlyExpense.getOrDefault(m, 0L) + C[i]);
      }
    }

    long prefixSum = 0;// total expenses till now
    int monthCount = 0; // number of month passed
    long minRequiredIncome = 0;

    // month by month calculation
    for (int m = startMonth; m <= endMonth; m++) {
      monthCount++;
      prefixSum += montlyExpense.getOrDefault(m, 0L);
      long requiredIncome = (prefixSum + monthCount - 1) / monthCount;// ceil division
      minRequiredIncome = Math.max(minRequiredIncome, requiredIncome);
    }
    return (int) minRequiredIncome;
  }

  public static int toMonth(String date) {
    String[] monthYear = date.split("-");
    int month = Integer.parseInt(monthYear[0]);
    int year = Integer.parseInt(monthYear[1]);
    return year * 12 + month - 1;
  }
}
