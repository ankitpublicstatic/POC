package com.ankit.poc.inner_class;

public class AnonymousInnerClass {
Runnable runnable = new Runnable() {
  
  @Override
  public void run() {
    System.out.println("Running");
    
  }
};
//Equivalent Lambda:
Runnable r = () -> System.out.println("Running");
}
//✔ No class name
//✔ Single-use logic
//✔ Heavily replaced by lambdas

//| Aspect           | Inner Class     | Lambda  |
//| ---------------- | --------------- | ------- |
//| Multiple methods | ✅               | ❌       |
//| State            | ✅               | Limited |
//| Readability      | ❌               | ✅       |
//| Performance      | Slight overhead | Better  |
