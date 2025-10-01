package com.ankit.poc.java8;

public class Test {
  public static void main(String[] args) {
    // Runnable runnable = new Runnable() {
    //
    // @Override
    // public void run() {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // };

    // Runnable th = () -> {
    // System.out.println("Run method");
    // };
    //
    // new Thread(th).start();
    // Runnable runnable2 = () -> {
    //
    // };

    // MyFunction test = (i) -> System.out.println("test method executed");
    // test.test(0);

    // MyFunction myFunction = (i) -> {
    // return i * 10;
    // };
    // System.out.println(myFunction.test(5));
    MyFunction function = (s1, s2) -> {
      return s1 + " " + s2;
    };
  }

}
