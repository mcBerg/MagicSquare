package org.berg.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MagicSquareTest {

  MagicSquare magicSquare;
  int[][] goodSquare;
  int[][] badSquare;
  int[][] nullSquare;
  int[][] zeroSquare;
  int[][] emptySquare;
  int[][] trickySquare;

  @Before
  public void setUp() {
    magicSquare = new MagicSquare();
    goodSquare = new int[][] {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
    badSquare = new int[][] {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    nullSquare = null;
    zeroSquare = new int[][] {{0}};
    emptySquare = new int[][] {{}};
    trickySquare = new int[][] {{2, 0, 0, 0}, {0, 0, 2, 0}, {0, 2, 0, 0}, {0, 0, 0, 2}};
  }

  @Test
  public void checkIsMagicSquareWithNull() {
    assertFalse(magicSquare.isMagicSquare(nullSquare));
  }

  @Test
  public void checkIsMagicSquareWithEmptyArray() {
    assertTrue(magicSquare.isMagicSquare(emptySquare));
  }

  @Test
  public void checkRealMagicSquareIsMagicSquare() {
    assertTrue(magicSquare.isMagicSquare(goodSquare));
  }

  @Test
  public void checkBadMagicSquareIsNotMagicSquare() {
    assertFalse(magicSquare.isMagicSquare(badSquare));
  }

  @Test
  public void checkZeroSquareIsMagicSquare() {
    assertTrue(magicSquare.isMagicSquare(zeroSquare));
  }

  @Test
  public void checkTrickySquareisNotMagicSquare() {
    assertFalse(magicSquare.isMagicSquare(trickySquare));
  }
}
