package com.firstutility.gogame;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private static final int BLANK = 0;
	private static final int BLACK = 1;
	private int[][] layout;
	private List<Location> blackLocations = new ArrayList<Location>();

	public Board(int[][] layout) {
		this.layout = layout;
	}

	public boolean isDead(int x, int y) {

		final List<Location> locationList = buildLocationList(x, y);

		return areAllLocationsDead(locationList);
	}

	public List<Location> buildLocationList(int x, int y) {

		if (!blackLocations.contains(new Location(x, y))) {

			blackLocations.add(new Location(x, y));

			if (black(x - 1, y)) {
				buildLocationList(x - 1, y);
			}

			if (black(x + 1, y)) {
				buildLocationList(x + 1, y);
			}

			if (black(x, y - 1)) {
				buildLocationList(x, y - 1);
			}

			if (black(x, y + 1)) {
				buildLocationList(x, y + 1);
			}
		}
		return blackLocations;
	}

	private boolean areAllLocationsDead(final List<Location> locationList) {
		return !locationList.stream().anyMatch(location -> !isSingleLocationDead(location));
	}

	private boolean isSingleLocationDead(Location location) {
		final int x = location.getX();
		final int y = location.getY();
		return blocked(x, y - 1) && blocked(x, y + 1) && blocked(x - 1, y) && blocked(x + 1, y);
	}

	private boolean blocked(int x, int y) {
		return !onBoard(x, y) || layout[y][x] != BLANK;
	}

	private boolean black(int x, int y) {
		return onBoard(x, y) && layout[y][x] == BLACK;
	}

	private boolean onBoard(int x, int y) {
		return x >= 0 && x < layout[0].length && y >= 0 && y < layout.length;
	}

}
