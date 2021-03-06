package com.nacho.collections.queue;

/**
 * Implemented like
 *
 * Last ----------- first <br>
 * - 4 ---> 3 -> 2 -> 1
 *
 */
public class MyQueueWithLinkedList<T> implements MyQueue<T> {

  private Node first;
  private Node last;

  @Override
  public void enque(final T valueToAdd) {
    final Node newNode = new Node(valueToAdd);
    if (first == null) {
      first = newNode;
      last = newNode;
      return;
    }
    newNode.next = last;
    last = newNode;
  }

  @Override
  public T poll() {
    final T value = first.value;
    Node runner = last;
    while (runner.next != null) {
      if (runner.next.next == null) {
        break;
      }
      runner = runner.next;
    }
    runner.next = null;
    first = runner;
    if (first == null) {
      last = null;
    }
    return value;
  }

  @Override
  public T peek() {
    return first.value;
  }

  @Override
  public void print() {
    System.out.println("=======");
    Node temp = last;
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
