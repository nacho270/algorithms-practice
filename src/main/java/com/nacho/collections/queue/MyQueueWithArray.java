package com.nacho.collections.queue;

public class MyQueueWithArray<T> implements MyQueue<T> {

  private Object values[] = new Object[10];
  private int count = 0;
  private int front = 0;
  private int rear = -1;

  @Override
  public void enque(final T valueToAdd) {
    // skip array growth
    values[++rear] = valueToAdd;
    count++;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T poll() {
    final T value = (T) values[front++];
    count--;
    return value;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T peek() {
    return (T) values[front];
  }

  @Override
  public void print() {
    System.out.println("======");
    for (int i = rear; i >= front; i--) {
      System.out.println(values[i]);
    }
  }

}
