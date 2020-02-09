package com.nacho.collections.stack;

public class MyStackWithArray<T> implements MyStack<T> {

  private Object[] values = new Object[10];
  private int count = 0;

  @Override
  public void push(final T valueToAdd) {
    values[count++] = valueToAdd;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T pop() {
    return (T) values[--count];
  }

  @Override
  @SuppressWarnings("unchecked")
  public T peek() {
    return (T) values[count - 1];
  }

  @Override
  public void print() {
    System.out.println("====");
    for (int i = count - 1; i >= 0; i--) {
      System.out.println(values[i]);
    }
  }

}
