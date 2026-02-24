package com.ankit.poc.java8;

import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
  private Integer id;
  private String name;
  private Integer rank;
  private Integer age;
  private String gender;
  private String dept;
  private String city;
  private List<String> contacts;

  @Override
  public int compareTo(Student student) {
    if (id == student.getId()) {
      return 0;
    } else if (id > student.getId()) {
      return 1;
    } else {
      return -1;
    }
  }



  @Override
  public int hashCode() {
    return Objects.hash(age, city, contacts, dept, gender, id, name, rank);
  }



  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Student other)) {
      return false;
    }
    return Objects.equals(age, other.age) && Objects.equals(city, other.city)
        && Objects.equals(contacts, other.contacts) && Objects.equals(dept, other.dept)
        && Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
        && Objects.equals(name, other.name) && Objects.equals(rank, other.rank);
  }



  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param id
   * @param name
   * @param rank
   * @param age
   * @param gender
   * @param dept
   * @param city
   * @param contacts
   */
  public Student(Integer id, String name, Integer rank, Integer age, String gender, String dept,
      String city, List<String> contacts) {
    super();
    this.id = id;
    this.name = name;
    this.rank = rank;
    this.age = age;
    this.gender = gender;
    this.dept = dept;
    this.city = city;
    this.contacts = contacts;
  }

  public Student() {
    // TODO Auto-generated constructor stub
  }

  public Student(int id, String name, int rank, int age, String gender, String dept, String city,
      List<String> contacts) {
    super();
    this.id = id;
    this.name = name;
    this.rank = rank;
    this.age = age;
    this.gender = gender;
    this.dept = dept;
    this.city = city;
    this.contacts = contacts;
  }

  /**
   * @return the rank
   */
  public Integer getRank() {
    return rank;
  }

  /**
   * @param rank the rank to set
   */
  public void setRank(Integer rank) {
    this.rank = rank;
  }

  /**
   * @return the age
   */
  public Integer getAge() {
    return age;
  }

  /**
   * @param age the age to set
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * @return the dept
   */
  public String getDept() {
    return dept;
  }

  /**
   * @param dept the dept to set
   */
  public void setDept(String dept) {
    this.dept = dept;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the contacts
   */
  public List<String> getContacts() {
    return contacts;
  }

  /**
   * @param contacts the contacts to set
   */
  public void setContacts(List<String> contacts) {
    this.contacts = contacts;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", rank=" + rank + ", age=" + age + ", gender="
        + gender + ", dept=" + dept + ", city=" + city + ", contacts=" + contacts + "]";
  }

}
