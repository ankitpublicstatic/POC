package com.ankit.poc.object.creation;

class DatabaseConnection {
  private static DatabaseConnection instance; // Singleton instance

  private DatabaseConnection() { // Private constructor
    System.out.println("Database Connection Established!");
  }

  public static DatabaseConnection getInstance() { // Factory method
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }
}



public class FactoryMethodSingletonPatternObjectCreation {
  public static void main(String[] args) {
    DatabaseConnection db1 = DatabaseConnection.getInstance();
    DatabaseConnection db2 = DatabaseConnection.getInstance();

    System.out.println(db1 == db2); // true (Same object)
  }
}
