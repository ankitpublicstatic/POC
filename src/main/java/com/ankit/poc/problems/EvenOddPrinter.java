package com.ankit.poc.problems;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {
  private static Object object = new Object();

  private static IntPredicate evenPredicate = x -> x % 2 == 0;

  private static IntPredicate oddPredicate = x -> x % 2 != 0;

  public static void printResult(IntPredicate condition) {
    IntStream.rangeClosed(1, 10).filter(condition).forEach(EvenOddPrinter::execute);
  }

  public static void execute(int i) {
    synchronized (object) {
      try {
        System.out.println("Thread name : " + Thread.currentThread().getName() + " Value :" + i);
        object.notify();
        object.wait();
      } catch (InterruptedException e) {

        e.printStackTrace();
      }

    }
  }

  public static void main(String[] args) {
    CompletableFuture.runAsync(() -> EvenOddPrinter.printResult(oddPredicate));
    CompletableFuture.runAsync(() -> EvenOddPrinter.printResult(evenPredicate));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
  }
}
