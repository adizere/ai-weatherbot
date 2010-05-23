package ui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class BotGUI extends javax.swing.JFrame {
	private JPanel chatPanel;
	private JTextArea chatTextArea;
	private JTextField inputTextField;

	public BotGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				chatPanel = new JPanel();
				getContentPane().add(chatPanel, BorderLayout.CENTER);
				chatPanel.setLayout(new BorderLayout());
				chatPanel.setPreferredSize(new java.awt.Dimension(543, 349));
				{
					chatTextArea = new JTextArea();
					chatPanel.add(chatTextArea);
					chatTextArea.setBounds(12, 12, 309, 197);
				}
				{
					inputTextField = new JTextField();
					chatPanel.add(inputTextField);
					inputTextField.setBounds(12, 215, 309, 40);
				}
			}
			pack();
			this.setSize(426, 298);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
