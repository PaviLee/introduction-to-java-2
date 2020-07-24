package graphicsTools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A specialized JPanel that allows the user to get its graphics. With graphics,
 * the user can draw onto the Screen.
 * 
 * @author Rissa Li
 * @version July 16, 2020
 */
public class Screen extends JPanel {

	private static final long serialVersionUID = -7577759854950579746L;
	private static final int transparent = 0x00000000;

	private JFrame frame;
	private Color color;
	private BufferedImage bImage;
	private Graphics screenGraphics;

	/**
	 * Creates a Screen.
	 * 
	 * @param width
	 *            int width of Screen
	 * @param height
	 *            int height of Screen
	 */
	public Screen(int width, int height) {
		super();

		frame = new JFrame();
		frame.setBounds(0, 0, 0, 0); // Width and height irrelevant
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		setPreferredSize(new Dimension(width, height));
		frame.add(this);
		frame.pack();
		frame.setVisible(true);

		color = Color.WHITE;

		bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		screenGraphics = bImage.getGraphics();
		((Graphics2D) screenGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	/**
	 * Sets the background color of the Screen.
	 * 
	 * @param color
	 *            new color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Returns the JFrame.
	 * 
	 * @return JFrame of the Screen.
	 */
	public JFrame getJFrame() {
		return frame;
	}

	/**
	 * Returns graphics for the Screen.
	 * 
	 * @return graphics for the Screen.
	 */
	public Graphics getScreenGraphics() {
		return screenGraphics;
	}

	/**
	 * Clears the Screen.
	 */
	public void clearScreen() {
		int row, col;
		for (col = 0; col < bImage.getWidth(); col++) {
			for (row = 0; row < bImage.getHeight(); row++) {
				bImage.setRGB(col, row, transparent);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(color);
		g.drawImage(bImage, 0, 0, this);
	}
}
