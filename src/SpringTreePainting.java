/**
 * 
 * @author VanTrinh
 * @version Feb 17 2017
 */

import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;

public class SpringTreePainting extends TreePainting {

	/**
	 * Constructor of the Spring tree painting class
	 */
	public SpringTreePainting() {
		super();
	}

	/**
	 * This method paints background of Spring
	 * 
	 * @param g
	 *            the background
	 */
	public void paintBackground(Graphics g) {
		// Set color pink
		g.setColor(new Color (188, 244, 183));
		// Paint the whole screen
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Set color blue
		g.setColor(new Color(120, 175, 226));
		// Rainy day..
		for (int i = 0; i < 300; i++) {
			// Pick random coordinates between 0 and 450
			int randX1 = (int) (Math.random() * (450 - 0));
			int randY1 = (int) (Math.random() * (450 - 0));
			g.drawLine(randX1, randY1, randX1, randY1 + 15);
		}

	}
}
