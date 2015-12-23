package com.firstutility.gogame;

public class Dead {

	public static boolean isDead(int x, int y, int[][] board) {
		
		if (blocked(x, y-1, board) && blocked(x, y+1, board) && blocked(x-1, y, board) && blocked(x+1, y, board)) {
			return true;
		}
		
		return false;
	}

	private static boolean blocked(int x, int y, int[][] board) {
		return x < 0 || x == board[0].length || y < 0 || y == board.length || board[y][x] == 2;
	}
	
}
