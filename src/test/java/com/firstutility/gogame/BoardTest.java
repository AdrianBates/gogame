package com.firstutility.gogame;

import static com.firstutility.gogame.LocationListBuilder.aLocationList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static com.firstutility.gogame.State.*;

import java.util.List;

import org.junit.Test;

public class BoardTest {

	// Black piece at 11
	@Test
	public void testBlackPiece11_NoWhite_NotDead() {
		State[][] layout = {{E,E,E}, 
				            {E,B,E},
				            {E,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAbove_NotDead() {
		State[][] layout = {{E,W,E}, 
				            {E,B,E},
				            {E,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelow_NotDead() {
		State[][] layout = {{E,W,E}, 
				            {E,B,E},
				            {E,W,E}}; 	
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelowLeft_NotDead() {
		State[][] layout = {{E,W,E}, 
				            {W,B,E},
				            {E,W,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	@Test
	public void testBlackPiece11_WhiteAboveBelowLeftRight_Dead() {
		State[][] layout = {{E,W,E}, 
				            {W,B,W},
				            {E,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}

	// Black piece at 21
	@Test
	public void testBlackPiece21_NoWhite_NotDead() {
		State[][] layout = {{E,E,E,E}, 
				            {E,E,B,E},
				            {E,E,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAbove_NotDead() {
		State[][] layout = {{E,E,W,E}, 
				            {E,E,B,E},
				            {E,E,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelow_NotDead() {
		State[][] layout = {{E,E,W,E}, 
				            {E,E,B,E},
				            {E,E,W,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelowLeft_NotDead() {
		State[][] layout = {{E,E,W,E}, 
				            {E,W,B,E},
				            {E,E,W,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(2,1));
	}

	@Test
	public void testBlackPiece21_WhiteAboveBelowLeftRight_Dead() {
		State[][] layout = {{E,E,W,E}, 
				            {E,W,B,W},
				            {E,E,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(2,1));
	}

	// Prove that the prod code is taking the x and y values into account
	@Test
	public void testBlackPiece31_WhiteSurrounding11_Dead() {
		State[][] layout = {{E,W,E,E,E}, 
				            {W,E,W,B,E},
				            {E,W,E,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(3,1));
	}
	
	// Prove that the prod code can cope with the piece being on the edge
	@Test
	public void testBlackPieceOnTopRow_WhiteSurrounding_Dead() {
		State[][] layout = {{W,B,W},
				            {E,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,0));
	}
	
	@Test
	public void testBlackPieceOnLeftHandSide_WhiteSurrounding_Dead() {
		State[][] layout = {{W,E},
				            {B,W},
				            {W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(0,1));
	}
	
	@Test
	public void testBlackPieceOnRightHandSide_WhiteSurrounding_Dead() {
		State[][] layout = {{E,W},
				            {W,B},
				            {E,W}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void testBlackPieceOnBottomRow_WhiteSurrounding_Dead() {
		State[][] layout = {{E,W,E},
				            {W,B,W}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}

	@Test
	public void testBlackPieceOnBottomRow_WhiteNotSurrounding_Alive() {
		State[][] layout = {{E,E,E},
				            {W,B,W}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}

	// Prove corners work
	@Test
	public void testBlackPieceTopLeftCorner_WhiteSurrounding_Dead() {
		State[][] layout = {{B,W},
				            {W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(0,0));
	}

	@Test
	public void testBlackPieceTopRightCorner_WhiteSurrounding_Dead() {
		State[][] layout = {{W,B},
				            {E,W}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,0));
	}

	@Test
	public void testBlackPieceBottomRightCorner_WhiteSurrounding_Dead() {
		State[][] layout = {{E,W},
				            {W,B}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}

	@Test
	public void testBlackPieceBottomLeftCorner_WhiteSurrounding_Dead() {
		State[][] layout = {{W,E},
				            {B,W}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(0,1));
	}

	// Multiple black pieces
	@Test
	public void test2BlackPieces_OneBelowTheOther_FullySurrounded_Dead() {
		State[][] layout = {{E,W,E}, 
				            {W,B,W},
				            {W,B,W},
				            {E,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void test2BlackPieces_OneBelowTheOther_NotSurrounded_Dead() {
		State[][] layout = {{E,W,E}, 
				            {W,B,W},
				            {W,B,W},
				            {E,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}
	
	@Test
	public void test2BlackPieces_OneToTheRightOfTheOther_Surrounded_Dead() {
		State[][] layout = {{E,W,W,E}, 
				            {W,B,B,W},
				            {E,W,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void test2BlackPieces_OneToTheRightOfTheOther_NotSurrounded_NotDead() {
		State[][] layout = {{E,W,W,E}, 
				            {W,B,B,W},
				            {E,W,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}
	
	@Test
	public void test3BlackPieces_OneToTheRightOfTheOther_Surrounded_Dead() {
		State[][] layout = {{E,W,W,W,E}, 
				            {W,B,B,B,W},
				            {E,W,W,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void test3BlackPieces_OneToTheRightOfTheOther_NotSurrounded_NotDead() {
		State[][] layout = {{E,W,W,W,E}, 
				            {W,B,B,B,W},
				            {E,W,W,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}
	
	@Test
	public void testTheBigOne_NotSurrounded_NotDead() {
		State[][] layout = {{E,W,W,W,E}, 
						    {W,B,B,B,W},
						    {W,B,B,B,W},
						    {E,W,B,B,W},
				            {E,W,W,E,E}};
		final Board board = new Board(layout);
		assertFalse("Should be alive", board.isDead(1,1));
	}
	
	@Test
	public void testTheBigOne_Surrounded_Dead2() {
		State[][] layout = {{E,W,W,W,E}, 
						    {W,B,B,B,W},
						    {E,W,W,B,W},
						    {W,B,B,B,W},
				            {E,W,W,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	@Test
	public void testTheBigOne_Surrounded_Dead() {
		State[][] layout = {{E,W,W,W,E}, 
						    {W,B,B,B,W},
						    {W,B,B,B,W},
						    {E,W,B,B,W},
				            {E,W,W,W,E}};
		final Board board = new Board(layout);
		assertTrue("Should be dead", board.isDead(1,1));
	}
	
	
	// Tests for location list
	@Test
	public void testLocationList_BlackPiece11_NoWhite() {
		State[][] layout = {{E,E,E}, 
				           {E,B,E}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 1).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_BlackPiece10_NoWhite() {
		State[][] layout = {{E,B,E}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}

	@Test
	public void testLocationList_2BlackPiece10_NoWhite() {
		State[][] layout = {{E,B,B}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 0).location(2, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}

	@Test
	public void testLocationList_2BlackPiece11() {
		State[][] layout = {{E,E,E},
				            {E,B,B}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 1).location(2, 1).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_3BlackPiece11_Horizontal() {
		State[][] layout = {{B,B,B}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 0).location(0, 0).location(2, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}

	@Test
	public void testLocationList_3BlackPiece_Vertical() {
		State[][] layout = {{E,B,E},
				            {E,B,E},
				            {E,B,E}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 1).location(1, 0).location(1, 2).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_5BlackPiece_Cross() {
		State[][] layout = {{E,B,E},
				            {B,B,B},
				            {E,B,E}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 1).location(0, 1).location(2, 1).location(1, 0).location(1, 2).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}

	@Test
	public void testLocationList_4BlackPiece11_Horizontal() {
		State[][] layout = {{B,B,B,B}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 0).location(0, 0).location(2, 0).location(3, 0).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,0));
	}
	
	@Test
	public void testLocationList_6BlackPiece_Cross() {
		State[][] layout = {{E,B,B},
				            {B,B,B},
				            {E,B,E}};
		final Board board = new Board(layout);
		
		final List<Location> expectedLocations = aLocationList().location(1, 1).location(0, 1).location(2, 1).location(2, 0).location(1, 0).location(1, 2).build();
		assertEquals("List not as expected", expectedLocations, board.buildLocationList(1,1));
	}


}
