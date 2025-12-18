import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    System.out.println(solution("The Codility Coders Test", "Codility tests the codes of coders"));
  }

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
