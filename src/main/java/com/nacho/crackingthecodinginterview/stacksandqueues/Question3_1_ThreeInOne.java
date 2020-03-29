package com.nacho.crackingthecodinginterview.stacksandqueues;

/**
 * Implement 3 stacks using one single array.
 *
 * Implemented using static size arrays but without hardcoding the number of arrays.
 */
public class Question3_1_ThreeInOne {

  private static class MultiStackArray {

    private int stackSize;
    private int[] values;
    private int[] sizes;

    public MultiStackArray(final int stackSize, final int stackCount) {
      this.stackSize = stackSize;
      this.values = new int[stackCount * stackSize];
      this.sizes = new int[stackCount];
    }

    public void push(final int stack, final int value) {
      if (sizes[stack] == stackSize) {
        throw new RuntimeException("Stack " + stack + " already full");
      }
      values[indexOfTop(stack)] = value;
      sizes[stack]++;
    }

    private int indexOfTop(final int stack) {
      int offset = stack * stackSize;
      return offset + sizes[stack];
    }

    public int pop(final int stack) {
      final int value = peek(stack);
      values[indexOfTop(stack) - 1] = 0;
      sizes[stack]--;
      return value;
    }

    public int peek(final int stack) {
      if (sizes[stack] == 0) {
        throw new RuntimeException("Stack " + stack + " is empty");
      }
      return values[indexOfTop(stack) - 1];
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("{");
      for (int sizeIndex = 0; sizeIndex < sizes.length; sizeIndex++) {
        sb.append("[");
        for (int i = sizeIndex * stackSize; i < sizeIndex * stackSize + stackSize; i++) {
          sb.append(values[i] + ",");
        }
        sb.append("],");
      }
      return sb.append("}").toString();
    }
  }

  public static void main(final String[] args) {
    final MultiStackArray stacks = new MultiStackArray(5, 3);
    stacks.push(0, 1);
    stacks.push(0, 3);
    stacks.push(0, 7);

    stacks.push(1, 54);
    stacks.push(1, 45);

    stacks.push(2, 100);
    System.out.println("Initial values");
    System.out.println(stacks);

    System.out.println("Pop from 0: " + stacks.pop(0));
    System.out.println("Pop from 1: " + stacks.pop(1));
    System.out.println("Pop from 2: " + stacks.pop(2));

    System.out.println("After pop");
    System.out.println(stacks);
  }
}
