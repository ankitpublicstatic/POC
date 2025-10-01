package com.ankit.poc.problems;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrint {

  private static Object object = new Object();

  private static IntPredicate evenIntPredicate = i -> i % 2 == 0;

  private static IntPredicate oddIntPredicate = i -> i % 2 != 0;

  private static void execute(int i) {
    synchronized (object) {
      try {
        System.out.println("Thread name : " + Thread.currentThread().getName() + " number : " + i);
        object.notify();
        object.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private static void printNumber(IntPredicate predicate) {
    IntStream.rangeClosed(1, 20).filter(predicate).forEach(EvenOddPrint::execute);
  }

  public static void main(String[] args) throws InterruptedException {
    CompletableFuture.runAsync(() -> EvenOddPrint.printNumber(oddIntPredicate));
    CompletableFuture.runAsync(() -> EvenOddPrint.printNumber(evenIntPredicate));
    Thread.sleep(1000);
  }
}
