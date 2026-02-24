package com.ankit.poc;

import java.util.Arrays;
import java.util.List;
import com.ankit.poc.java8.Student;
import com.ankit.poc.java_8.Employee;
import com.ankit.poc.java_8.Project;


public class StaticData {

  public static List<Student> getAllStudents() {
    return Arrays.asList(
        new Student(2, "ankit", 87, 23, "M", "IT", "Begusarai",
            Arrays.asList("788456465465", "894132654654")),
        new Student(4, "sonam", 45, 23, "F", "HR", "Pune", Arrays.asList("78678678", "4878778788")),
        new Student(2, "leena", 98, 23, "M", "IT", "Delhi",
            Arrays.asList("457878784545", "457875")),
        new Student(6, "suraj", 98, 23, "M", "IT", "Delhi",
            Arrays.asList("457878784545", "457875")),
        new Student(7, "mongia", 34, 23, "M", "IT", "Goa",
            Arrays.asList("5478877854445", "4587878")),
        new Student(9, "ram", 56, 23, "M", "IT", "Pune", Arrays.asList("4545454545", "854454545")),
        new Student(10, "sita", 99, 23, "M", "HR", "Dehu", Arrays.asList("454545", "4545454545")),
        new Student(11, "getta", 65, 23, "M", "BD", "Guhati",
            Arrays.asList("1224878787", "87787878")),
        new Student(12, "hena", 43, 23, "M", "BD", "Asam",
            Arrays.asList("7787833264", "8778787844")),
        new Student(16, "suresh", 33, 28, "M", "IT", "Bangluru",
            Arrays.asList("4477833233", "47878111")),
        new Student(25, "shri", 43, 23, "M", "HR", "Mumbai",
            Arrays.asList("4457878778", "877821211")),
        new Student(29, "akshay", 82, 22, "M", "IT", "Katak",
            Arrays.asList("78785332", "7878454454")));

  }

  public static List<Employee> getAllEmployees() {
    Project p1 = new Project("P001", "Alpha", "ABC Corp", "Alice");
    Project p2 = new Project("P002", "Beta", "XYZ Ltd", "Bob");
    Project p3 = new Project("P003", "Gamma", "ABC Corp", "Alice");
    Project p4 = new Project("P004", "Delta", "TechWorld", "Charlie");
    Project p5 = new Project("P005", "Epsilon", "MoneyMatters", "Daniel");
    Project p6 = new Project("P006", "Zeta", "SmartTech", "Eva");
    Project p7 = new Project("P007", "Eta", "BrandBoost", "George");
    Project p8 = new Project("P008", "Theta", "InnoSoft", "Hannah");
    Project p9 = new Project("P009", "Iota", "FastTrack", "Ian");
    Project p10 = new Project("P010", "Kappa", "DigitalWave", "Jessica");

    // Employee instances
    Employee e1 = new Employee(1, "John Doe", "Development", Arrays.asList(p1, p2), 80000, "Male");
    Employee e2 = new Employee(2, "Jane Smith", "Development", Arrays.asList(p3), 80000, "Female");
    Employee e3 = new Employee(3, "Robert Brown", "Sales", Arrays.asList(p4), 60000, "Male");
    Employee e4 = new Employee(4, "Lisa White", "HR", Arrays.asList(p1), 55000, "Female");
    Employee e5 = new Employee(5, "Michael Green", "Finance", Arrays.asList(p5), 90000, "Male");
    Employee e6 =
        new Employee(6, "Sophia Brown", "Development", Arrays.asList(p6), 85000, "Female");
    Employee e7 = new Employee(7, "James Wilson", "Marketing", Arrays.asList(p7), 72000, "Male");
    Employee e8 =
        new Employee(8, "Olivia Harris", "Development", Arrays.asList(p8), 88000, "Female");
    Employee e9 = new Employee(9, "William Lee", "Sales", Arrays.asList(p9), 78000, "Male");
    Employee e10 =
        new Employee(10, "Emily Clark", "Development", Arrays.asList(p10), 95000, "Female");

    // Print employee details (just for testing)
    return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
  }
}
