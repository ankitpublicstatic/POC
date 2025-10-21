package com.ankit.poc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LeetCode {
  // public static void main(String[] args) {
  // // int[] nums = new int[] {1, 2, 8, 5, 9, 4};
  //
  // int[] nums = new int[] {0, 1, 0, 3, 12};
  // // LeetCode.targetOfSum(nums, 13);
  // // System.out.println(Arrays.toString(LeetCode.productExceptSelfOneForLoop(nums)));
  // System.out.println(Arrays.toString(nums));
  // LeetCode.moveZeroes4(nums);
  // }


  public int[] twosum(int[] nums, int target) {
    HashMap<Integer, Integer> indexVauleMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      indexVauleMap.put(nums[i], i);
      if (indexVauleMap.containsKey(key)) {
        return new int[] {i, indexVauleMap.get(key)};
      }
    }
    return null;
  }

  public static void targetOfSum(int[] nums, int target) {
    HashMap<Integer, Integer> valueIndex = new HashMap<>();
    System.out.println("Array is: " + Arrays.toString(nums) + " Target is: " + target);
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (valueIndex.containsKey(key)) {
        System.out.println("Index: [" + i + ", " + valueIndex.get(key) + "], Value: [" + nums[i]
            + ", " + key + "]");
      }
      valueIndex.put(nums[i], i);
    }
  }

  public static int maxProfit(int[] prices) {
    int min = prices[0];
    int profit = 0;
    for (int element : prices) {
      if (element < min) {
        min = element;
      }
      profit = Math.max(profit, element - min);
    }
    return profit;
  }

  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> uniqueSet = new HashSet<>();
    for (int num : nums) {
      if (uniqueSet.contains(num)) {
        return true;
      }
      uniqueSet.add(num);
    }
    return false;
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    Arrays.fill(result, 1);
    int pre = 1, post = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = result[i] * pre;
      pre = nums[i] * pre;
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] = result[i] * post;
      post = nums[i] * post;
    }
    return result;
  }

  public static int[] productExceptSelfOneForLoop(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, 1);

    int pre = 1, post = 1;
    for (int i = 0; i < n; i++) {
      // Forward pass: build prefix products
      result[i] *= pre;
      pre *= nums[i];

      // Backward pass: build suffix products simultaneously
      int j = n - 1 - i; // index from the end
      result[j] *= post;
      post *= nums[j];
    }

    return result;
  }

  public static void moveZeroes1(int[] nums) {
    int insertPos = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[insertPos++] = num;
      }
    }
    while (insertPos < nums.length) {
      nums[insertPos++] = 0;
    }
  }



  public static void moveZeroes2(int[] nums) {
    int lastNonZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        // Swap if necessary
        if (i != lastNonZero) {
          int temp = nums[i];
          nums[i] = nums[lastNonZero];
          nums[lastNonZero] = temp;
        }
        lastNonZero++;
      }
    }
  }

  public static void moveZeroes(int[] nums) {
    int insertPos = 0;

    System.out.println("Initial array: " + Arrays.toString(nums));

    // 1️⃣ Move non-zero elements forward
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[insertPos] = nums[i];
        if (i != insertPos) { // Only print when movement happens
          System.out.printf("Moved nums[%d]=%d to position %d -> %s%n", i, nums[i], insertPos,
              Arrays.toString(nums));
        }
        insertPos++;
      }
    }

    // 2️⃣ Fill remaining positions with zeros
    while (insertPos < nums.length) {
      nums[insertPos] = 0;
      System.out.printf("Filled position %d with 0 -> %s%n", insertPos, Arrays.toString(nums));
      insertPos++;
    }

    System.out.println("Final result: " + Arrays.toString(nums));
  }

  public static void moveZeroes3(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - 1; j++) {
        if (nums[j] == 0 && nums[j + 1] != 0) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }

  public void moveZeroes41(int[] nums) {
    int lastNonZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != lastNonZero) {
          int temp = nums[i];
          nums[i] = nums[lastNonZero];
          nums[lastNonZero] = temp;
        }
        lastNonZero++;
      }
    }
    System.out.println(Arrays.toString(nums));
  }

  public static void moveZeroes4(int[] nums) {
    int lastNonZero = 0;
    System.out.println("Initial array: " + Arrays.toString(nums));

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != lastNonZero) {
          // Perform swap
          int temp = nums[i];
          nums[i] = nums[lastNonZero];
          nums[lastNonZero] = temp;

          System.out.printf("Swapped nums[%d]=%d with nums[%d]=%d -> %s%n", i, nums[lastNonZero],
              lastNonZero, nums[i], Arrays.toString(nums));
        } else {
          System.out.printf("Kept nums[%d]=%d in place -> %s%n", i, nums[i], Arrays.toString(nums));
        }
        lastNonZero++;
      }
    }

    System.out.println("Final result: " + Arrays.toString(nums));
  }

  public int maxSubArray(int[] nums) {
    int curSum = 0, maxSum = nums[0];
    for (int num : nums) {
      if (curSum < 0) {
        curSum = 0;
      }
      curSum = curSum + num;
      maxSum = Math.max(curSum, maxSum);
    }
    return maxSum;
  }

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int min = nums[0], max = nums[0], result = max;
    for (int i = 1; i < nums.length; i++) {
      int cur = nums[i];
      int temp = Math.max(cur, Math.max(max * cur, min * cur));
      min = Math.min(cur, Math.min(min * cur, max * cur));
      max = temp;
      result = Math.max(result, max);
    }
    return result;
  }

  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1, ans = nums[0];
    if (nums.length == 1) {
      return nums[0];
    }
    while (left <= right) {
      if (nums[left] < nums[right]) {
        ans = Math.min(ans, nums[left]);
      }
      int mid = (left + right) / 2;
      ans = Math.min(ans, nums[mid]);
      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (target < nums[left] || target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (target > nums[right] || target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        twoSum(nums, i, result);
      }
    }
    return result;
  }

  private void twoSum(int[] nums, int i, List<List<Integer>> result) {
    int left = i + 1, right = nums.length - 1;
    while (left < right) {
      int sum = nums[i] + nums[left] + nums[right];
      if (sum < 0) {
        left++;
      } else if (sum > 0) {
        right--;
      } else {
        result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
        while (left < right && nums[left] == nums[left - 1]) {
          ++left;
        }
      }
    }
  }

  public int maxArea(int[] height) {
    int max = 0, left = 0, right = height.length - 1;
    while (left < right) {
      int width = right - left;
      int area = Math.min(height[left], height[right]) * width;
      max = Math.max(max, area);

      if (height[left] <= height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }

    int one = 1, two = 2;

    for (int i = 3; i <= n; i++) {
      int total = one + two;
      one = two;
      two = total;
    }

    return two;
  }

  public int coinChange(int[] coins, int amount) {
    int[] amt = new int[amount + 1];

    Arrays.fill(amt, amount + 1);

    amt[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin) {
          amt[i] = Math.min(amt[i], 1 + amt[i - coin]);
        }
      }
    }

    if (amt[amount] < amount + 1) {
      return amt[amount];
    }
    return -1;
  }

  public int lengthOfLIS(int[] nums) {
    int[] lis = new int[nums.length];
    Arrays.fill(lis, 1);
    int max = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          lis[i] = Math.max(lis[i], 1 + lis[j]);
          max = Math.max(max, lis[i]);
        }
      }
    }
    return max;
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int[][] matrix = new int[text1.length() + 1][text2.length() + 1];

    for (int j = text2.length() - 1; j >= 0; j--) {
      for (int i = text1.length() - 1; i >= 0; i--) {
        if (text1.charAt(i) == text2.charAt(j)) {
          matrix[i][j] = 1 + matrix[i + 1][j + 1];

        } else {
          matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
        }
      }
    }
    return matrix[0][0];
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    Set<String> wordSet = new HashSet<>(wordDict);

    for (int i = 1; i <= s.length(); i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    findCombinationSum(target, result, combination, 0, candidates);
    return result;
  }


  private void findCombinationSum(int target, List<List<Integer>> result, List<Integer> combination,
      int start, int[] candidates) {
    if (target == 0) {
      result.add(new ArrayList<>(combination));
    } else if (target < 0) {
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      combination.add(candidates[i]);
      findCombinationSum(target - candidates[i], result, combination, i, candidates);
      combination.remove(combination.size() - 1);
    }
  }

  public int rob(int[] nums) {
    int rob1 = 0, rob2 = 0, max = 0;
    for (int num : nums) {
      max = Math.max(rob1 + num, rob2);
      rob1 = rob2;
      rob2 = max;
    }
    return max;
  }

  public int robii(int[] nums) {
    int rob1 = 0, rob2 = 0, max1 = nums[0], max2 = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      max1 = Math.max(rob1 + nums[i], rob2);
      rob1 = rob2;
      rob2 = max1;
    }
    rob1 = 0;
    rob2 = 0;
    for (int i = 1; i < nums.length; i++) {
      max2 = Math.max(rob1 + nums[i], rob2);
      rob1 = rob2;
      rob2 = max2;
    }
    return Math.max(max1, max2);
  }

  public int numDecodings(String s) {
    if (s.charAt(0) == '0') {

      return 0;
    }
    int one = 1, two = 1;

    for (int i = 1; i < s.length(); i++) {
      int current = 0;
      if (s.charAt(i) != '0') {
        current = one;
      }
      int value = Integer.parseInt(s.substring(i - 1, i + 1));
      if (value >= 10 && value <= 26) {
        current = current + two;
      }
      two = one;
      one = current;
    }
    return one;
  }

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int[] row : dp) {
      Arrays.fill(row, 1);
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public boolean canJump(int[] nums) {
    int finall = nums.length - 1;

    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= finall) {
        finall = i;
      }
    }
    if (finall == 0) {
      return true;
    }
    return false;
  }


  // Definition for a Node.
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }


  Map<Node, Node> visitedNodeMap = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }
    if (visitedNodeMap.containsKey(node)) {
      return visitedNodeMap.get(node);
    }

    Node cloneNode = new Node(node.val, new ArrayList<>());
    visitedNodeMap.put(node, cloneNode);

    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    return cloneNode;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> courseGraph = new HashMap<>();
    for (int[] pre : prerequisites) {
      if (courseGraph.containsKey(pre[1])) {
        courseGraph.get(pre[1]).add(pre[0]);
      } else {
        List<Integer> nextCourse = new LinkedList<>();
        nextCourse.add(pre[0]);
        courseGraph.put(pre[1], nextCourse);
      }
    }

    Set<Integer> visited = new HashSet<>();
    for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {
      if (courseSchedule(currentCourse, visited, courseGraph) == false) {
        return false;
      }
    }

    return true;

  }


  private boolean courseSchedule(int currentCourse, Set<Integer> visited,
      Map<Integer, List<Integer>> courseGraph) {
    if (visited.contains(currentCourse)) {
      return false;
    }
    if (courseGraph.get(currentCourse) == null) {
      return true;
    }

    visited.add(currentCourse);
    for (int pre : courseGraph.get(currentCourse)) {
      if (courseSchedule(pre, visited, courseGraph) == false) {
        return false;
      }
    }
    visited.remove(currentCourse);
    courseGraph.put(currentCourse, null);
    return true;
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    if (heights.length == 0 || heights[0].length == 0) {
      return new ArrayList<>();
    }
    int row = heights.length, col = heights[0].length;

    boolean[][] pacificReachalbe = new boolean[row][col], atlanticReachable = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      dfs(i, 0, pacificReachalbe, heights);
      dfs(i, col - 1, atlanticReachable, heights);
    }

    for (int i = 0; i < col; i++) {
      dfs(0, i, pacificReachalbe, heights);
      dfs(row - 1, i, atlanticReachable, heights);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (pacificReachalbe[i][j] && atlanticReachable[i][j]) {
          result.add(List.of(i, j));
        }
      }
    }
    return result;

  }


  private void dfs(int row, int col, boolean[][] reachalbe, int[][] heights) {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    reachalbe[row][col] = true;

    for (int[] dir : directions) {
      int newRow = row + dir[0], newCol = col + dir[1];

      if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
        continue;
      }

      if (reachalbe[newRow][newCol]) {
        continue;
      }

      if (heights[newRow][newCol] < heights[row][col]) {
        continue;
      }
      dfs(newRow, newCol, reachalbe, heights);

    }
  }

  private void dfs2(int row, int col, boolean[][] reachalbe, int[][] heights) {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    reachalbe[row][col] = true;

    for (int[] dir : directions) {
      int newRow = row + dir[0], newCol = col + dir[1];

      if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
        continue;
      }

      if (reachalbe[newRow][newCol]) {
        continue;
      }

      if (heights[newRow][newCol] >= heights[row][col]) {
        dfs(newRow, newCol, reachalbe, heights);
      }
    }
  }

  public int numIslands(char[][] grid) {
    int island = 0, row = grid.length, col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          island++;
          dfsNumsIslands(i, j, grid);
        }
      }
    }
    return island;
  }


  private void dfsNumsIslands(int row, int col, char[][] grid) {
    int newRow = grid.length, newCol = grid[0].length;
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    if (row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == '0') {
      return;
    }

    grid[row][col] = '0';

    for (int[] dir : directions) {
      dfsNumsIslands(row + dir[0], col + dir[1], grid);
    }
  }

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {

      return 0;
    }
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int longestSub = 1;
    for (int num : numSet) {
      if (numSet.contains(num - 1)) {
        continue;
      } else {
        int currentNum = num, currentSub = 1;

        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentSub++;
        }

        longestSub = Math.max(currentSub, longestSub);
      }
    }
    return longestSub;
  }

  public int longestConsecutive2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int longestSub = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] + 1 == nums[i + 1]) {
        longestSub++;
      }
    }
    return longestSub;
  }

  // alien-dictionary Premium

  public Map<Character, List<Character>> reversedList = new HashMap<>();
  public Map<Character, Boolean> seen = new HashMap<>();
  public StringBuilder result = new StringBuilder();

  public String alienOrder(String[] words) {
    for (String word : words) {
      for (char c : word.toCharArray()) {
        reversedList.putIfAbsent(c, new ArrayList<>());
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return "";
      }

      for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          reversedList.get(word2.charAt(j)).add(word1.charAt(j));
          break;
        }
      }
    }

    for (Character c : reversedList.keySet()) {
      boolean res = dfsAlienOrder(c);
      if (!res) {
        return "";
      }
    }

    if (result.length() < reversedList.size()) {
      return "";
    }
    return result.toString();
  }


  private boolean dfsAlienOrder(Character c) {
    if (seen.containsKey(c)) {
      return seen.get(c);
    }
    seen.put(c, false);

    for (Character next : reversedList.get(c)) {
      boolean res = dfsAlienOrder(next);
      if (!res) {
        return false;
      }
    }
    seen.put(c, true);
    result.append(c);
    return true;
  }

  /*
   * Graph VS Tree Tree: All nodes are need to connected, and No loops should need to present
   * between nodes. Graph: No such restrictions present to all nodes to be connected in Graph, and
   * There can be present loops in Graph nodes.
   */

  // graph-valid-tree Premium

  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) {
      return false;
    }
    List<List<Integer>> adjancencyList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjancencyList.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adjancencyList.get(edge[0]).add(edge[1]);
      adjancencyList.get(edge[1]).add(edge[0]);
    }

    Stack<Integer> stack = new Stack<>();
    Set<Integer> visited = new HashSet<>();

    stack.push(0);
    visited.add(0);

    while (!stack.isEmpty()) {
      int node = stack.pop();
      for (int neighbour : adjancencyList.get(node)) {
        if (visited.contains(neighbour)) {
          continue;
        }
        visited.add(neighbour);
        stack.push(neighbour);
      }
    }
    if (visited.size() == n) {
      return true;
    }
    return false;
  }

  // number-of-connected-components-in-an-undirected-graph

  public int countComponents(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int from = edge[0], to = edge[1];
      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    boolean[] visited = new boolean[n];
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        bfs(graph, visited, i);
        count++;
      }
    }

    return count;

  }


  private void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbour : graph.get(node)) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.offer(neighbour);
        }
      }
    }
  }

  // insert interval- real time problem like calendar and schedule the meetings

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int newStart = newInterval[0], newEnd = newInterval[1], left = 0, right = intervals.length;
    LinkedList<int[]> output = new LinkedList<>();

    while (left < right && newStart > intervals[left][0]) {
      output.add(intervals[left]);
      left++;
    }
    int[] interval = new int[2];
    if (output.isEmpty() || output.getLast()[1] < newStart) {
      output.add(newInterval);
    } else {
      interval = output.removeLast();
      interval[1] = Math.max(interval[1], newEnd);
      output.add(interval);
    }

    while (left < right) {
      interval = intervals[left];
      left++;
      int start = interval[0], end = interval[1];
      if (output.getLast()[1] < start) {
        output.add(interval);
      } else {
        interval = output.removeLast();
        interval[1] = Math.max(interval[1], end);
        output.add(interval);
      }
    }
    return output.toArray(new int[output.size()][2]);
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> result = new LinkedList<>();
    for (int[] interval : intervals) {
      if (result.isEmpty() || result.getLast()[1] < interval[0]) {
        result.add(interval);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
      }
    }
    return result.toArray(new int[result.size()][]);

  }

  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int prev = 0, count = 0;

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[prev][1] > intervals[i][0]) {
        if (intervals[prev][1] > intervals[i][1]) {
          prev = i;
        }
        count++;
      } else {
        prev = i;
      }
    }
    return count;
  }

  // meeting-rooms
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }

  // meeting rooms ii

  public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    int[] start = new int[intervals.length], end = new int[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);

    int meetingRoomsCount = 0, startptr = 0, endptr = 0;

    while (startptr < start.length) {
      if (start[startptr] >= end[endptr]) {
        meetingRoomsCount--;
        endptr++;
      }
      meetingRoomsCount++;
      startptr++;
    }

    return meetingRoomsCount;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseList(ListNode head) {

    ListNode prev = null, curr = head;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;

  }

  // 141
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head, fast = head.next;

    while (slow != null || fast != null) {
      if (fast == null || fast.next == null) {
        return false;
      }
      if (fast == slow) {
        return true;
      }

      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(1), merge = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        merge.next = list1;
        list1 = list1.next;
      } else {
        merge.next = list2;
        list2 = list2.next;
      }
      merge = merge.next;
    }
    if (merge.next == list1 && list1 == null) {
      merge.next = list2;
    } else {
      merge.next = list1;
    }
    return dummy.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(1), merge = dummy;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (ListNode list : lists) {
      while (list != null) {
        minHeap.add(list.val);
        list = list.next;
      }
    }
    while (!minHeap.isEmpty()) {
      merge.next = new ListNode(minHeap.remove());
      merge = merge.next;
    }
    return dummy.next;
  }

  // 19 remove-nth-node-from-end-of-list
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(1);

    dummy.next = head;
    ListNode front = dummy, back = dummy;

    for (int i = 0; i <= n; i++) {
      front = front.next;
    }

    while (front != null) {
      front = front.next;
      back = back.next;
    }
    back.next = back.next.next;
    return dummy.next;
  }

  // 143 reorder-list
  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode prev = null, curr = slow, temp;

    while (curr != null) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    ListNode first = head, second = prev;
    while (second.next != null) {
      temp = first.next;
      first.next = second;
      first = temp;

      temp = second.next;
      second.next = first;
      second = temp;
    }

  }
  // 73 set-matrix-zeroes

  public void setZeroes(int[][] matrix) {
    boolean firstColumn = false;
    int row = matrix.length;
    int col = matrix[0].length;

    for (int i = 0; i < row; i++) {
      if (matrix[i][0] == 0) {
        firstColumn = true;
      }

      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < row; i++) {

      for (int j = 1; j < col; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (matrix[0][0] == 0) {
      for (int j = 0; j < col; j++) {
        matrix[0][j] = 0;
      }
    }

    if (firstColumn) {
      for (int i = 0; i < row; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  // 54 spiral-matrix
  public List<Integer> spiralOrder(int[][] matrix) {
    int visited = -101, rows = matrix.length, cols = matrix[0].length, row = 0, col = 0,
        changeDirection = 0, currentDirection = 0;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    List<Integer> ans = new ArrayList<>();

    ans.add(matrix[0][0]);

    matrix[0][0] = visited;

    while (changeDirection < 2) {
      while (row + directions[currentDirection][0] >= 0
          && row + directions[currentDirection][0] < rows
          && col + directions[currentDirection][1] >= 0
          && col + directions[currentDirection][1] < cols
          && matrix[row + directions[currentDirection][0]][col
              + directions[currentDirection][1]] != visited) {
        changeDirection = 0;
        row = row + directions[currentDirection][0];
        col = col + directions[currentDirection][1];

        ans.add(matrix[row][col]);
        matrix[row][col] = visited;
      }
      currentDirection = (currentDirection + 1) % 4;
      changeDirection++;
    }

    return ans;
  }

  // 48 rotate-image

  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < (n + 1) / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[n - 1 - j][i];

        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
        matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = matrix[i][j];
        matrix[i][j] = temp;

      }
    }
  }

  // 79 word-search
  public char[][] board;
  public int rows, cols;

  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.rows = board.length;
    this.cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (backtrackExist(r, c, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }


  private boolean backtrackExist(int row, int col, String word, int index) {
    if (index >= word.length()) {
      return true;
    }

    if (row < 0 || row >= rows || col < 0 || col >= cols
        || this.board[row][col] != word.charAt(index)) {
      return false;
    }

    int[] rowdir = {0, 1, 0, -1}, coldir = {1, 0, -1, 0};
    this.board[row][col] = '#';

    boolean isSuccess = false;
    for (int d = 0; d < 4; d++) {
      isSuccess = backtrackExist(row + rowdir[d], col + coldir[d], word, index + 1);
      if (isSuccess) {
        break;
      }
    }
    board[row][col] = word.charAt(index);
    return isSuccess;
  }

  // 3 longest-substring-without-repeating-characters

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    int left = 0, right = 0, ans = 0;

    HashSet<Character> set = new HashSet<>();

    while (right < s.length()) {
      char c = s.charAt(right);
      while (set.contains(c)) {
        set.remove(s.charAt(left));
        left++;
      }
      set.add(c);
      ans = Math.max(ans, right - left + 1);
      right++;
    }

    return ans;

  }

  // 424 longest-repeating-character-replacement/description

  public int characterReplacement(String s, int k) {
    int[] occurance = new int[26];
    int left = 0, right = 0, ans = 0, maxOccurance = 0;

    for (right = 0; right < s.length(); right++) {
      maxOccurance = Math.max(maxOccurance, ++occurance[s.charAt(right) - 'A']);

      if (right - left + 1 - maxOccurance > k) {
        occurance[s.charAt(left) - 'A']--;
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

  // 76 minimum-window-substring
  public static void main(String[] args) {
    LeetCode leetCode = new LeetCode();
    System.out.println(leetCode.minWindow("ADOBECODEBANC", "ABC"));
  }

  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
      return "";
    }
    Map<Character, Integer> mapT = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);

    }

    int required = mapT.size(), l = 0, r = 0, create = 0;
    int[] ans = {-1, 0, 0};
    Map<Character, Integer> subStringMap = new HashMap<>();

    while (r < s.length()) {
      char c = s.charAt(r);
      int count = subStringMap.getOrDefault(c, 0);
      subStringMap.put(c, count + 1);
      if (mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()) {
        create++;
      }

      while (l <= r && required == create) {
        c = s.charAt(l);
        if (ans[0] == -1 || ans[0] >= r - l + 1) {
          ans[0] = r - l + 1;
          ans[1] = l;
          ans[2] = r;
        }
        subStringMap.put(c, subStringMap.get(c) - 1);

        if (mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()) {
          create--;

        }
        l++;
      }
      r++;
    }

    if (ans[0] == -1) {
      return "";
    } else {
      return s.substring(ans[1], ans[2] + 1);
    }
  }

  // 242 valid-anagram
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.parallelSort(sArray);
    Arrays.parallelSort(tArray);
    for (int i = 0; i < sArray.length; i++) {
      if (sArray[i] != tArray[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    int[] count = new int[26];
    for (int i = 0; i < sArray.length; i++) {
      count[sArray[i] - 'a']++;
      count[tArray[i] - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }

  // 49 group-anagrams

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List> ansMap = new HashMap<>();
    int[] count = new int[26];

    for (String s : strs) {
      Arrays.fill(count, 0);

      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder("");

      for (int i = 0; i < 26; i++) {
        sb.append("#");
        sb.append(count[i]);
      }

      String key = sb.toString();

      if (!ansMap.containsKey(key)) {
        ansMap.put(key, new ArrayList<>());
      }
      if (ansMap.get(key) != null) {
        ansMap.get(key).add(s);
      }
    }
    return new ArrayList(ansMap.values());
  }

  // 20 valid-parentheses

  public boolean isValid(String s) {
    Map<Character, Character> mappedCharacters = new HashMap<>();
    mappedCharacters.put(')', '(');
    mappedCharacters.put(']', '[');
    mappedCharacters.put('}', '{');

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (!mappedCharacters.containsKey(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char topElement = stack.pop();
        if (topElement != mappedCharacters.get(c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  // 125 valid-palindrome

  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }

      left++;
      right--;
    }
    return true;
  }

  // 5 longest-palindromic-substring

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int left = 0, right = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = checkPalindrome(s, i, i), len2 = checkPalindrome(s, i, i + 1),
          len = Math.max(len1, len2);

      if (len > right - left) {
        left = i - (len - 1) / 2;
        right = i + len / 2;
      }
    }

    return s.substring(left, right + 1);
  }

  private int checkPalindrome(String s, int left, int right) {
    int L = left, R = right;

    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  // 647 palindromic-substrings

  public int countSubstrings(String s) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      ans += checkPalindromeSubString(s, i, i);
      ans += checkPalindromeSubString(s, i, i + 1);
    }
    return ans;
  }

  private int checkPalindromeSubString(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
      count++;
    }
    return count;
  }


  // 271 encode-and-decode-strings Premium

  public String encode(List<String> str) {
    if (str.size() == 0) {
      return Character.toString(258);
    }

    String seprate = Character.toString(257);
    StringBuilder encodeString = new StringBuilder();
    for (String s : str) {
      encodeString.append(s);
      encodeString.append(seprate);
    }
    encodeString.deleteCharAt(encodeString.length() - 1);
    return encodeString.toString();
  }

  public List<String> decode(String s) {
    if (s.length() == 0) {
      return new ArrayList<>();
    }
    if (s.equals(Character.toString(258))) {
      return new ArrayList<>();
    }

    String seprate = Character.toString(257);
    String[] split = s.split(seprate, -1);
    return Arrays.asList(split);
  }

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // 104 maximum-depth-of-binary-tree
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftmax = maxDepth(root.left);
      int rightmax = maxDepth(root.right);

      return Math.max(leftmax, rightmax) + 1;
    }
  }

  // 100 same-tree

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  // 226 invert-binary-tree

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
  }

  // 124 binary-tree-maximum-path-sum
  int maxPathSum = Integer.MIN_VALUE;

  public int maxGain(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);

    int priceNewPath = node.val + leftGain + rightGain;
    maxPathSum = Math.max(maxPathSum, priceNewPath);
    return node.val + Math.max(leftGain, rightGain);
  }

  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxPathSum;
  }

  // 102 binary-tree-level-order-traversal
  List<List<Integer>> ans = new ArrayList<>();

  public void order(TreeNode node, int level) {
    if (ans.size() == level) {
      ans.add(new ArrayList<>());
    }

    ans.get(level).add(node.val);

    if (node.left != null) {
      order(node.left, level + 1);
    }

    if (node.right != null) {
      order(node.right, level + 1);
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return ans;
    }
    order(root, 0);
    return ans;
  }

  // 297 serialize-and-deserialize-binary-tree
  public String reSerialize(TreeNode root, String str) {
    if (root == null) {
      str += "null";
    } else {
      str += str.valueOf(root.val) + ",";
      str = reSerialize(root.left, str);
      str = reSerialize(root.right, str);
    }
    return str;
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {

    return reSerialize(root, "");
  }

  public TreeNode reDeserialize(List<String> str) {
    if ("null".equals(str.get(0))) {
      str.remove(0);
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(str.get(0)));
    str.remove(0);
    root.left = reDeserialize(str);
    root.right = reDeserialize(str);
    return root;

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

    String[] strArray = data.split(",");
    List<String> strList = new LinkedList<>(Arrays.asList(strArray));
    return reDeserialize(strList);
  }

  // 572 subtree-of-another-tree
  public boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }

    if (s.val != t.val) {
      return false;
    }
    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }
    if (isSame(root, subRoot)) {
      return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

  }

  /*
   * Depth for Search DFS: Pre-order > Root -> Left -> Right DFS: In-order: Left -> Root -> Right
   * Breadth for Search: Will move level by level like first root level then level +1 always in
   * going down of tree
   *
   * 
   */

  // 105 construct-binary-tree-from-preorder-and-inorder-traversal/

  int preOrderIndex;
  Map<Integer, Integer> inOrderIndexMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preOrderIndex = 0;
    inOrderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inOrderIndexMap.put(inorder[i], i);
    }


    return arrayToTree(preorder, 0, preorder.length - 1);
  }

  public TreeNode arrayToTree(int[] preorder, int left, int right) {
    if (left > right) {
      return null;
    }
    int rootValue = preorder[preOrderIndex];
    preOrderIndex++;
    TreeNode root = new TreeNode(rootValue);

    root.left = arrayToTree(preorder, left, inOrderIndexMap.get(rootValue) - 1);
    root.right = arrayToTree(preorder, inOrderIndexMap.get(rootValue) + 1, right);
    return root;
  }

  // 98 validate-binary-search-tree

  public Integer prev;

  public boolean isValidBST(TreeNode root) {
    prev = null;

    return inOrder(root);
  }

  public boolean inOrder(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (!inOrder(root.left)) {
      return false;

    }
    if (prev != null && root.val <= prev) {
      return false;
    }

    prev = root.val;
    return inOrder(root.right);
  }
  // 230 kth-smallest-element-in-a-bst

  public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) {
      return arr;
    }
    inOrder(root.left, arr);
    arr.add(root.val);
    inOrder(root.right, arr);
    return arr;
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nums = inOrder(root, new ArrayList<>());
    return nums.get(k - 1);
  }

  // 235 lowest-common-ancestor-of-a-binary-search-tree

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int parentalVal = root.val;
    int pVal = p.val;
    int qVal = q.val;

    if (pVal > parentalVal && qVal > parentalVal) {
      return lowestCommonAncestor(root.right, p, q);
    }
    if (pVal < parentalVal && qVal < parentalVal) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return root;
  }

  // 208 implement-trie-prefix-tree

  class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
      links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
      return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
      links[ch - 'a'] = node;
    }

    public void setEnd() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }
  class Trie {

    private TrieNode root;

    public Trie() {
      root = new TrieNode();

    }

    public void insert(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        if (!node.containsKey(currentChar)) {
          node.put(currentChar, new TrieNode());
        }
        node = node.get(currentChar);
      }
      node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        if (node.containsKey(currentChar)) {
          node = node.get(currentChar);
        } else {
          return null;
        }
      }
      return node;
    }

    public boolean search(String word) {
      TrieNode node = searchPrefix(word);

      return node != null && node.isEnd();

    }

    public boolean startsWith(String prefix) {
      TrieNode node = searchPrefix(prefix);
      return node != null;

    }
  }

  // 347 top-k-frequent-elements
  public int[] topKFrequent(int[] nums, int k) {
    if (k == nums.length) {
      return nums;
    }

    Map<Integer, Integer> count = new HashMap<>();

    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
    for (int n : count.keySet()) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = heap.poll();
    }
    return ans;
  }

}
