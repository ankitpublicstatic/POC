// Write a program to find Length of the smallest sub-string consisting of maximum distinct
// characters
//
// Input : "AABBBCBB"
//
// Output : 5
//
// Input : "AABBBCBBAC"
//
// Output : 3

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    String input = "AABBBCBBAC";

    System.out.println(findSmallestSubstring(input));
  }

  public static int findSmallestSubstring(String str) {
    // Step 1: Find total distinct characters
    Set<Character> distinctSet = new HashSet<>();
    for (char ch : str.toCharArray()) {
      distinctSet.add(ch);
    }
    int totalDistinct = distinctSet.size();
    // Step 2: Sliding window
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int minLength = Integer.MAX_VALUE;

    for (int end = 0; end < str.length(); end++) {
      char endChar = str.charAt(end);
      map.put(endChar, map.getOrDefault(endChar, 0) + 1);

      // If window contains all distinct characters
      while (map.size() == totalDistinct) {
        minLength = Math.min(minLength, end - start + 1);
        char startChar = str.charAt(start);
        map.put(startChar, map.get(startChar) - 1);
        // Remove if frequency becomes 0
        if (map.get(startChar) == 0) {
          map.remove(startChar);
        }
        start++;
      }
    }
    return minLength;
  }
}
