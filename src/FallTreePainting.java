/**
 * 
 * @author VanTrinh
 * @version Feb 17 2017
 */

import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;

public class FallTreePainting extends TreePainting {

	/**
	 * Constructor of the Spring tree painting class
	 */
	public FallTreePainting() {
		super();
	}

	/**
	 * This method paints the background of winter
	 * @param g the background
	 */
	public void paintBackground(Graphics g) {
		// Set color red
		g.setColor(new Color(216,26,26));
		// Paint the whole screen
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}