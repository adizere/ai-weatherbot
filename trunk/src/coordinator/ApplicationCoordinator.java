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
import repository.PredicateNameRepository;
import repository.PredicateRepository;
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
		

		PredicateNameRepository		pnr = new PredicateNameRepository();
		DomainRepository 			dr = new DomainRepository();
		VariableRepository 			vr = new VariableRepository();
		LabelRepository 			lr = new LabelRepository(vr, dr);
		PredicateAdaptorRepository 	par = new PredicateAdaptorRepository();
		TimelineRepository 			tr = new TimelineRepository();
		WeatherDataRepository		wdr = new WeatherDataRepository(lr, tr);
		WordRepository 				wr = new WordRepository();
		PredicateRepository			pr = new PredicateRepository(par, dr, vr, pnr);
		

		StatementEvaluator statementEvaluator = new StatementEvaluator(wr, dr, lr, par, tr, vr, wdr);
		
		UiController uiController = new UiController();
		uiController.setStatementEvaluator(statementEvaluator);
		uiController.createMainWindow();
		
		
		
	}

}
