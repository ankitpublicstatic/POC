package com.ankit.poc;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenAndOddPrinter {

  private static Object lock = new Object();

  private static IntPredicate evenCondition = e -> e % 2 == 0;
  private static IntPredicate oddCondition = e -> e % 2 != 0;

  public static void execute(int i) {
    synchronized (lock) {
      try {
        System.out.println("Thread Name " + Thread.currentThread().getName() + " : " + i);
        lock.notify();
        lock.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void printResults(IntPredicate conIntPredicate) {
    IntStream.rangeClosed(1, 10).filter(conIntPredicate).forEach(EvenAndOddPrinter::execute);
  }

  public static void main(String[] args) throws InterruptedException {
    CompletableFuture.runAsync(() -> EvenAndOddPrinter.printResults(oddCondition));
    CompletableFuture.runAsync(() -> EvenAndOddPrinter.printResults(evenCondition));
    Thread.sleep(1000);
  }

}
