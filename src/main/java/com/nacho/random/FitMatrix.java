package com.nacho.random;

public class FitMatrix {

  private static final int FILLED = 1;

  static boolean canFit(final int[][] originalMatrix, final int[][] matrixToFit) {
    final int matrixToFitHeight = matrixToFit.length;
    final int matrixToFitWidth = matrixToFit[0].length;
    for (int row = 0; row <= originalMatrix.length - matrixToFitHeight; row++) {
      for (int col = 0; col <= originalMatrix[0].length - matrixToFitWidth; col++) {
        if (originalMatrix[row][col] == FILLED) {
          continue;
        }
        if (isEnoughSpace(originalMatrix, row, col, matrixToFitHeight, matrixToFitWidth)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isEnoughSpace(final int[][] originalMatrix, final int originalMatrixRowIndex, final int originalMatrixColIndex, //
      final int matrixToFitHeight, final int matrixToFitWidth) {

    final int requiredHeightIndex = originalMatrixRowIndex + matrixToFitHeight;
    final int requiredWidthIndex = originalMatrixColIndex + matrixToFitWidth;

    for (int row = originalMatrixRowIndex; row < requiredHeightIndex; row++) {
      for (int col = originalMatrixColIndex; col < requiredWidthIndex; col++) {
        if (originalMatrix[row][col] == FILLED) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(final String[] args) {
    final int[][] originalMatrix = { //
        { 1, 1, 1, 1, 1, 1, 1, 1 }, //
        { 1, 1, 0, 0, 0, 1, 1, 1 }, //
        { 1, 1, 0, 0, 0, 1, 1, 1 }, //
        { 1, 1, 1, 1, 1, 1, 1, 1 } };

    final int[][] matrixToFit = { //
        { 0, 0, 0 }, //
        { 0, 0, 1 } //
    };
    System.out.println(canFit(originalMatrix, matrixToFit));

    final int[][] matrixToFit2 = { //
        { 0, 0, 0 }, //
        { 0, 0, 0 } //
    };
    System.out.println(canFit(originalMatrix, matrixToFit2));

    final int[][] matrixToFit3 = { //
        { 0, 0, 0, 1 }, //
        { 0, 0, 0, 0 } //
    };
    System.out.println(canFit(originalMatrix, matrixToFit3));

  }
}
