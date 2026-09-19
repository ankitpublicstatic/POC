package com.ankit.poc.abc;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Data;

class Node {
  int data;
  Node next;
}


public class LinkedList {
  Node head;

  public void inser(int data) {
    Node node = new Node();
    node.data = data;
    node.next = null;

    if (head == null) {
      head = node;
    } else {
      Node h = head;
      while (h.next != null) {
        h = h.next;
      }
      h.next = node;
    }
  }

  public void insertAtStart(int data) {
    Node node = new Node();
    node.data = data;

    node.next = head;
    head = node;
  }

  public void insertAtIndex(int index, int data) {
    if (index == 0) {
      insertAtStart(data);
    } else {
      Node node = new Node();
      node.data = data;

      Node h = head;

      for (int i = 0; i < index; i++) {
        h = h.next;
      }
      node.next = h.next;
      h.next = node;
    }
  }

  public void show() {

    Node h = head;
    while (h.next != null) {
      System.out.println(h.data);
      h = h.next;
    }
    System.out.println(h.data);
  }

  public void deleteAt(int index) {
    if (index == 0) {
      head = head.next;
    } else {
      Node h = head; // 4
      for (int i = 0; i < index; i++) {
        h = h.next; // 3
      }
      Node del = h.next;
      h.next = del.next;
      del = null;
    }
  }

  public void reverse() {
    Node prev = null;
    Node curr = head;
    while (curr != null) {
      Node next = curr.next; // Save next
      curr.next = prev; // Reverse link
      prev = curr; // Move previous
      curr = next; // Move current
    }
    head = prev;// New head
  }

  public static void main(String[] args) {
    List<Employee> employees = null;

    Optional<Employee> value = employees.stream().collect(Collectors.groupingBy(Employee::getSalary,

        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))

        .entrySet().stream().toList().get(1).getValue();
    System.out.println(maximumProfit(new int[] {7, 1, 5, 3, 6, 4}));
  }

  public static int maximumProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
      minPrice = Math.min(minPrice, price);
      maxProfit = Math.max(maxProfit, price - minPrice);
    }

    return maxProfit;
  }

  public int[] maxProfitDays(int[] prices) {

    int minPrice = Integer.MAX_VALUE;
    int buyDay = -1, bestBuy = -1, bestSell = -1;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {

      if (prices[i] < minPrice) {
        minPrice = prices[i];
        buyDay = i;
      }

      int profit = prices[i] - minPrice;

      if (profit > maxProfit) {
        maxProfit = profit;
        bestBuy = buyDay;
        bestSell = i;
      }
    }

    return new int[] {bestBuy, bestSell, maxProfit};
  }


  // sso login, multihreading, stock related, .
  // deadlock,how many spring bean scope, spring bean lifecycle, spring container all type, and give
  // me all question and answer for spring and spring boot related, stream api methods like peek,
  // flatmap, parlel stream, all least use stream api method chain
  // update employee e set e.salary = e.salary + e.salary * 100/10;
}


@Data
class Employee {
  private Integer id;
  private String name;
  private Double salary;
  private String dept;
}
