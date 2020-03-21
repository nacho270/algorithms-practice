package com.nacho.collections.queue;

/**
 * Other point of view
 *
 * /** Implemented like
 *
 * Last ----------- first <br>
 * - 4 <- 3 <- 2 <- 1
 */
public class MyQueueWithLinkedOtherPOVList<T> implements MyQueue<T> {

  private Node first;
  private Node last;

  @Override
  public void enque(final T valueToAdd) {
    final Node newNode = new Node(valueToAdd);
    if (last == null) { // empty
      last = first = newNode;
      return;
    }
    last.next = newNode;
    last = newNode;
  }

  @Override
  public T poll() {
    final T value = first.value;
    first = first.next;
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
    Node temp = first;
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
