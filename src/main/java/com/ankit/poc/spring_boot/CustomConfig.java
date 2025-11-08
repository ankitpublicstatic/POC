package com.ankit.poc.spring_boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:custom.properties")
public class CustomConfig {
  @Value("${custom.key}")
  private String customKey;

  public void showValue() {
    System.out.println("Custom Key: " + customKey);
  }
}
// ✅ When to use:
// When properties are located in a separate .properties file.
