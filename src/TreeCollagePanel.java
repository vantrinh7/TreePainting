/**
 * Modified by Van Trinh
 * @version Feb 17 2017
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TreeCollagePanel is a JPanel. It will hold all the seasonal TreePaintings we
 * want to display. It uses a GridLayout to specify how they are arranged in the
 * GUI.
 * 
 */
public class TreeCollagePanel extends JPanel {
	private JLabel instructions;
	private JPanel mainCollagePanel;

	/**
	 * Calls super (the superclass constructor) and sets a BorderLayout.
	 * 
	 * In the NORTH region, adds 'instructions', a JLabel, that will display the
	 * instructions.
	 * 
	 * In the CENTER panel, adds 'mainCollagePanel', a JPanel, that will be
	 * organized with a GridLayout to hold a basic TreePainting object plus each
	 * of the four seasonal TreePainting subclass objects: WinterTreePainting,
	 * SpringTreePainting, SummerTreePainting, FallTreePainting.
	 * 
	 */
	public TreeCollagePanel(String instructionsText) {

		super(new BorderLayout());

		// Create instructions label
		instructions = new JLabel(instructionsText);
		// Align the label to be in the middle
		instructions.setHorizontalAlignment(JLabel.CENTER);
		// Add instruction to the north
		add(instructions, BorderLayout.NORTH);

		// Create a new JPanel mainCollagePanel
		mainCollagePanel = new JPanel();
		// Add this panel to the center
		add(mainCollagePanel, BorderLayout.CENTER);
		// Set this as a grid layout
		mainCollagePanel.setLayout(new GridLayout(1, 5));

		// Add tree painting component
		mainCollagePanel.add(new TreePainting());
		// Add spring tree painting component
		mainCollagePanel.add(new SpringTreePainting());
		// Add summer tree painting component
		mainCollagePanel.add(new SummerTreePainting());
		// Add fall tree painting component
		mainCollagePanel.add(new FallTreePainting());
		// Add winter tree painting component
		mainCollagePanel.add(new WinterTreePainting());

	}
}