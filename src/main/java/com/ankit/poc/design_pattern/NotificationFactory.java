package com.ankit.poc.design_pattern;

public class NotificationFactory {
  private static final NotificationFactory INSTANCE = new NotificationFactory();

  private NotificationFactory() {

  }

  public static NotificationFactory getInstance() {
    return INSTANCE;
  }

  public NotificationFactory getBuilder(String type) {
    if ("Email".equalsIgnoreCase(type)) {
      return new EmailNotificationBuilder();
    } else if ("SMS".equalsIgnoreCase(type)) {
      return new SmsNotificationBuilder();
    }
    return null;
  }
}
// Real-World Usage Together

// You can even combine them:

// A Singleton Factory (only one instance of factory in the app).

// A Factory that returns different Builders for different products.
