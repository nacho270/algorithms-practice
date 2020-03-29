package com.nacho.crackingthecodinginterview.stacksandqueues;

import java.util.Stack;

/**
 * Implement a stack with a "min" method that will return the smallest element. Push, pop and min must be O(1)
 */
public class Question3_2_StackMin {

  private static class StackMin extends Stack<Integer> {

    private static final long serialVersionUID = 1603419633670023155L;

    private final Stack<Integer> mins = new Stack<>();

    @Override
    public Integer push(final Integer item) {
      if (mins.isEmpty() || item < min()) {
        mins.push(item);
      }
      return super.push(item);
    }

    @Override
    public Integer pop() {
      final Integer pop = super.pop();
      if (pop == min()) {
        mins.pop();
      }
      return pop;
    }

    public Integer min() {
      if (mins.isEmpty()) {
        return Integer.MAX_VALUE;
      }
      return mins.peek();
    }
  }

  public static void main(final String[] args) {
    final StackMin minStack = new StackMin();
    minStack.push(7);
    minStack.push(3);
    minStack.push(54);
    minStack.push(1);
    minStack.push(45);
    minStack.push(100);
    System.out.println("Initial values");
    System.out.println(minStack);
    System.out.println("Min: " + minStack.min());
    minStack.push(-1);
    System.out.println("Min: " + minStack.min());
    minStack.pop();
    minStack.pop();
    System.out.println("Min: " + minStack.min());
  }
}
