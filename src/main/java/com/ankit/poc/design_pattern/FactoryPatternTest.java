package com.ankit.poc.design_pattern;

interface Shape {
  void draw();
}


class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Drawing Circle");
  }

}


class Square implements Shape {

  @Override
  public void draw() {
    System.out.println("Drawing Square");
  }

}


// Create a Factory class
// Factory Pattern is used to create objects without exposing the creation logic to the client.
// The client just asks the factory for an object, and the factory decides which concrete class to
// instantiate.


// Think of a Car Factory — you order a car by type ("SUV", "Sedan") and the factory gives you one.
// You don’t care how it’s built.
class ShapeFactory {
  public static Shape getShape(String type) {
    if ("Circle".equalsIgnoreCase(type)) {
      return new Circle();
    } else if ("Square".equalsIgnoreCase(type)) {
      return new Square();
    }
    return null;
  }
}


public class FactoryPatternTest {
  public static void main(String[] args) {
    Shape shape1 = ShapeFactory.getShape("Circle");
    Shape shape2 = ShapeFactory.getShape("Square");
    shape1.draw();
    shape2.draw();
  }
}
// Encapsulates object creation logic.

// Promotes loose coupling — client depends on interface, not concrete class.

// Great for switchable implementations (e.g., different payment gateways).
