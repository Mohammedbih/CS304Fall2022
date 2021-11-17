package com.cs304.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DataStructure {

  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    q.add(5);
    q.add(9);
    q.add(1);
    q.add(3);

    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());

    System.out.println("**********************************");

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.add(5);
    pq.add(9);
    pq.add(1);
    pq.add(3);

    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());

    System.out.println("**********************************");

    PriorityQueue<User> x = new PriorityQueue<>();

    x.add(new User(2, "abdelghany", "pass", 10.5));
    x.add(new User(1, "mahmoud", "pass", 4.5));

    System.out.println(x.poll());

//    List<Integer> ls = new ArrayList<>();
//    ls.add(5);
//    ls.add(9);
//    ls.add(3);
//    ls.add(1);
//
//    Collections.sort(ls);
//
//    System.out.println(ls);

    System.out.println("**********************************");

    List<User> users = new ArrayList<>();
    users.add(new User(5, "abdelghany", "pass1", 14.6));
    users.add(new User(10, "mahmoud", "pass2", 19.6));
    users.add(new User(2, "ahmed", "pass3", 11.6));
    users.add(new User(7, "salma", "pass4", 17.6));

    Collections.sort(users);

    for (User user : users) {
      System.out.println(user);
    }


  }
}
