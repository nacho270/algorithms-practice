package com.nacho.collections.queue;

public class MainMyQueue {

  public static void main(final String[] args) {
    final MyQueue<Integer> stack = new MyQueueWithArray<>();
    stack.enque(5);
    stack.enque(10);
    stack.enque(200);
    stack.print();
    System.out.println("peek: " + stack.peek());
    stack.print();
    System.out.println("poll: " + stack.poll());
    stack.print();
  }
}
