package com.nacho.hackerrank.interviewpreparationkit.arrays;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 *
 * Given an array and a number of rotations, perform those LEFT rotations. <br>
 * Example: [1, 2, 3, 4, 5], rotations = 4 <br>
 *
 * Rot1: [2, 3, 4, 5, 1] <br>
 * Rot2: [3, 4, 5, 1, 2] <br>
 * Rot3: [4, 5, 1, 2, 3] <br>
 * Rot4: [5, 1, 2, 3, 4] <br>
 *
 * Result: [5, 1, 2, 3, 4]
 *
 */
public class RotateLeft {
  static int[] rotLeft(final int[] a, final int d) {
    final int rotations = d % a.length;
    if (a == null || rotations == 0) {
      return a;
    }
    final int[] rotatedArray = new int[a.length];
    int rotatedArrayIndex = 0;
    for (int i = rotations; i < a.length; i++) {
      rotatedArray[rotatedArrayIndex++] = a[i];
    }
    for (int i = 0; i < rotations; i++) {
      rotatedArray[rotatedArrayIndex++] = a[i];
    }
    return rotatedArray;
  }

  public static void main(final String[] args) {
    final int[] rotLeft = rotLeft(new int[] { 1, 2, 3, 4, 5 }, 4);
    for (int i = 0; i < rotLeft.length; i++) {
      System.out.println(rotLeft[i]);
    }
  }
}
