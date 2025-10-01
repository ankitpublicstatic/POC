package com.ankit.poc.logical.programming;

import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class L2 {
  //

  public static void printPairs(int[] array, int target) {
    Set<Integer> uniqueSet = new HashSet<>();
    for (int num : array) {
      int secondNum = target - num;
      if (uniqueSet.contains(secondNum)) {
        System.out.println("Pair : (" + num + ", " + secondNum + ")");
      }
      uniqueSet.add(num);
    }
  }

  public int removeDuplicates(int[] nums) {
    int j = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[j]) {
        nums[++j] = nums[i];
      }
    }
    return j + 1;
  }
  // SELECT salary FROM emp ORDER BY salary DESC LIMIT 1 OFFSET 2;
  // SELECT MAX(salary) FROM emp WHERE salary < (SELECT MAX(salary) FROM emp);
  // slect max(salary) from emp where salary < (select max(salary)) from emp);

  public static void main(String[] args) {
    int[] arr = {8, 9, 1, 2, 5, 4, 6};
    printPairs(arr, 10);
    // CompletableFuture.supplyAsync(() -> fetchData()).thenApply(data -> process(data))
    // .thenAccept(result -> System.out.println(result));

    // Rectangle pattern
    // for (int i = 1; i <= 3; i++) {
    // for (int j = 1; j <= 3; j++) {
    // System.out.print(i + "," + j + " ");
    // }
    // System.out.println();
    // }
    // Trangale pattern
    // for (int i = 1; i <= 3; i++) {
    // for (int j = 1; j <= i; j++) {
    // System.out.print(i + "," + j + " ");
    // }
    // System.out.println();
    // }// Example usage:
    int[] height = {8, 9, 1, 2, 5, 4, 6};
    System.out.println(maxArea(height)); // Output will be 30
    System.out.println(maxAread(height));
  }

  // What is ListNode in Java?
  // In Java, a ListNode is a basic building block used to create a singly linked list—a linear data
  // structure where each element (or node) points to the next.
  // int val stores the data.
  // ListNode next points to the next node in the list.
  // How It Works: Each node connects to the next, forming a chain:
  // [1] -> [2] -> [3] -> null
  // Traverse a Linked List:
  void traverse(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  // Insert at End:
  void insertAtEnd(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    while (head.next != null) {
      head = head.next;
    }
    head.next = newNode;
  }

  // Reverse a Linked List:
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }


  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }

  public static int maxArea(int[] height) {
    int left = 0, right = height.length - 1, max = 0;
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

  public static int maxAread(int[] height) {
    int left = 0, right = height.length - 1, max = 0;
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }// Remove Duplicates In-Place from Array:

  public int removeDuplicatess(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int index = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }

}
