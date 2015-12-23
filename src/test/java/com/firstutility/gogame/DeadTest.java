package com.firstutility.gogame;

import static com.firstutility.gogame.Dead.isDead;
import static org.junit.Assert.*;

import org.junit.Test;

public class DeadTest {

	// Black in Top Left Corner Tests
	@Test
	public void testBlackPieceInCorner_NoWhite_NotDead() {
		int[][] board = {{1,0}, 
				         {0,0}};
		assertFalse("Should be alive", isDead(0,0, board));
	}

	@Test
	public void testBlackPieceInCorner_WhiteToTheRight_NotDead() {
		int[][] board = {{1,2}, 
				         {0,0}};
		assertFalse("Should be alive", isDead(0,0, board));
	}

	@Test
	public void testBlackPieceInCorner_SurroundedByWhite_Dead() {
		int[][] board = {{1,2}, 
				         {2,0}};
		assertTrue("Should be dead", isDead(0,0, board));
	}

	// Back on Top Edge, on in from right edge
	@Test
	public void testBlackPieceOnTopEdge_NoWhite_NotDead() {
		int[][] board = {{0, 1, 0}, 
				         {0, 0, 0}};
		assertFalse("Should be alive", isDead(1,0, board));
	}

	@Test
	public void testBlackPieceOnTopEdge_WhiteToRight_NotDead() {
		int[][] board = {{0, 1, 2}, 
				         {0, 0, 0}};
		assertFalse("Should be alive", isDead(1,0, board));
	}

	@Test
	public void testBlackPieceOnTopEdge_WhiteToBothRightAndLeft_NotDead() {
		int[][] board = {{2, 1, 2}, 
				         {0, 0, 0}};
		assertFalse("Should be alive", isDead(1,0, board));
	}

	@Test
	public void testBlackPieceOnTopEdge_SurroundedByWhite_Dead() {
		int[][] board = {{2, 1, 2}, 
				         {0, 0, 0}};
		assertTrue("Should be dead", isDead(1,0, board));
	}

}
