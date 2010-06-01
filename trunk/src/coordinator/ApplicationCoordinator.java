package coordinator;

import model.Flag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import control.UiController;

import repository.TimelineRepository;
import repository.WordRepository;
import services.StatementEvaluator;
import ui.BotGUI;



public class ApplicationCoordinator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//WordRepository wordRepository = new WordRepository();
		//StatementEvaluator statementEvaluator = new StatementEvaluator(wordRepository);		
		
		UiController uiController = new UiController();
		//uiController.setStatementEvaluator(statementEvaluator);
		uiController.createMainWindow();
		
		String s = "Cum e azi in Cluj ?";
		
		WordRepository w = new WordRepository();
		StatementEvaluator se = new StatementEvaluator(w);
		se.evaluateStatement(s);
		
	}

}
