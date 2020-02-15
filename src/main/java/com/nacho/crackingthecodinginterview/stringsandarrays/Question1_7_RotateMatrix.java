package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * Rotate a NxN (square) matrix by 90 degrees. Can be done in place or copying to a new matrix.
 *
 */
public class Question1_7_RotateMatrix {

  private static int[][] rotate(final int[][] mat) {
    final int[][] newMat = new int[mat.length][mat[0].length];
    int newMatIndex = mat[0].length - 1;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        newMat[j][newMatIndex] = mat[i][j];
      }
      newMatIndex--;
    }
    return newMat;
  }

  private static void rotateInPlace(final int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      final int last = mat.length - 1 - i;
      for (int j = i; j < last; j++) {
        final int offset = j - i;
        final int top = mat[i][j]; // save upper left
        mat[i][j] = mat[last - offset][i]; // upper left = lower left
        mat[last - offset][i] = mat[last][last - offset]; // lower left = lower right
        mat[last][last - offset] = mat[j][last]; // lower right = upper right
        mat[j][last] = top; // upper right = upper left
      }
    }
    System.out.println("= ROTATE IN PLACE =");
    print(mat);
  }

  private static void print(final int[][] mat) {
    for (final int[] element : mat) {
      for (final int element2 : element) {
        System.out.print(element2);
      }
      System.out.print("\n");
    }
  }

  public static void main(final String[] args) {
    final int[][] mat = new int[][] { //
        { 1, 2, 3 }, //
        { 4, 5, 6 }, //
        { 7, 8, 9 } };
    System.out.println("Original:");
    print(mat);
    System.out.println("= ROTATE BY COPY =");
    print(rotate(mat));
    rotateInPlace(mat);
  }
}
