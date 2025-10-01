package com.ankit.poc.dsa;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableHashMap {
  public static void main(String[] args) {
    // HashMap Example
    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "Java");
    hashMap.put(2, "Spring");
    hashMap.put(null, "NullKey"); // Allowed
    hashMap.put(3, null); // Allowed
    System.out.println("HashMap: " + hashMap);

    // Hashtable Example
    Map<Integer, String> hashtable = new Hashtable<>();
    hashtable.put(1, "Java");
    hashtable.put(2, "Spring");
    // hashtable.put(null, "NullKey"); // Throws NullPointerException
    // hashtable.put(3, null); // Throws NullPointerException
    System.out.println("Hashtable: " + hashtable);
  }
}
