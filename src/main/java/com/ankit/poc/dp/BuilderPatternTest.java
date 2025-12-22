package com.ankit.poc.dp;

class User {
  private String firstName; // required
  private String lastName; // required
  private Integer age; // optional
  private String phone; // optional
  private String address; // optional

  static class Builder {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String address;

    public Builder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public Builder age(Integer age) {
      this.age = age;
      return this;
    }

    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public User build() {
      User user = new User();
      user.firstName = this.firstName;
      user.lastName = this.lastName;
      user.age = this.age;
      user.phone = this.phone;
      user.address = this.address;
      return user;
    }
  }

  @Override
  public String toString() {
    return firstName + " " + lastName + " (" + age + ") - " + phone + " - " + address;
  }
}


// Client code
public class BuilderPatternTest {
  public static void main(String[] args) {
    User user = new User.Builder("Ankit", "Kumar").age(33).phone("00990").address("Pune").build();
    System.out.println(user);
  }
  // Solves telescoping constructor problem.

  // Enhances readability and immutability.

  // Often used for DTOs, configuration objects, and HTTP request builders.
}
