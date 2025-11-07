package com.ankit.poc.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class FailSafeExample {
  public static void main(String[] args) {
    CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();
    names.add("Sita");
    names.add("ram");
    for (String name : names) {
      System.out.println(name);
      if ("ram".equals(name)) {
        names.add("ankit");// ✅ Safe - no exception
      }
    }
    System.out.println("Final list: " + names);
    // 💡 Internally:

    // Each modification creates a new copy of the underlying array.

    // The iterator uses a snapshot of the array taken at the start of iteration.

    CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
    // ✅ No exception. Concurrent updates are safe.

    // | Use Case | Recommended Collection | Why |
    // | Single-threaded, no concurrency | ArrayList, HashMap | Fast, low overhead |
    // | Multi-threaded read-heavy | CopyOnWriteArrayList, ConcurrentHashMap | Fail-safe
    // iteration |
    // | Multi-threaded write-heavy | ConcurrentHashMap, BlockingQueue | Fine-grained locking |
    // | Need synchronization manually | Collections.synchronizedList() | Simple lock wrapping |


    List<String> list = Collections.synchronizedList(new ArrayList<>());
    list.add("ankit");
    synchronized (list) {
      Iterator<String> itr = list.iterator();
      while (itr.hasNext()) {
        System.err.println(itr.next());
        list.add("ram"); // ❌ still fails-fast unless properly synchronized
      }
    }


    // 💡 Even with synchronization, direct structural modification inside iteration is unsafe —
    // prefer concurrent collections.

    // | Concept | Description | Example | Safe Alternative |
    // | Fail-Fast Iterator | Detects concurrent modification | ArrayList, HashMap |
    // ConcurrentHashMap, CopyOnWriteArrayList |
    // | Exception Thrown | ConcurrentModificationException | list.add() inside loop | Use
    // iterator’s remove() or fail-safe collections |
    // | Internal Mechanism | modCount vs expectedModCount | Detected in iterator |
    // Snapshot-based iteration |
    // | Thread Safety | Not thread-safe | ArrayList | CopyOnWriteArrayList |


    // 🧩 ️Interview Traps & Tips

    // ✅ Always use iterator.remove(), never list.remove() inside loops.
    // ✅ ConcurrentModificationException can occur in single-threaded code too! (if you modify
    // during iteration).
    // ✅ ConcurrentHashMap and CopyOnWriteArrayList are fail-safe, not fail-fast.
    // ✅ Avoid using synchronizedList for large concurrent apps — high contention.

  }
}
