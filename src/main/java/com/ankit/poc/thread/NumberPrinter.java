package com.ankit.poc.thread;

class NumberPrinter {
  public static void main(String[] args) throws InterruptedException {
    NumberPrinter numberPrinter = new NumberPrinter();
    new Thread(() -> {
      try {
        numberPrinter.printEven();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    new Thread(() -> {
      try {
        numberPrinter.printOdd();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

  }

  private int number = 1;
  private final int limit = 10;

  public synchronized void printOdd() throws InterruptedException {

    while (number <= limit) {

      while (number % 2 == 0) {
        wait();
      }

      System.out.println(Thread.currentThread().getName() + "  " + number++);
      notify();
    }
  }

  public synchronized void printEven() throws InterruptedException {

    while (number <= limit) {

      while (number % 2 != 0) {
        wait();
      }

      System.out.println(Thread.currentThread().getName() + "  " + number++);
      notify();
    }
  }
}
