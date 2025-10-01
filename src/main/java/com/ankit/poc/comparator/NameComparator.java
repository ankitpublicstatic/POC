package com.ankit.poc.comparator;

import java.util.Comparator;
import com.ankit.poc.java8.Student;

public class NameComparator implements Comparator<Student> {

  @Override
  public int compare(Student student1, Student student2) {
    return student1.getName().compareTo(student2.getName());
  }

}
