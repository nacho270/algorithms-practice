package com.nacho.collections.linkedlist;

public class MyLinkedList<T> {

  private Node root;

  public void reverse() {
    Node prev = null;
    Node temp = root;
    while (temp != null) {
      final Node next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;
    }
    root = prev;
  }

  public void add(final T valueToAdd) {
    if (root == null) {
      root = new Node(valueToAdd);
      return;
    }
    Node temp = root;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(valueToAdd);
  }

  public void insert(final int positionToInsert, final T valueToInsert) {
    final Node nodeToInsert = new Node(valueToInsert);
    if (positionToInsert == 0) {
      nodeToInsert.next = root;
      root = nodeToInsert;
      return;
    }
    int tempPosition = 0;
    Node prev = null;
    Node temp = root;
    while (temp != null && tempPosition < positionToInsert) {
      prev = temp;
      temp = temp.next;
      tempPosition++;
    }
    if (tempPosition == positionToInsert) {
      prev.next = nodeToInsert;
      nodeToInsert.next = temp;
    }
  }

  public void remove(final T valueToRemove) {
    if (root.value.equals(valueToRemove)) {
      root = root.next;
      return;
    }
    Node prev = null;
    Node temp = root;
    while (temp != null && !temp.value.equals(valueToRemove)) {
      prev = temp;
      temp = temp.next;
    }
    if (temp != null) {
      prev.next = temp.next;
    }
  }

  public boolean isPresent(final T valueToSearch) {
    Node temp = root;
    while (temp != null) {
      if (temp.value.equals(valueToSearch)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  public void print() {
    System.out.println("=======");
    Node temp = root;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  private class Node {
    private T value;
    private Node next;

    public Node(final T value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value.toString();
    }
  }
}
