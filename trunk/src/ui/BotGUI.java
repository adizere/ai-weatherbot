package ui;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;


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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane chatScrollPane;
	private JPanel inputPanel;
	private JTextField inputTextField;
	private JTextArea chatTextArea;
	private JButton inputButton;

	public BotGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				chatScrollPane = new JScrollPane();
				{
					chatTextArea = new JTextArea();
					chatScrollPane.setViewportView(chatTextArea);
				}
			}
			{
				inputPanel = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)inputPanel);
				inputPanel.setLayout(jPanel1Layout);
				{
					inputTextField = new JTextField();
				}
				{
					inputButton = new JButton();
					inputButton.setText("Trimite");
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(inputTextField, 0, 418, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(inputButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap());
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup()
					.addComponent(inputTextField, GroupLayout.Alignment.LEADING, 0, 55, Short.MAX_VALUE)
					.addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					    .addComponent(inputButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addGap(0, 32, Short.MAX_VALUE)));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(200, Short.MAX_VALUE)
				.addComponent(chatScrollPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(chatScrollPane, GroupLayout.Alignment.LEADING, 0, 540, Short.MAX_VALUE)
				    .addComponent(inputPanel, GroupLayout.Alignment.LEADING, 0, 541, Short.MAX_VALUE))
				.addContainerGap());
			pack();
			this.setSize(581, 628);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
