package objectDesign_2048Template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;

public class Tile {

	public static final int SIZE = 100;

	private static final int BLANK = 0;
	private static final HashMap<Integer, Color> colorIndex;

	// TODO: attributes

	static {
		colorIndex = new HashMap<Integer, Color>();
		colorIndex.put(0, Color.WHITE);
		colorIndex.put(2, new Color(0xEC0F47));
		colorIndex.put(4, new Color(0xEE6B3B));
		colorIndex.put(8, new Color(0xFBBF54));
		colorIndex.put(16, new Color(0xABD96D));
		colorIndex.put(32, new Color(0x15C286));
		colorIndex.put(64, new Color(0x087353));
		colorIndex.put(128, new Color(0x045459));
		colorIndex.put(256, new Color(0x262949));
		colorIndex.put(512, new Color(0x1A1333));
		colorIndex.put(1024, new Color(0xA02C5D));
		colorIndex.put(2048, new Color(0x700460));
	}

	/**
	 * Creates a new Tile. Sets centerX, centerY to inputed values, number is
	 * set to BLANK, color is set to corresponding colorIndex color, and
	 * isCombined is false.
	 * 
	 * @param centerX
	 * @param centerY
	 */
	public Tile(int centerX, int centerY) {
		// TODO: Complete constructor
	}

	/**
	 * Returns number.
	 * 
	 * @return number.
	 */
	public int getNumber() {
		// TODO: Complete method
	}

	/**
	 * @return isCombined
	 */
	public boolean isCombined() {
		// TODO: Complete method
	}

	/**
	 * Sets isCombined.
	 * 
	 * @param combined
	 */
	public void setCombined(boolean combined) {
		// TODO: Complete method
	}

	/**
	 * Returns true if is BLANK tile.
	 * 
	 * @return if is BLANK tile.
	 */
	public boolean isZeroTile() {
		// TODO: Complete method
	}

	/**
	 * Reassigns number to newNumber and changes tile's color according to the
	 * newNumber.
	 * 
	 * @param newNumber
	 *            number to change it to
	 */
	public void reset(int newNumber) {
		// TODO: Complete method

	}

	/**
	 * Draws a square using color and a black border containing the number value
	 * in the center.
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		// TODO: Complete method
	}

	/**
	 * Overrides Object's equals().
	 * 
	 * @param o
	 *            inputed Object
	 * @return true if inputed tile is equal; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Tile))
			return false;
		Tile other = (Tile) o;
		return number == other.number;
	}

	/**
	 * Overrides Object's toString().
	 * 
	 * @return String representation of this tile.
	 */
	@Override
	public String toString() {
		return "[" + number + "]";
	}
}