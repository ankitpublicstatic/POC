package com.ankit.poc.object.creation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Example implements Serializable {
  int x = 10;
}


public class ObjectCreationUsingDeserialization {
  public static void main(String[] args) throws Exception {
    Example obj1 = new Example();

    // Serialize the object
    FileOutputStream fos = new FileOutputStream("object.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(obj1);
    oos.close();
    fos.close();

    // Deserialize the object
    FileInputStream fis = new FileInputStream("object.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Example obj2 = (Example) ois.readObject(); // Using deserialization
    ois.close();
    fis.close();

    System.out.println(obj2.x);
  }
}
