package ui;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class BotGUI extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public BotGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
