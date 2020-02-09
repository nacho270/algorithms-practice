package com.nacho.collections.queue;

public interface MyQueue<T> {

  void enque(final T valueToAdd);

  T poll();

  T peek();

  void print();

}
