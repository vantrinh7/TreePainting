/**
 * 
 * @author VanTrinh
 * @version Feb 17 2017
 */

import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;

public class SummerTreePainting extends TreePainting {

	/**
	 * Constructor of the Spring tree painting class
	 */
	public SummerTreePainting() {
		super();
	}

	/**
	 * This method paints background of summer
	 * @param g the background
	 */
	public void paintBackground(Graphics g) {
		// Set color
		g.setColor(new Color(142,223,255));
		// Paint the whole screen
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Set color red
		g.setColor(Color.WHITE);
		//Paint part of the screen
		g.fillRect(0, this.getHeight()*2/3, this.getWidth(), this.getHeight()*2/3);
		//Set color yellow
		g.setColor(Color.YELLOW);
		//Draw a sun
		g.fillOval(this.getWidth()/2 - 30, this.getHeight() - this.getHeight()*9/10, 60, 60);
		
	}
}