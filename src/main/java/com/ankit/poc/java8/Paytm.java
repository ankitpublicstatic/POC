package com.ankit.poc.java8;

public class Paytm implements UPIPayment {

  @Override
  public String doPayment(String source, String destination) {
    String date = UPIPayment.datePatterns("yyyy-MM-dd");
    return "Successful payment done. " + date;
  }

}
