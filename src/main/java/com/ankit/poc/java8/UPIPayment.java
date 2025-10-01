package com.ankit.poc.java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {
  String doPayment(String source, String destination);

  default double getScratchCard() {
    return new Random().nextDouble();
  }

  static String datePatterns(String patterns) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patterns);
    return simpleDateFormat.format(new Date());
  }
}
