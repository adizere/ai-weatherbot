package coordinator;

import model.Flag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ui.BotGUI;



public class ApplicationCoordinator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BotGUI botGui = new BotGUI();
		botGui.setVisible(true);
	}

}
