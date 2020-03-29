package com.nacho.crackingthecodinginterview.stacksandqueues;

import java.util.Stack;

/**
 * Implement a queue using 2 stacks
 */
public class Question3_4_QueueViaStack {

  private static class QueueViaStack<T> {
    private Stack<T> newElements = new Stack<>();
    private Stack<T> oldElements = new Stack<>();

    public void enqueue(final T element) {
      newElements.push(element);
    }

    public T dequeue() {
      moveElementsToOldStack();
      return oldElements.pop();
    }

    public T peek() {
      moveElementsToOldStack();
      return oldElements.peek();
    }

    private void moveElementsToOldStack() {
      if (oldElements.isEmpty()) {
        while (!newElements.isEmpty()) {
          oldElements.push(newElements.pop());
        }
      }
    }

  }

  public static void main(final String[] args) {
    final QueueViaStack<Integer> q = new QueueViaStack<>();
    q.enqueue(5);
    System.out.println(q.peek());
    q.enqueue(6);
    q.enqueue(7);
    System.out.println(q.peek());
    System.out.println(q.dequeue());
  }

}
