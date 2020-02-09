package com.nacho.collections.stack;

public class MyStackWithLinkedList<T> implements MyStack<T> {

  private Node root;

  @Override
  public void push(final T valueToAdd) {
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

  @Override
  public T pop() {
    Node temp = root;
    while (temp.next.next != null) {
      temp = temp.next;
    }

    final T value = temp.next.value;
    temp.next = null;
    return value;
  }

  @Override
  public T peek() {
    Node temp = root;
    while (temp.next != null) {
      temp = temp.next;
    }
    return temp.value;
  }

  @Override
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
