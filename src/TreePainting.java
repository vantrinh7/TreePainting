/**
 * Class for painting trees
 * @author VanTrinh
 * @version: Feb 17, 2017
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class TreePainting extends JComponent implements MouseListener {

	// Number of branches
	public static final int NUM_BRANCHES = 8;
	// Diameter of the blossoms
	public static final int BLOSSOM_DIAM = 24;
	// Golden ration that makes the trunk length: branch length ratio
	// aesthetically appealing
	public static final double GOLDEN_RATIO = 2.118;
	// Thickness of the trunk and branch
	public static final int BRANCH_THICKNESS = 7;

	// Starting point of the tree trunk
	private Point2D startTrunk;
	// End point of the tree trunk
	private Point2D endTrunk;
	// Boolean value for mouse press at the beginning is false
	private boolean mousePress = false;
	// Boolean value for mouse release at the beginning is false
	private boolean mouseRelease = false;

	/**
	 * Constructor of tree painting class
	 */
	public TreePainting() {
		// Add a mouse listener for its own events
		addMouseListener(this);
	}

	/**
	 * Draw background and tree using the paint method
	 * 
	 * @param g
	 *            the graphics
	 */
	public void paint(Graphics g) {
		// Paint the background
		paintBackground(g);

		// If user has pressed and released mouse, paint tree
		if (mousePress && mouseRelease) {
			// Draw the trunk
			drawTree(g, startTrunk, endTrunk);
			// Compute the length of the trunk
			double trunkLength = computeTrunkLength(startTrunk, endTrunk);
			// Starting angle
			double alpha = 5;
			// Draw branches
			for (int i = 0; i < NUM_BRANCHES; i++) {
				drawBranch(g, endTrunk, trunkLength / GOLDEN_RATIO, alpha);
				// Compute the end point of the branch based on start, length
				// and angle
				Point2D branchEnd = computeEndPoint(endTrunk, trunkLength
						/ GOLDEN_RATIO, alpha);
				// Draw blossom for each branch
				drawBlossom(g, branchEnd);
				// Increment angle
				alpha += 15;
			}
		}
	}

	/**
	 * Method to paint background black
	 * 
	 * @param g
	 *            the graphics
	 */
	public void paintBackground(Graphics g) {
		// Set color to black
		g.setColor(Color.BLACK);
		// Draw black on the whole screen
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

	}

	/**
	 * Method to draw a tree Source: StackOverflow and Oracle websites are where
	 * I learned how to use stroke
	 * 
	 * @param g
	 *            the Graphics
	 * @param trunkStart
	 *            the start of the trunk
	 * @param trunkEnd
	 *            the end of the trunk
	 */
	public void drawTree(Graphics g, Point2D trunkStart, Point2D trunkEnd) {
		// Set trunk color to be green
		g.setColor(new Color(1, 122, 41, 200));
		// Convert to graphic 2d
		Graphics2D g2 = (Graphics2D) g;
		// Create a new stroke
		g2.setStroke(new BasicStroke(BRANCH_THICKNESS, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		// Draw a new line
		g2.draw(new Line2D.Double(trunkStart, trunkEnd));
	}

	/**
	 * Method to draw a tree Source: StackOverflow and Oracle websites are where
	 * I learned how to use stroke
	 * 
	 * @param g
	 *            the Graphics
	 * @param branchStart
	 *            the start of the branch
	 * @param branchEnd
	 *            the end of the branch
	 * @param length
	 *            the length of the branch
	 * @param angle
	 *            the angle of the branch
	 */
	public void drawBranch(Graphics g, Point2D branchStart, double length,
			double angle) {
		// Compute the end point of the branch based on start, length and angle
		Point2D branchEnd = computeEndPoint(branchStart, length, angle);
		// Set branch color to be green
		g.setColor(new Color(1, 122, 41, 200));
		// Convert to graphic 2d
		Graphics2D g2 = (Graphics2D) g;
		// Create a new stroke
		g2.setStroke(new BasicStroke(BRANCH_THICKNESS, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		// Draw a new line as a branch
		g2.draw(new Line2D.Double(branchStart, branchEnd));
	}

	/**
	 * Method to draw a blossom
	 * 
	 * @param g
	 *            the blossom
	 * @param p
	 *            the center of the blossom
	 */
	public void drawBlossom(Graphics g, Point2D p) {
		// Generate random numbers for color components
		int randRed = (int) (Math.random() * (250 - 0));
		int randGreen = (int) (Math.random() * (250 - 0));
		int randBlue = (int) (Math.random() * (250 - 0));
		// Set color of the blossom
		g.setColor(new Color(randRed, randGreen, randBlue));
		// Draw the blossom
		g.fillOval((int) p.getX() - BLOSSOM_DIAM / 2, (int) p.getY()
				- BLOSSOM_DIAM / 2, BLOSSOM_DIAM, BLOSSOM_DIAM);
	}

	/**
	 * Method to computer the end point of a branch
	 * 
	 * @param p
	 *            the starting point of the branch
	 * @param length
	 *            the desired length of the branch
	 * @param angle
	 *            the desired angle of the branch
	 * @return end point of the branch
	 */
	public Point2D computeEndPoint(Point2D p, double length, double angle) {
		return new Point2D.Double(p.getX() + length * Math.cos(angle), p.getY()
				+ length * Math.sin(angle));
	}

	/**
	 * Method to compute the length of the trunk using Math function
	 * 
	 * @param trunkStart
	 *            the start of the trunk
	 * @param trunkEnd
	 *            the end of the trunk
	 * @return the trunk length
	 */
	public double computeTrunkLength(Point2D trunkStart, Point2D trunkEnd) {
		// Calculate the difference in x-coordinate
		double left = trunkEnd.getX() - trunkStart.getX();
		// Calculate the difference in y-coordinate
		double top = trunkEnd.getY() - trunkStart.getY();
		// Return the square root of left squared plus top squared, which is the
		// trunk length
		return Math.hypot(left, top);
	}

	/**
	 * Invoked when the mouse is pressed down. Adds a circle at the current
	 * location.
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mousePressed(MouseEvent e) {
		// It's true that the mouse is pressed
		mousePress = true;
		// Record the point user presses as starting point
		startTrunk = new Point2D.Double(e.getX(), e.getY());
	}

	/**
	 * Invoked when the mouse is released.
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseReleased(MouseEvent e) {
		// It's true that the mouse is released now
		mouseRelease = true;
		// Record the point user releases as end point
		endTrunk = new Point2D.Double(e.getX(), e.getY());
		// Pain the tree
		repaint();
	}

	/**
	 * Invoked when the mouse enters the component.
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse leaves the component.
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse is clicked (pressed down and released).
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseClicked(MouseEvent e) {
	}
}
