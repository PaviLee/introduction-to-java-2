package objectDesign_2048Template;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Font;
import java.awt.FontMetrics;

public class GameBoard implements KeyListener {

	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int LEFT = 4;
	public static final int MARGIN = Tile.SIZE;
	public static final int SIZE = Tile.SIZE * TileManager.START_SIZE
			+ MARGIN * 2;

	private static final int CONTINUE = 1;
	private static final int WIN = 2;
	private static final int LOSS = 3;

	private Screen screen;
	private Graphics g;
	private TileManager tileManager;
	private Queue<Integer> directions;
	private int winningState;

	public GameBoard() {
		screen = new Screen(SIZE, SIZE);
		screen.getJFrame().addKeyListener(this);
		g = screen.getScreenGraphics();
		tileManager = new TileManager(MARGIN + Tile.SIZE / 2,
				MARGIN + Tile.SIZE / 2);
		directions = new LinkedList<Integer>();
		winningState = CONTINUE;
	}

	public boolean continueGame() {
		return winningState == CONTINUE;
	}

	public void update() {
		if (!directions.isEmpty()) {
			tileManager.update(directions.remove());
			updateWinningState();
		}
	}

	public void draw() {
		screen.clearScreen();
		tileManager.drawTiles(g);
		drawWinningState(g);
		screen.repaint();
	}

	private void updateWinningState() {
		if (tileManager.has2048()) {
			winningState = WIN;
		} else if (tileManager.cannotMove()) {
			winningState = LOSS;
		}
	}

	private void drawWinningState(Graphics g) {
		g.setColor(Color.BLACK);

		String text = "";

		if (winningState == WIN) {
			text = "WIN";
		} else if (winningState == LOSS) {
			text = "LOSS";
		}

		if (winningState == WIN || winningState == LOSS) {
			Font font = new Font("Arial", Font.BOLD, 50);
			FontMetrics metrics = g.getFontMetrics(font);
			Rectangle rectangle = new Rectangle(new Dimension(SIZE, SIZE));
			int x = rectangle.x
					+ (rectangle.width - metrics.stringWidth("WIN")) / 2;
			int y = rectangle.y + ((rectangle.height - metrics.getHeight()) / 2)
					+ metrics.getAscent();
			g.setFont(font);
			g.drawString(text, x, y);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_UP)
			directions.add(UP);
		else if (keyCode == KeyEvent.VK_DOWN)
			directions.add(DOWN);
		else if (keyCode == KeyEvent.VK_RIGHT)
			directions.add(RIGHT);
		else if (keyCode == KeyEvent.VK_LEFT)
			directions.add(LEFT);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}