package coordinator;

import java.util.List;

import model.Domain;
import model.Flag;
import model.Variable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import control.UiController;

import repository.DomainRepository;
import repository.TimelineRepository;
import repository.VariableRepository;
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
		

		
	}

}
