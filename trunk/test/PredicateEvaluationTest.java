import java.util.ArrayList;

import model.Domain;
import model.Label;
import model.Predicate;
import model.Variable;
import junit.framework.TestCase;
import junit.framework.TestResult;
import services.PredicateLogic;
import services.impl.PredicateLogicImpl;


public class PredicateEvaluationTest extends TestCase {

	private Variable temp;
	private Variable vant;
	private Variable cer;
	private Predicate frig;
	private Predicate cald;
	private Predicate vant_puternic;
	private ArrayList<Label> ziua1;
	private ArrayList<Label> saptamana2;
	private Predicate cer_senin;
	private PredicateLogic pe;
	@Override
	public TestResult run() {
		
		return super.run();
		
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub

		temp = new Variable("temperatura", new Domain(-50, 50));
		vant = new Variable("viteza vantului ", new Domain(-500, 500));
		cer = new Variable("acoperirea cerului", new Domain(0, 100));

		frig = new Predicate();
		frig.put(temp, new Domain(-5, 10));
		
		cald = new Predicate();
		cald.put(temp, new Domain(20, 30 ));
		
		vant_puternic = new Predicate();
		vant_puternic.put(vant, new Domain(80, 200));
		
		cer_senin = new Predicate();
		cer_senin.put(cer, new Domain(0, 45));
		
		ziua1 = new ArrayList<Label>();
		ziua1.add(new Label(cer, new Domain(20, 40)));
		ziua1.add(new Label(temp, new Domain(15, 23)));
		
		saptamana2 = new ArrayList<Label>();
		saptamana2.add( new Label(vant, new Domain(100, 200)));
		
		pe = new PredicateLogicImpl();
		
		super.setUp();
	}
	
	public void testCerSeninZiua1()
	{
		System.out.println(pe.evaluatePredicate(cer_senin, ziua1));
	}

	public void testCaldZiua1(){
		System.out.println(pe.evaluatePredicate(cald, ziua1));
	}
	
	public void testVantPuternic(){
		System.out.println("Vant puternic :");
		System.out.println(pe.evaluatePredicate(vant_puternic, saptamana2));
		
		saptamana2.clear();
		saptamana2.add(new Label(vant, new Domain(0, 50)));
		
		System.out.println(pe.evaluatePredicate(vant_puternic, saptamana2));
	}
}
