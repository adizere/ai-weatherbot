package coordinator;

import java.util.List;

import model.Domain;
import model.Flag;
import model.PredicateAdaptor;
import model.Variable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import control.UiController;

import repository.DomainRepository;
import repository.LabelRepository;
import repository.PredicateAdaptorRepository;
import repository.TimelineRepository;
import repository.VariableRepository;
import repository.WeatherDataRepository;
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
		

		
		DomainRepository 			dr = new DomainRepository();
		LabelRepository 			lr = new LabelRepository();
		PredicateAdaptorRepository 	par = new PredicateAdaptorRepository();
		TimelineRepository 			tr = new TimelineRepository();
		VariableRepository 			vr = new VariableRepository();
		WeatherDataRepository		wdr = new WeatherDataRepository();
		WordRepository 				wr = new WordRepository();
		
		StatementEvaluator statementEvaluator = new StatementEvaluator(wr);
		
		UiController uiController = new UiController();
		uiController.setStatementEvaluator(statementEvaluator);
		uiController.createMainWindow();
		
	}

}
