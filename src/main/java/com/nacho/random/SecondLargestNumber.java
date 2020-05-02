package com.nacho.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SecondLargestNumber {

  private static int findSecondToLargest(final Set<Integer> numbers) {
    int max = numbers.iterator().next();
    int secondMax = max;
    for (final Integer number : numbers) {
      if (number > max) {
        secondMax = max;
        max = number;
      } else if (number > secondMax) {
        secondMax = number;
      }
    }
    return secondMax;
  }

  public static void main(final String[] args) {
    System.out.println("Second to largest(2,98,44,66,0,6): " + findSecondToLargest(new HashSet<>() {
      private static final long serialVersionUID = 1L;

      {
        addAll(Arrays.asList(2, 98, 44, 66, 0, 6));
      }
    }));
  }

}
