package com.ankit.poc.object.creation;

class ExampleCloneable implements Cloneable {
  int x = 10;

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}


public class CloneObjectCreation {
  public static void main(String[] args) throws CloneNotSupportedException {
    ExampleCloneable obj1 = new ExampleCloneable();
    ExampleCloneable obj2 = (ExampleCloneable) obj1.clone(); // Using clone()
    System.out.println(obj2.x);
  }
}
