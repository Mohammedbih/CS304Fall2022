package com.cs304.old.lab2dec;

import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    List<Integer> x = new ArrayList<>();
    x.add(6);
    x.add(9);
    x.add(7);
    x.add(6);

    List<Integer> x2 = new ArrayList<>();
    x2.add(6);
    x2.add(9);


    int[][] mat = new int[5][5];

    List<List<Integer>> y = new ArrayList<>();
    y.add(x);
    y.add(x2);

    System.out.println("x=" + x);
    System.out.println("x2=" + x2);
    System.out.println("y=" + y);


  }
}
