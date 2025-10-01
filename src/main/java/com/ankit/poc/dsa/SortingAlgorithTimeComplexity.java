package com.ankit.poc.dsa;

import java.util.Arrays;

public class SortingAlgorithTimeComplexity {
  public static void main(String[] args) {
    int[] arr = new int[] {8, 3, 9, 23, 5, 3, 1, 4};
    // SortingAlgorithTimeComplexity.bubbleSort(arr);

    // SortingAlgorithTimeComplexity.selectionSort(arr);
    // SortingAlgorithTimeComplexity.insertionSort(arr);
    // SortingAlgorithTimeComplexity.quickSort(arr, 0, arr.length - 1);
    SortingAlgorithTimeComplexity.mergeSort(arr, 0, arr.length - 1);
    System.out.println("After Sorting of the Array: " + Arrays.toString(arr));
  }

  // Time Complexity due to using 2 for loop : O(n2) n ka power 2
  public static void bubbleSort(int[] nums) {
    System.out.println("Before Sorting the Array: " + Arrays.toString(nums));
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
      System.out.println("After One Step Sorting of the Array: " + Arrays.toString(nums));
    }
    System.out.println("After Sorting the Array: " + Arrays.toString(nums));
  }

  // Time Complexity due to using 2 for loop : O(n2) n ka power 2
  public static void selectionSort(int[] nums) {

    System.out.println("Before Sorting the Array: " + Arrays.toString(nums));
    int minIndex = -1;
    // 8, 3, 9, 23, 5, 3, 1, 4
    // 0, 1, 2, 3, 4, 5, 6, 7
    for (int i = 0; i < nums.length - 1; i++) {
      minIndex = i;
      for (int j = i; j < nums.length; j++) {
        if (nums[minIndex] > nums[j]) { // 8 > 3
          minIndex = j;
        }
      }
      int temp = nums[minIndex];
      nums[minIndex] = nums[i];
      nums[i] = temp;

      System.out.println("After One Step Sorting of the Array: " + Arrays.toString(nums));

    }
    System.out.println("After Sorting the Array: " + Arrays.toString(nums));
  }

  // Time Complexity due to using 2 for loop : O(n2) n ka power 2

  public static void insertionSort(int[] nums) {
    System.out.println("Before Sorting the Array: " + Arrays.toString(nums));
    for (int i = 1; i < nums.length; i++) {
      int key = nums[i];
      int j = i - 1;

      while (j >= 0 && nums[j] > key) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = key;
      System.out.println("After One Step Sorting of the Array: " + Arrays.toString(nums));
    }
    System.out.println("After One Step Sorting of the Array: " + Arrays.toString(nums));

  }

  // O(n log n)
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }

  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }

  public static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      int mid = (l + r) / 2;
      mergeSort(arr, l, mid);
      mergeSort(arr, mid + 1, r);
      merge(arr, mid, l, r);
    }
  }

  private static void merge(int[] arr, int mid, int l, int r) {
    int n1 = mid - l + 1;
    int n2 = r - mid;
    int[] lArr = new int[n1];
    int[] rArr = new int[n2];

    for (int x = 0; x < n1; x++) {
      lArr[x] = arr[l + x];
    }
    for (int x = 0; x < n2; x++) {
      rArr[x] = arr[mid + 1 + x];
    }
    int j = 0, i = 0, k = l;

    while (i < n1 && j < n2) {
      if (lArr[i] <= rArr[j]) {
        arr[k] = lArr[i];
        i++;
      } else {
        arr[k] = rArr[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      arr[k] = lArr[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = rArr[j];
      j++;
      k++;
    }
  }

}
