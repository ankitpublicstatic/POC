package com.ankit.poc.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvReader {

  @Autowired
  private Environment environment;

  public void printProperty() {
    String dbUrl = environment.getProperty("spring.datasource.url");
    System.out.println("Database URL: " + dbUrl);
  }
} // ✅ When to use:
// When you need dynamic property access (e.g., reading conditional configs).
