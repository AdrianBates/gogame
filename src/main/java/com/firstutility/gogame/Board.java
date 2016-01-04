package com.firstutility.gogame;

public class Board {

	private int[][] layout;

	public Board(int[][] layout) {
		this.layout = layout;
		// TODO Auto-generated constructor stub
	}

	public boolean isDead(int x, int y) {

		boolean isDead = isSingleLocationDead(x, y, layout);

		if (onBoard(x, y + 1) && layout[y + 1][x] == 1) {
			isDead = isSingleLocationDead(x, y + 1, layout);
		}
		if (onBoard(x + 1, y) && layout[y][x + 1] == 1) {
			isDead = isSingleLocationDead(x + 1, y, layout);
		}
		return isDead;
	}

	private boolean isSingleLocationDead(int x, int y, int[][] board) {
		if (blocked(x, y - 1) && blocked(x, y + 1) && blocked(x - 1, y)
				&& blocked(x + 1, y)) {
			return true;
		}

		return false;
	}

	private boolean blocked(int x, int y) {
		return !onBoard(x, y) || layout[y][x] == 2 || layout[y][x] == 1;
	}

	private boolean onBoard(int x, int y) {
		return !(x < 0 || x == layout[0].length || y < 0 || y == layout.length);
	}

}
