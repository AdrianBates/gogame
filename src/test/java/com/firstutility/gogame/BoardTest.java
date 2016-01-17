package com.firstutility.gogame;

import static com.firstutility.gogame.LocationListBuilder.aLocationList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BoardTest {

	// Black piece at 11
	@Test
	public void testBlackPiece11_NoWhite_NotDead() {
		int[][] layout = {{0,0,0}, 
				          {0,1,0},
				          {0,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAbove_NotDead() {
		int[][] layout = {{0,2,0}, 
				          {0,1,0},
				          {0,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelow_NotDead() {
		int[][] layout = {{0,2,0}, 
				          {0,1,0},
				          {0,2,0}}; 	
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelowLeft_NotDead() {
		int[][] layout = {{0,2,0}, 
				          {2,1,0},
				          {0,2,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelowLeftRight_Dead() {
		int[][] layout = {{0,2,0}, 
				          {2,1,2},
				          {0,2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}

	// Black piece at 21
	@Test
	public void testBlackPiece21_NoWhite_NotDead() {
		int[][] layout = {{0,0,0,0}, 
				          {0,0,1,0},
				          {0,0,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAbove_NotDead() {
		int[][] layout = {{0,0,2,0}, 
				          {0,0,1,0},
				          {0,0,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelow_NotDead() {
		int[][] layout = {{0,0,2,0}, 
				          {0,0,1,0},
				          {0,0,2,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelowLeft_NotDead() {
		int[][] layout = {{0,0,2,0}, 
				          {0,2,1,0},
				          {0,0,2,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelowLeftRight_Dead() {
		int[][] layout = {{0,0,2,0}, 
				          {0,2,1,2},
				          {0,0,2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(2,1));
	}

	// Prove that the prod code is taking the x and y values into account
	@Test
	public void testBlackPiece31_WhiteSurrounding11_Dead() {
		int[][] layout = {{0,2,0,0,0}, 
				          {2,0,2,1,0},
				          {0,2,0,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(3,1));
	}
	
	// Prove that the prod code can cope with the piece being on the edge
	@Test
	public void testBlackPieceOnTopRow_WhiteSurrounding_Dead() {
		int[][] layout = {{2,1,2},
				          {0,2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,0));
	}
	
	@Test
	public void testBlackPieceOnLeftHandSide_WhiteSurrounding_Dead() {
		int[][] layout = {{2,0},
				          {1,2},
				          {2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(0,1));
	}
	
	@Test
	public void testBlackPieceOnRightHandSide_WhiteSurrounding_Dead() {
		int[][] layout = {{0,2},
				          {2,1},
				          {0,2}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void testBlackPieceOnBottomRow_WhiteSurrounding_Dead() {
		int[][] layout = {{0,2,0},
				          {2,1,2}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}

	// Prove corners work
	@Test
	public void testBlackPieceTopLeftCorner_WhiteSurrounding_Dead() {
		int[][] layout = {{1,2},
				          {2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(0,0));
	}

	@Test
	public void testBlackPieceTopRightCorner_WhiteSurrounding_Dead() {
		int[][] layout = {{2,1},
				          {0,2}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,0));
	}

	@Test
	public void testBlackPieceBottomRightCorner_WhiteSurrounding_Dead() {
		int[][] layout = {{0,2},
				          {2,1}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}

	@Test
	public void testBlackPieceBottomLeftCorner_WhiteSurrounding_Dead() {
		int[][] layout = {{2,0},
				          {1,2}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(0,1));
	}

	// Multiple black pieces
	@Test
	public void test2BlackPieces_OneBelowTheOther_FullySurrounded_Dead() {
		int[][] layout = {{0,2,0}, 
				          {2,1,2},
				          {2,1,2},
				          {0,2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void test2BlackPieces_OneBelowTheOther_NotSurrounded_Dead() {
		int[][] layout = {{0,2,0}, 
				          {2,1,2},
				          {2,1,2},
				          {0,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}
	
	@Test
	public void test2BlackPieces_OneToTheRightOfTheOther_Surrounded_Dead() {
		int[][] layout = {{0,2,2,0}, 
				          {2,1,1,2},
				          {0,2,2,0}};
		Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void test2BlackPieces_OneToTheRightOfTheOther_NotSurrounded_NotDead() {
		int[][] layout = {{0,2,2,0}, 
				          {2,1,1,2},
				          {0,2,0,0}};
		Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}
	
	@Test
	public void testLocationList_BlackPiece11_NoWhite() {
		int[][] layout = {{0,0,0}, 
				          {0,1,0}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 1).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_BlackPiece10_NoWhite() {
		int[][] layout = {{0,1,0}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}

	@Test
	public void testLocationList_2BlackPiece10_NoWhite() {
		int[][] layout = {{0,1,1}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 0).location(2, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}

	@Test
	public void testLocationList_2BlackPiece11() {
		int[][] layout = {{0,0,0},
				          {0,1,1}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 1).location(2, 1).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_3BlackPiece11_Horizontal() {
		int[][] layout = {{1,1,1}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 0).location(0, 0).location(2, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}

	@Test
	public void testLocationList_3BlackPiece_Vertical() {
		int[][] layout = {{0,1,0},
				          {0,1,0},
				          {0,1,0}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 1).location(1, 0).location(1, 2).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_5BlackPiece_Cross() {
		int[][] layout = {{0,1,0},
				          {1,1,1},
				          {0,1,0}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 1).location(0, 1).location(2, 1).location(1, 0).location(1, 2).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_4BlackPiece11_Horizontal() {
		int[][] layout = {{1,1,1,1}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 0).location(0, 0).location(2, 0).location(3, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}
	
	@Test
	public void testLocationList_6BlackPiece_Cross() {
		int[][] layout = {{0,1,1},
				          {1,1,1},
				          {0,1,0}};
		Board board = new Board(layout);
		
		List<Location> expectedLocations = aLocationList().location(1, 1).location(0, 1).location(2, 1).location(2, 0).location(1, 0).location(1, 2).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}


}
