package com.cs304.old.lab5;

public class User implements Comparable<User> {

  private int id;
  private String name;
  private String password;
  private double salary;

  public User() {
  }

  public User(int id, String name, String password, double salary) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.salary = salary;
  }

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", salary=" + salary +
        '}';
  }

  @Override
  public int compareTo(User o) {
    if (o.id == this.id) {
      return 0;
    } else if (o.id > this.id) {
      return -1;
    }
    return 1;
  }
}
