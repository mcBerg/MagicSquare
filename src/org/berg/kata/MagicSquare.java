package org.berg.kata;

import java.util.Arrays;

public class MagicSquare {

  public MagicSquare() {
    // nothing to see here.
  }

  public boolean isMagicSquare(int[][] inputArray) {
    if (inputArray == null) {
      return false;
    }
    if (inputArray.length == 0 || inputArray.length == 1) {
      return true;
    }

    // is it possible to have a square such that:
    // all horizontals = x,
    // all verticals = y,
    // and all diagonals = z
    // but !(x==y==z)?

    // 2 0 0 0
    // 0 0 2 0
    // 0 2 0 0
    // 0 0 0 2

    // yes! :. we must check the horiz sum vs the vertical sum vs the diagonal sum as well.

    return (checkHorizontals(inputArray)
        && checkVerticals(inputArray)
        && checkDiagonals(inputArray)
        && checkEquals(inputArray));
  }

  private boolean checkEquals(int[][] inputArray) {
    int row = Arrays.stream(inputArray[0]).sum();

    int[] column = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      System.arraycopy(inputArray[i], 0, column, i, 1);
    }
    int col = Arrays.stream(column).sum();

    int[] diagonal = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      System.arraycopy(inputArray[i], i, diagonal, i, 1);
    }
    int diag = Arrays.stream(diagonal).sum();

    return row == col && col == diag;
  }

  private boolean checkDiagonals(int[][] inputArray) {
    int[] downDiagonal = new int[inputArray.length];
    int[] upDiagonal = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      downDiagonal[i] = inputArray[i][i];
      upDiagonal[i] = inputArray[inputArray.length - 1 - i][i];
    }
    return sum(downDiagonal) == sum(upDiagonal);
  }

  private boolean checkVerticals(int[][] inputArray) {
    int sum = 0;
    int[] column;
    for (int col = 0; col < inputArray.length; col++) {
      column = new int[inputArray.length];
      for (int index = 0; index < inputArray.length; index++) {
        System.arraycopy(inputArray[index], col, column, index, 1);
      }
      if (sum == 0) {
        sum = sum(column);
      } else {
        if (sum != sum(column)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean checkHorizontals(int[][] inputArray) {
    int sum = 0;
    for (int[] row : inputArray) {
      if (sum == 0) {
        sum = sum(row);
      } else {
        if (sum != sum(row)) {
          return false;
        }
      }
    }
    return true;
  }

  private int sum(int[] ints) {
    return Arrays.stream(ints).sum();
  }
}
