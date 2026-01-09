package com.ankit.poc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThread {
  public static void main(String[] args) throws InterruptedException {
    Thread vThread = Thread.ofVirtual().name("custom-virtual-thread").start(() -> {
      System.out.println("Running in: " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });
    vThread.join();// wait for completion
  }

  // Millions of virtual threads vs platform threads

  public void manyVirtualThreads() throws InterruptedException {
    int taskCount = 100_000_00;// can go higher in practice
    List<Thread> threads = new ArrayList<>(taskCount);
    for (int i = 0; i < taskCount; i++) {
      int id = i;
      Thread thread = Thread.ofVirtual().start(() -> {
        // Simulate blocking I/O
        try {
          Thread.sleep(1000);
          // In real code: call DB, HTTP Service, etc.
          // httpClient.send(request, BodyHandlers.ofString());
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        System.out.println("Task " + id + " done on " + Thread.currentThread().getName());
      });
      threads.add(thread);
    }
    for (Thread thread : threads) {
      thread.join();
    }
    System.out.println("All virtual thread tasks completed.");
  }

  public void virtualThreadExecutorService() {
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 100; i++) {
        int taskNumber = i;
        executorService.submit(() -> {
          System.out
              .println("Task " + taskNumber + " running in " + Thread.currentThread().getName());
          try {
            Thread.sleep(500);// pretend blocking I/O
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        });
      }
    } // try-with-resources calls shutdown() and waits for tasks
  }
}
