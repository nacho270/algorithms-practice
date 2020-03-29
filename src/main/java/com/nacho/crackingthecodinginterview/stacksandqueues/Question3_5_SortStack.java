package com.nacho.crackingthecodinginterview.stacksandqueues;

import java.util.Stack;

/**
 * Implement a queue using 2 stacks
 */
public class Question3_5_SortStack {

  private static <T extends Comparable<T>> void sortStack(final Stack<T> stack) {
    final Stack<T> temp = new Stack<>();
    while (!stack.isEmpty()) {
      final T element = stack.pop();
      /**
       * Take an element from the stack.<br>
       * If it's smaller than what's on the top of the other one, it means it has to on a lower position of the temp stack<br>
       * Move from the temp to the main stack until the element is not small any more<br>
       * Push the element to the temp stack.
       */
      while (!temp.isEmpty() && element.compareTo(temp.peek()) < 0) {
        stack.push(temp.pop());
      }
      temp.push(element);
    }
    // At this point we have the temporary stack sorted with the HIGHER values on top, transfer to main to get the SMALLER values on top.
    while (!temp.isEmpty()) {
      stack.push(temp.pop());
    }
  }

  public static void main(final String[] args) {
    final Stack<Integer> s = new Stack<>();
    s.push(5);
    s.push(1);
    s.push(10);
    s.push(-2);
    s.push(0);
    s.push(3);
    s.push(2);
    sortStack(s);
    for (int i = 0; i < s.size(); i++) {
      System.out.println(s.get(i));
    }
  }

}
