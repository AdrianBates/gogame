package com.firstutility.gogame;

public class Dead {

	public static boolean isDead(int x, int y, int[][] board) {
		
		if (board[0][1] == 2 && board[1][0] == 2) {
			return true;
		}
		if (board[0][0] == 2 && board[2][0] == 2 && board[1][1] == 2) {
			return true;
		}
		return false;
	}

}
