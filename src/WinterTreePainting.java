/**
 * 
 * @author VanTrinh
 * @version Feb 17 2017
 */

import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;

public class WinterTreePainting extends TreePainting {

	/**
	 * Constructor of the Spring tree painting class
	 */
	public WinterTreePainting() {
		super();
	}

	/**
	 * This method paints background of winter
	 * @param g the background
	 */
	public void paintBackground(Graphics g) {
		// Set color
		g.setColor(new Color(106, 67, 160));
		// Paint the whole screen
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.WHITE);
		for(int i = 0; i< 300; i++){
		//Pick random coordinates between 0 and 450
		int randX = (int)(Math.random()*(450-0));
		int randY = (int)(Math.random()*(450-0));
		//Let it snow!
	    g.fillOval(randX, randY, 7, 7);
		}
	}
}