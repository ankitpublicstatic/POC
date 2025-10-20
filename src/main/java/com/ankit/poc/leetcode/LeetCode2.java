package com.ankit.poc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2 {
  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {

    }
  }

  // 212 word-search-ii

  char[][] fullboard = null;
  ArrayList<String> answer = new ArrayList<>();

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;
      for (Character letter : word.toCharArray()) {
        if (node.children.containsKey(letter)) {
          node = node.children.get(letter);
        } else {
          TrieNode newNode = new TrieNode();
          node.children.put(letter, newNode);
          node = newNode;
        }
      }
      node.word = word;
    }
    this.fullboard = board;

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (root.children.containsKey(board[row][col])) {
          backTracking(row, col, root);
        }
      }
    }
    return answer;

  }

  private void backTracking(int row, int col, TrieNode parent) {
    Character letter = fullboard[row][col];
    TrieNode currNode = parent.children.get(letter);

    if (currNode.word != null) {
      this.answer.add(currNode.word);
      currNode.word = null;
    }
    fullboard[row][col] = '#';

    int[] rowoffset = {-1, 0, 1, 0};
    int[] coloffset = {0, 1, 0, -1};

    for (int i = 0; i < 4; i++) {
      int newRow = row + rowoffset[i];
      int newCol = col + coloffset[i];

      if (newRow < 0 || newCol < 0 || newRow >= fullboard.length || newCol >= fullboard[0].length) {
        continue;
      }

      if (currNode.children.containsKey(fullboard[newRow][newCol])) {
        backTracking(newRow, newCol, currNode);
      }
    }
    fullboard[row][col] = letter;

    if (currNode.children.isEmpty()) {
      parent.children.remove(letter);
    }
  }
}
