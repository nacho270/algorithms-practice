package com.nacho.hackerrank.interviewpreparationkit.arrays;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 *
 * Given an array of integer representing the theoretical place of people in a queue, determine the minium number of "bribes" that took
 * place in order to make the queue lose its order.
 *
 * In person can bribe up 2 persons in front. <br>
 * Example: The theoretical order would 1, 2, 3, 4 and 5. The given array is: [1, 2, 5, 3, 4]. Person 5 bribed persons 3 and 4.<br>
 *
 * Print the number of bribes or "too chaotic" if the given queue configuration is not possible given the "up to 2 bribes" rule.
 */
public class NewYearChaos {

  static void minimumBribes(final int[] q) {
    if (q == null) {
      return;
    }

    int bribes = 0;
    boolean chaotic = false;

    for (int i = 0; i < q.length; i++) {
      final int distanceWithTheoreticalPlace = q[i] - (i + 1);
      if (distanceWithTheoreticalPlace > 2) {
        chaotic = true;
        break;
      }
      bribes += bribesUpTolHere(q, i);
    }

    if (chaotic) {
      System.out.println("Too chaotic");
      return;
    }
    System.out.println(bribes);
  }

  private static int bribesUpTolHere(final int[] q, final int i) {
    int bribes = 0;
    final int last2OrBegining = Math.max(0, q[i] - 2);
    for (int j = last2OrBegining; j < i; j++) {
      if (q[j] > q[i]) {
        bribes++;
      }
    }
    return bribes;
  }

  public static void main(final String[] args) {
    minimumBribes(new int[] { 2, 1, 5, 3, 4 });
    minimumBribes(new int[] { 2, 5, 1, 3, 4 });
  }
}
