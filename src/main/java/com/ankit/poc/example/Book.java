package com.ankit.poc.example;

import java.util.Objects;

public class Book {
  private int id;
  private String name;
  private int pages;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, pages);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Book other = (Book) obj;
    if (id != other.id) {
      return false;
    }
    if (!Objects.equals(name, other.name)) {
      return false;
    }
    if (pages != other.pages) {
      return false;
    }
    return true;
  }

  public Book() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Book(int id, String name, int pages) {
    super();
    this.id = id;
    this.name = name;
    this.pages = pages;
  }

}
