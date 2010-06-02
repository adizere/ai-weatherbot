package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import control.UiController;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BotGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane chatScrollPane;
	private JPanel inputPanel;
	private JTextField inputTextField;
	private JTextArea chatTextArea;
	private JLabel imageLabel;
	private JButton inputButton;
	private UiController uiController;

	private final static String newline = "\n";
	private final static String lineStart = ">>> ";
	private final static String botLine = "BOT: ";

	public BotGUI(UiController uiController) {
		super();
		initGUI();
		this.uiController = uiController;
	}
	
	public BotGUI(){
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
			{
				chatScrollPane = new JScrollPane();
				{
					chatTextArea = new JTextArea();
					chatScrollPane.setViewportView(chatTextArea);
					chatTextArea.setPreferredSize(new java.awt.Dimension(538,
							303));
					chatTextArea.setEditable(false);
					chatTextArea.setColumns(96);
				}
			}
			{
				inputPanel = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout(
						(JComponent) inputPanel);
				inputPanel.setLayout(jPanel1Layout);
				{
					inputTextField = new JTextField();
					inputTextField.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							inputTextFieldactionPerformed(evt);
						}
					});
				}
				{
					inputButton = new JButton();
					inputButton.setText("Trimite");
					inputButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							inputButtonActionPerformed(evt);
						}
					});
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(inputTextField, 0, 443, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(inputButton, 0, 75, Short.MAX_VALUE)
					.addContainerGap());
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup()
					.addComponent(inputTextField, GroupLayout.Alignment.LEADING, 0, 55, Short.MAX_VALUE)
					.addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					    .addComponent(inputButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addGap(0, 32, Short.MAX_VALUE)));
			}
			{
				imageLabel = new JLabel();
				imageLabel.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("resources/botImage.jpg")));
				// imageLabel.setIcon(arg0);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addContainerGap().addComponent(imageLabel, 0, 180,
							Short.MAX_VALUE).addPreferredGap(
							LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(chatScrollPane, 0, 313, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, 55,
							GroupLayout.PREFERRED_SIZE).addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addContainerGap().addGroup(
							thisLayout.createParallelGroup().addComponent(
									chatScrollPane,
									GroupLayout.Alignment.LEADING, 0, 541,
									Short.MAX_VALUE).addComponent(inputPanel,
									GroupLayout.Alignment.LEADING, 0, 541,
									Short.MAX_VALUE).addComponent(imageLabel,
									GroupLayout.Alignment.LEADING, 0, 541,
									Short.MAX_VALUE)).addContainerGap());
			pack();
			this.setSize(581, 634);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public UiController getUiController() {
		return uiController;
	}

	public void setUiController(UiController uiController) {
		this.uiController = uiController;
	}

	public String getInputTextField() {
		String text = inputTextField.getText();
		if (!text.isEmpty()) {
			return text;
		}
		return null;
	}

	public void inputTextFieldactionPerformed(java.awt.event.ActionEvent evt) {
		String text = inputTextField.getText();
		if (!text.isEmpty()) {
			/*
			Font userFont = new Font("Tahoma", Font.PLAIN, 16);
			AttributedString attrString = new AttributedString(text);
			attrString.addAttribute(TextAttribute.FONT, userFont);
			attrString.addAttribute(TextAttribute.FOREGROUND, Color.BLUE);
			*/
			chatTextArea.append(lineStart + text.trim() + newline);
			inputTextField.setText(null);

			// Make sure the new text is visible, even if there
			// was a selection in the text area.
			chatTextArea.setCaretPosition(chatTextArea.getDocument()
					.getLength());
			//insertBotResponse("Fine wheather today everywhere. :)");
			this.uiController.giveResponse(text);
		}
	}

	private void inputButtonActionPerformed(ActionEvent evt) {
		String text = inputTextField.getText();
		if (!text.isEmpty()) {
			/*
			Font userFont = new Font("Tahoma", Font.PLAIN, 16);
			AttributedString attrString = new AttributedString(text);
			attrString.addAttribute(TextAttribute.FONT, userFont);
			attrString.addAttribute(TextAttribute.FOREGROUND, Color.BLUE);
			*/
			chatTextArea.append(lineStart + text.trim() + newline);
			inputTextField.setText(null);

			// Make sure the new text is visible, even if there
			// was a selection in the text area.
			chatTextArea.setCaretPosition(chatTextArea.getDocument()
					.getLength());
			//insertBotResponse("Fine wheather today everywhere. :)");
			this.uiController.giveResponse(text);
		}
	}
	
	
	public void insertBotResponse(String response){
		/*
		Font botFont = new Font("Lucida Console", Font.BOLD, 14);
		AttributedString attrString = new AttributedString(response);
		attrString.addAttribute(TextAttribute.FONT, botFont);
		attrString.addAttribute(TextAttribute.FOREGROUND, Color.RED);
		*/
		chatTextArea.append(botLine + response.trim() + newline);
		chatTextArea.setCaretPosition(chatTextArea.getDocument()
				.getLength());
	}

}
