package com.cs304.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {

  public static void main(String[] args) {
//    List<Character> list = new ArrayList<>();
//    list.add('C');
//    list.add('B');
//    list.add('T');
//    list.add('U');
//
//    for (int i = 0; i < list.size(); i++) {
//      System.out.print(list.get(i) + " ");
//    }
//    System.out.println();

//    Stack<String> st = new Stack<>();
//    st.push("ahmed");
//    st.push("salma");
//    st.push("ali");
//    st.push("heba");
//
//    System.out.println(st.pop());
//    System.out.println(st.peek());
//    System.out.println(st.pop());

//    Queue<Double> qu = new LinkedList<>();
//    qu.add(15.7);
//    qu.add(9.7);
//    qu.add(4.7);
//    qu.add(3.9);
//
//    System.out.println("queue size = " + qu.size());
//    System.out.println(qu.peek());
//    System.out.println(qu.poll());
//    System.out.println(qu.poll());
//    System.out.println("queue size = " + qu.size());

//    Set<Integer> st1 = new HashSet<>();
//    st1.add(5);
//    st1.add(5);
//    st1.add(5);
//    st1.add(5);
//    st1.add(6);
//    st1.add(6);
//    st1.add(9);
//    st1.add(10);
//    st1.add(12);
//    st1.add(null);
//
//    System.out.println("Set size = " + st1.size());
//    System.out.println("contains 6 " + st1.contains(6));
//    System.out.println("contains 15 " + st1.contains(15));
//    System.out.println(st1);

//    Set<Integer> st2 = new TreeSet<>();
//    st2.add(5);
//    st2.add(5);
//    st2.add(5);
//    st2.add(5);
//    st2.add(6);
//    st2.add(6);
//    st2.add(9);
//    st2.add(10);
//    st2.add(12);
////    st2.add(null);
//
//    System.out.println("Set size = " + st2.size());
//    System.out.println("contains 6 " + st2.contains(6));
//    System.out.println("contains 15 " + st2.contains(15));
//    System.out.println(st2);

//    Map<String, Long> mp1 = new HashMap<>();
//    mp1.put("abdelghany", 45L);
//    mp1.put("abdelghany", 96L);
//    mp1.put("ahmed", 21L);
//    mp1.put("salma", 84L);
//    mp1.put(null, 99L);
//
//    System.out.println("map size = " + mp1.size());
//    System.out.println(mp1.containsKey("abdelghany") ? mp1.get("abdelghany") : "abdelghany not exist");
//    System.out.println(mp1.containsKey("mahmoud") ? mp1.get("mahmoud") : "mahmoud not exist");

//    Map<String, Long> mp2 = new TreeMap<>();
//    mp2.put("abdelghany", 45L);
//    mp2.put("abdelghany", 96L);
//    mp2.put("ahmed", 21L);
//    mp2.put("salma", 84L);
////    mp2.put(null, 99L);
//
//    System.out.println("map size = " + mp2.size());
//    System.out.println(mp2.containsKey("abdelghany") ? mp2.get("abdelghany") : "abdelghany not exist");
//    System.out.println(mp2.containsKey("mahmoud") ? mp2.get("mahmoud") : "mahmoud not exist");

//    Node n1 = new Node(3, null);
//    Node n2 = new Node(5, n1);
//    Node n3 = new Node(7, n2);
//    Node n4 = new Node(9, n3);

    LinkedList2 ls = new LinkedList2();

    ls.add(15);
    ls.add(9);
    ls.add(3);
    ls.add(17);

    ls.print();

  }
}

class LinkedList2 {

  Node start;
  Node end;

  void add(int value) {

    Node tmp = new Node(value, null);

    if (start == null) {

      start = tmp;
      end = tmp;
    } else {
      end.next = tmp;
      end = end.next;
    }
  }

  void print() {
    Node tmp = start;
    while (tmp != null) {
      System.out.println(tmp.val);
      tmp = tmp.next;
    }
  }
}

class Node {

  int val;
  Node next;

  Node(int val, Node next) {
    this.val = val;
    this.next = next;
  }
}
