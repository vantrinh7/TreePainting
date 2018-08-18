import javax.swing.JFrame;

public class SingleTreeApplication {
	public static final String INSTRUCTIONS_TEXT = "Click, drag, and release to start painting!";

	public static void main(String[] args) {
		JFrame guiFrame;
		// create a new JFrame to hold a single TreePainting
		guiFrame = new JFrame("A Single Tree Painting");

		// set size
		guiFrame.setSize(400, 500);

		// create a TreePanel and add it
		guiFrame.add(new SingleTreePanel(INSTRUCTIONS_TEXT));
		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// show frame
		guiFrame.setVisible(true);
	}
}
