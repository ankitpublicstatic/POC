package com.ankit.poc.leetcode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OverlapingTest {
  public static void main(String[] args) {
    List<String> list =
        Arrays.asList("Chennai", "Bangalore", "Chennai", "Hyderabad", "Bangalore", "Hyderabad");
    // find second duplicate element from the list
    System.out.println(findDuplicateByIndex(list, 2));

    // "TESTDEMOTESTDEMO" "DEMO"
    System.out.println(countOverlaping("AAAA", "AA", false));
  }

  public static Entry<String, Long> findDuplicateByIndex(List<String> list, int index) {
    return list.stream()
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toList())
        .get(index - 1);
  }
  // 🎯 Explanation (How to think about the problem?)Step-by-step thought process:

  // You need to check how many times "DEMO" appears inside a bigger string.

  // A substring can be searched using indexOf. Every time you find one occurrence, increase the
  // count.

  // Move the index forward to continue searching.

  // Continue until no more substring is found (indexOf returns -1).

  public static int countOverlapingByReplace(String str, String sub) {
    return (str.length() - str.replace(sub, "").length()) / sub.length();
  }

  public static int countOverlaping(String str, String sub, boolean allowOverlap) {

    if (str == null || sub == null || sub.isEmpty()) {
      return 0;
    }
    int count = 0, index = 0;

    while ((index = str.indexOf(sub, index)) != -1) {
      count++;
      index = index + (allowOverlap ? 1 : sub.length());
    }
    return count;
  }

  public static int countOverlapingByRegex(String str, String sub) {
    int count = 0;
    Matcher matcher = Pattern.compile(sub).matcher(str);
    while (matcher.find()) {
      count++;
    }
    return count;
  }


  // EMP
  //
  // NAME ID MANAGERID
  //
  // RAKESH 1
  //
  // ABHISHEK 2 1
  //
  // PRAKASH 3 2
  //
  // MANJU 4 3
  //
  // SHINATH 5 2
  //
  // Get employees and their manager names ?
  //
  // select e.name as employee_name, e.name as manager_name from emp e
  // left join emp r on e.managerid = r.id;
  //

  // public static void main(String[] args) {
  // System.out.println(solution("The Codility Coders Test", "Codility tests the codes of coders"));
  // }

  public String solution(String dictionary, String message) {
    // Implement your solution here

    // Convert dictionary to lowercase set for fast lookup
    Set<String> dictionarySet = new HashSet<>();
    for (String word : dictionary.split(" ")) {
      dictionarySet.add(word.toLowerCase());
    }

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
}
