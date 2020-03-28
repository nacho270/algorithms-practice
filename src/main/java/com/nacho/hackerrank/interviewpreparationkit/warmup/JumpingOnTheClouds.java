package com.nacho.hackerrank.interviewpreparationkit.warmup;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 *
 * Given an array of clouds (0 for "safe clouds", 1 for "unsafe" clouds), determine the minimum number of jumps necessary to reach the
 * end.<br>
 * The jumps can be of length 1 or 2. <br>
 */
public class JumpingOnTheClouds {

  static int jumpingOnClouds(final int[] clouds) {
    final int cloudsCount = clouds.length;
    int jumps = 0;
    int position = 0;

    while (position < cloudsCount - 3) {
      position += determineJump(clouds, position);
      jumps++;
    }
    return ++jumps; // last jump
  }

  private static int determineJump(final int[] clouds, final int currentPosition) {
    // always try to jump 2 places if possible. The more you jump 2 places, the shorter the number of jumps.
    if (isSafeToJump2Places(clouds, currentPosition)) {
      return 2;
    }
    return 1;
  }

  private static boolean isSafeToJump2Places(final int[] clouds, final int currentPosition) {
    return clouds[currentPosition + 2] == 0;
  }

  public static void main(final String[] args) {
    System.out.println(jumpingOnClouds(new int[] { 0, 0, 0, 0, 1, 0 }));
  }
}
