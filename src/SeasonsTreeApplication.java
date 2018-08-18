import javax.swing.JFrame;

public class SeasonsTreeApplication {
	public static final String INSTRUCTIONS_TEXT = "Click, drag, and release to start painting!";

	/**
	 * Create a JFrame that holds the TreePaintings.
	 * 
	 **/
	public static void main(String[] args) {
		JFrame guiFrame;
		// create a new JFrame to hold a TreeCollage (a collage of five
		// paintings)
		guiFrame = new JFrame("Tree Painting Collage");

		// set size
		guiFrame.setSize(1200, 500);

		// create a TreeCollage and add it
		guiFrame.add(new TreeCollagePanel(INSTRUCTIONS_TEXT));
		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// show frame
		guiFrame.setVisible(true);
	}
}
