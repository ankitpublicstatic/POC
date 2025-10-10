package com.ankit.poc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode {
  public static void main(String[] args) {
    // int[] nums = new int[] {1, 2, 8, 5, 9, 4};

    int[] nums = new int[] {0, 1, 0, 3, 12};
    // LeetCode.targetOfSum(nums, 13);
    // System.out.println(Arrays.toString(LeetCode.productExceptSelfOneForLoop(nums)));
    System.out.println(Arrays.toString(nums));
    LeetCode.moveZeroes4(nums);
  }


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
}
