package coordinator;

import model.Flag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import control.UiController;

import repository.WordRepository;
import services.StatementEvaluator;
import ui.BotGUI;



public class ApplicationCoordinator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordRepository wordRepository = new WordRepository();
		StatementEvaluator statementEvaluator = new StatementEvaluator(wordRepository);
		
		BotGUI botGui = new BotGUI();
		
		
		UiController uiController = new UiController();
		uiController.setStatementEvaluator(statementEvaluator);
		uiController.setBotGui(botGui);
		uiController.createMainWindow();
		
	}

}
