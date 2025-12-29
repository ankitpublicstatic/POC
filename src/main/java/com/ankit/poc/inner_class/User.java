package com.ankit.poc.inner_class;

// Builder Pattern (Best Practice) Real-World Use Cases static inner class
public class User {
  private String name;

  static class Builder {
    private String name;

    Builder name(String name) {
      this.name = name;
      return this;
    }

    User build() {
      User user = new User();
      user.name = this.name;
      return user;
    }
  }
}
// Why static?
// ✔ Builder doesn’t need outer instance
// ✔ Avoid memory leaks
// ✔ Clean API


// Utility Grouping
class SecurityUtils {
  static class JWTUtils {
    static void validate() {

    }
  }

  static class PasswordUtils {
    static void hash() {

    }
  }
}
// 3️⃣ Spring Internal Usage

// Spring uses static nested classes heavily for:

// Configuration holders
// Metadata
// Proxy helpers

//| Feature                 | Normal Class   | Inner Class         | Static Nested    |
//| ----------------------- | -------------- | ------------------- | ---------------- |
//| Needs outer instance    | ❌              | ✅                   | ❌                |
//| Access outer non-static | ❌              | ✅                   | ❌                |
//| Can have static members | ✅              | ❌                   | ✅                |
//| Memory leak risk        | ❌              | ⚠️                  | ❌                |
//| JVM reference to outer  | ❌              | ✅                   | ❌                |
//| Best for                | Reusable logic | Strongly tied logic | Logical grouping |
