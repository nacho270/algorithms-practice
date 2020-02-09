package com.nacho.collections.linkedlist;

public class MainLinkedList {

  public static void main(final String[] args) {
    final MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(5);
    list.add(10);
    list.add(20);

    list.print();

    System.out.println("Is 10 present? " + list.isPresent(10));
    System.out.println("Is 7 present? " + list.isPresent(7));
    list.remove(10);
    list.print();
    list.insert(0, 7);
    list.print();
    list.insert(1, 77);
    list.print();
    list.insert(4, 1);
    list.print();
    list.reverse();
    list.print();
  }

}
