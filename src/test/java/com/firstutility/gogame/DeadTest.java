package com.firstutility.gogame;

import static com.firstutility.gogame.Dead.isDead;
import static org.junit.Assert.*;

import org.junit.Test;

public class DeadTest {

	// Black piece at 11
	@Test
	public void testBlackPiece11_NoWhite_NotDead() {
		int[][] board = {{0,0,0}, 
				         {0,1,0},
				         {0,0,0}};
		assertFalse("Should be alive", isDead(1,1, board));
	}

	@Test
	public void testBlackPiece11_WhiteAbove_NotDead() {
		int[][] board = {{0,2,0}, 
				         {0,1,0},
				         {0,0,0}};
		assertFalse("Should be alive", isDead(1,1, board));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelow_NotDead() {
		int[][] board = {{0,2,0}, 
				         {0,1,0},
				         {0,2,0}};
		assertFalse("Should be alive", isDead(1,1, board));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelowLeft_NotDead() {
		int[][] board = {{0,2,0}, 
				         {2,1,0},
				         {0,2,0}};
		assertFalse("Should be alive", isDead(1,1, board));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelowLeftRight_Dead() {
		int[][] board = {{0,2,0}, 
				         {2,1,2},
				         {0,2,0}};
		assertTrue("Should be dead", isDead(1,1, board));
	}

	// Black piece at 21
	@Test
	public void testBlackPiece21_NoWhite_NotDead() {
		int[][] board = {{0,0,0,0}, 
				         {0,0,1,0},
				         {0,0,0,0}};
		assertFalse("Should be alive", isDead(2,1, board));
	}

	@Test
	public void testBlackPiece21_WhiteAbove_NotDead() {
		int[][] board = {{0,0,2,0}, 
				         {0,0,1,0},
				         {0,0,0,0}};
		assertFalse("Should be alive", isDead(2,1, board));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelow_NotDead() {
		int[][] board = {{0,0,2,0}, 
				         {0,0,1,0},
				         {0,0,2,0}};
		assertFalse("Should be alive", isDead(2,1, board));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelowLeft_NotDead() {
		int[][] board = {{0,0,2,0}, 
				         {0,2,1,0},
				         {0,0,2,0}};
		assertFalse("Should be alive", isDead(2,1, board));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelowLeftRight_Dead() {
		int[][] board = {{0,0,2,0}, 
				         {0,2,1,2},
				         {0,0,2,0}};
		assertTrue("Should be dead", isDead(2,1, board));
	}

	// Prove that the prod code is taking the x and y values into account
	@Test
	public void testBlackPiece31_WhiteSurrounding11_Dead() {
		int[][] board = {{0,2,0,0,0}, 
				         {2,0,2,1,0},
				         {0,2,0,0,0}};
		assertFalse("Should be alive", isDead(3,1, board));
	}
	
	// Prove that the prod code can cope with the piece being on the edge
	@Test
	public void testBlackPieceOnTopRow_WhiteSurrounding_Dead() {
		int[][] board = {{2,1,2},
				         {0,2,0}};
		assertTrue("Should be dead", isDead(1,0, board));
	}
	
	@Test
	public void testBlackPieceOnLeftHandSide_WhiteSurrounding_Dead() {
		int[][] board = {{2,0},
				         {1,2},
				         {2,0}};
		assertTrue("Should be dead", isDead(0,1, board));
	}
	
	@Test
	public void testBlackPieceOnRightHandSide_WhiteSurrounding_Dead() {
		int[][] board = {{0,2},
				         {2,1},
				         {0,2}};
		assertTrue("Should be dead", isDead(1,1, board));
	}
	
	@Test
	public void testBlackPieceOnBottomRow_WhiteSurrounding_Dead() {
		int[][] board = {{0,2,0},
				         {2,1,2}};
		assertTrue("Should be dead", isDead(1,1, board));
	}

	// Prove corners work
	@Test
	public void testBlackPieceTopLeftCorner_WhiteSurrounding_Dead() {
		int[][] board = {{1,2},
				         {2,0}};
		assertTrue("Should be dead", isDead(0,0, board));
	}

	@Test
	public void testBlackPieceTopRightCorner_WhiteSurrounding_Dead() {
		int[][] board = {{2,1},
				         {0,2}};
		assertTrue("Should be dead", isDead(1,0, board));
	}

	@Test
	public void testBlackPieceBottomRightCorner_WhiteSurrounding_Dead() {
		int[][] board = {{0,2},
				         {2,1}};
		assertTrue("Should be dead", isDead(1,1, board));
	}

	@Test
	public void testBlackPieceBottomLeftCorner_WhiteSurrounding_Dead() {
		int[][] board = {{2,0},
				         {1,2}};
		assertTrue("Should be dead", isDead(0,1, board));
	}

	
}
