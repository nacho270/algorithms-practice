package com.nacho.crackingthecodinginterview.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement a data structure composed of many stacks such as when one stack is full, the new elements are added to a new one.<br>
 * When push, pop or peek, the data should come from the last stack.
 *
 * <br>
 *
 * Follow up: implement a popAt(stackId) that will pop the element of the specified stack.<br>
 * After that, one stack might not be full and it would be as there were a hole in the stack. <br>
 * Example: Stack size 3 <br>
 * 1) Push elements until reaching: 3 - 3 - 1 <br>
 * 2) popAt(0) -> 2 - 3 - 1 <br>
 * 3) Should put the bottom of the following stack on the top of the with space... and so until the end.<br>
 * The stack becomes: 3 - 3 - 0 <br>
 *
 * At first, i thought on levaing an empty spot on the stack and add the following element there... but that would break the insertion order
 * of the stack. On the other side, it might be more efficient to leave the empty space to avoid shifting the elements.
 */
public class Question3_3_StackOfPlates {

  private static class SetOfStacks<E> {

    private final List<Stack<E>> stacks = new ArrayList<>();
    private final int maxStackSize;

    public SetOfStacks(final int maxStackSize) {
      this.maxStackSize = maxStackSize;
      stacks.add(new Stack<>());
    }

    public E push(final E item) {
      final Stack<E> lastStack = lastStack();
      if (lastStack.size() < maxStackSize) {
        return lastStack.push(item);
      }
      final Stack<E> newStack = new Stack<>();
      newStack.push(item);
      stacks.add(newStack);
      return item;
    }

    private Stack<E> lastStack() {
      return stacks.get(lastStackIndex());
    }

    private int lastStackIndex() {
      return stacks.size() - 1;
    }

    public E pop() {
      final Stack<E> lastStack = lastStack();
      final E item = lastStack.pop();
      if (lastStack.isEmpty()) {
        stacks.remove(lastStackIndex());
      }
      return item;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("{");
      for (final Stack<E> s : stacks) {
        sb.append(s).append(",");
      }
      return sb.append("}").toString();
    }
  }

  public static void main(final String[] args) {
    final SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
    setOfStacks.push(1);
    setOfStacks.push(2);
    setOfStacks.push(3);
    setOfStacks.push(4);
    setOfStacks.push(5);
    setOfStacks.push(6);
    System.out.println(setOfStacks);
    System.out.println("Pop: " + setOfStacks.pop());
    System.out.println(setOfStacks);
    System.out.println("Pop: " + setOfStacks.pop());
    System.out.println(setOfStacks);
  }

}
