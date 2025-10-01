package com.ankit.poc.object.creation;

class Main {

  void show() {
    System.out.println("Reflection example");
  }
}


public class ReflectionObjectCreation {
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("Main");
    Main obj = (Main) clazz.getDeclaredConstructor().newInstance(); // Using Reflection
    // Since Java 9, newInstance() is deprecated; use getDeclaredConstructor().newInstance()
    // instead.
    obj.show();
  }
}
