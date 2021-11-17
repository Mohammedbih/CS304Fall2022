package com.cs304.lab4;

public interface Database {

  void connect();

  void add();

  Object get();

  void update();

  void delete();
}
