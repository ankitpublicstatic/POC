package com.ankit.poc.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
  // 211 design-add-and-search-words-data-structure
  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;

    public TrieNode() {

    }
  }
  class WordDictionary {
    TrieNode trieNode;

    public WordDictionary() {
      trieNode = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode node = trieNode;
      for (char ch : word.toCharArray()) {
        if (!node.children.containsKey(ch)) {
          node.children.put(ch, new TrieNode());
        }
        node = node.children.get(ch);
      }
      node.word = true;
    }

    public boolean searchNode(String word, TrieNode node) {
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (!node.children.containsKey(ch)) {
          if (ch == '.') {
            for (char x : node.children.keySet()) {
              TrieNode child = node.children.get(x);
              if (searchNode(word.substring(i + 1), child)) {
                return true;
              }
            }
          }
          return false;

        } else {
          node = node.children.get(ch);
        }

      }
      return node.word;
    }

    public boolean search(String word) {
      return searchNode(word, trieNode);
    }
  }
}
