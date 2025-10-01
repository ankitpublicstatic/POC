package com.ankit.poc.logical.programming;

import java.util.Arrays;
import java.util.Collections;

public class SortAnArray {

  public static void main(String[] args) {

    int[] numArray = {40, 2, 100, 50, 3};

    System.out.println("Before Sorting : " + Arrays.toString(numArray));

    // Approach 1

    for (int i = 0; i < numArray.length - 1; i++) {
      for (int j = 0; j < numArray.length - 1; j++) {

        if (numArray[j] > numArray[j + 1]) {

          int temp = numArray[j];

          numArray[j] = numArray[j + 1];

          numArray[j + 1] = temp;
        }
      }
      System.out.println("Pass : " + i + " Sorted Array : " + Arrays.toString(numArray));
    }
    System.out.println("After Sorting : " + Arrays.toString(numArray));


    // Approach 2

    Arrays.sort(numArray);
    System.out.println("After Sorting : " + Arrays.toString(numArray));


    // Approach 3
    Arrays.parallelSort(numArray);
    System.out.println("After Sorting : " + Arrays.toString(numArray));


    // Approach 3 Reverse Order
    Integer[] integerArray = {40, 2, 100, 50, 3};
    Arrays.sort(integerArray, Collections.reverseOrder());
    System.out.println("After Reversed Sorting : " + Arrays.toString(integerArray));
  }
}
