package com.nacho.collections.stack;

public class MyStackWithLinkedList<T> implements MyStack<T> {

  private Node head;

  @Override
  public void push(final T valueToAdd) {
    if (head == null) {
      head = new Node(valueToAdd);
      return;
    }
    final Node oldHead = head;
    head = new Node(valueToAdd);
    head.next = oldHead;
  }

  @Override
  public T pop() {
    final T value = head.value;
    head = head.next;
    return value;
  }

  @Override
  public T peek() {
    return head.value;
  }

  @Override
  public void print() {
    System.out.println("=======");
    Node temp = head;
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
