package objectDesign_2048Template;

import java.awt.Graphics;

public class TileManager {

	public static final int START_SIZE = 4;

	private Tile[][] tiles;
	private int numBlankTiles = START_SIZE * START_SIZE;
	private int maxNumber = 0;
	private boolean noMovesMade;

	public TileManager(int startX, int startY) {
		tiles = new Tile[START_SIZE][START_SIZE];

		int i, j;
		for (i = 0; i < tiles.length; i++) {
			for (j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Tile(startX + j * Tile.SIZE,
						startY + i * Tile.SIZE);
			}
		}

		addTile();
		addTile();
	}

	public void update(int direction) {
		if (direction == GameBoard.UP)
			shiftUp();
		else if (direction == GameBoard.DOWN)
			shiftDown();
		else if (direction == GameBoard.RIGHT)
			shiftRight();
		else if (direction == GameBoard.LEFT)
			shiftLeft();
		else
			return;

		if (numBlankTiles != 0 && !noMovesMade)
			addTile();
	}

	public boolean cannotMove() {
		return numBlankTiles == 0 && !hasDuplicates();
	}

	public boolean has2048() {
		return maxNumber == 2048;
	}

	public void drawTiles(Graphics g) {
		int i, j;
		for (i = 0; i < tiles.length; i++) {
			for (j = 0; j < tiles[i].length; j++) {
				tiles[i][j].draw(g);
			}
		}
	}

	private boolean hasDuplicates() {
		int i, j;
		for (i = 0; i < tiles.length; i++) {
			for (j = 0; j < tiles[i].length; j++) {
				if (equalNeighbors(i, j))
					return true;
			}
		}
		return false;
	}

	private boolean equalNeighbors(int row, int col) {
		int num = tiles[row][col].getNumber();
		boolean leftEqual = inBounds(row, col - 1)
				&& tiles[row][col - 1].getNumber() == num;
		boolean rightEqual = inBounds(row, col + 1)
				&& tiles[row][col + 1].getNumber() == num;
		boolean topEqual = inBounds(row - 1, col)
				&& tiles[row - 1][col].getNumber() == num;
		boolean botEqual = inBounds(row + 1, col)
				&& tiles[row + 1][col].getNumber() == num;

		return leftEqual || rightEqual || topEqual || botEqual;
	}

	private void shiftUp() {
		int i, j;
		noMovesMade = true;
		for (i = 0; i < START_SIZE; i++) {
			for (j = 0; j < START_SIZE; j++) {
				tiles[i][j].setCombined(false);
				if (tiles[i][j].getNumber() != 0)
					shiftTile(i, j, -1, 0);
			}
		}
	}

	private void shiftDown() {
		int i, j;
		noMovesMade = true;
		for (i = START_SIZE - 1; i >= 0; i--) {
			for (j = 0; j < START_SIZE; j++) {
				tiles[i][j].setCombined(false);
				if (tiles[i][j].getNumber() != 0)
					shiftTile(i, j, 1, 0);
			}
		}
	}

	private void shiftLeft() {
		int i, j;
		noMovesMade = true;
		for (i = 0; i < START_SIZE; i++) {
			for (j = 0; j < START_SIZE; j++) {
				tiles[j][i].setCombined(false);
				if (tiles[j][i].getNumber() != 0)
					shiftTile(j, i, 0, -1);
			}
		}
	}

	private void shiftRight() {
		int i, j;
		noMovesMade = true;
		for (i = START_SIZE - 1; i >= 0; i--) {
			for (j = 0; j < START_SIZE; j++) {
				tiles[j][i].setCombined(false);
				if (tiles[j][i].getNumber() != 0)
					shiftTile(j, i, 0, 1);
			}
		}
	}

	private void shiftTile(int row, int col, int xDir, int yDir) {
		while (inBounds(row + xDir, col + yDir)
				&& tiles[row + xDir][col + yDir].isZeroTile()
				&& !tiles[row][col].isZeroTile()) {
			swapTiles(tiles[row][col], tiles[row + xDir][col + yDir]);
			row += xDir;
			col += yDir;
			noMovesMade = false;
		}
		if (inBounds(row + xDir, col + yDir))
			combineTiles(tiles[row][col], tiles[row + xDir][col + yDir]);
	}

	private boolean inBounds(int row, int col) {
		return row >= 0 && row < tiles.length && col >= 0 && col < tiles.length;
	}

	private void swapTiles(Tile tile1, Tile tile2) {
		int temp = tile2.getNumber();
		tile2.reset(tile1.getNumber());
		tile1.reset(temp);
	}

	private void combineTiles(Tile tile1, Tile tile2) {
		if (tile1.equals(tile2) && !tile2.isCombined()) {
			int newNum = tile2.getNumber() * 2;
			tile2.reset(newNum);
			if (newNum > maxNumber)
				maxNumber = newNum;
			tile1.reset(0);
			tile2.setCombined(true);
			numBlankTiles++;
			noMovesMade = false;
		}
	}

	private void addTile() {
		int count = (int) (Math.random() * numBlankTiles) + 1;
		Tile tile;
		int i, j;

		for (i = 0; i < tiles.length; i++) {
			for (j = 0; j < tiles[i].length; j++) {
				tile = tiles[i][j];
				if (tile.isZeroTile()) {
					if (count == 1) {
						tile.reset(2);
						numBlankTiles--;
						return;
					}
					count--;
				}
			}
		}
	}
}