package repository;

import java.util.ArrayList;
import java.util.List;

import model.Domain;
import model.Predicate;
import model.PredicateAdaptor;
import model.Variable;

public class PredicateRepository {
	
	private PredicateAdaptorRepository par;
	private DomainRepository dr;
	private VariableRepository vr;
	private long maxId = 1;
	
	private List<Predicate> predicates = new ArrayList<Predicate>();
	
	/**
	 * @param par
	 * @param dr
	 * @param vr
	 */
	public PredicateRepository(PredicateAdaptorRepository par,
			DomainRepository dr, VariableRepository vr) {
		super();
		this.par = par;
		this.dr = dr;
		this.vr = vr;
		
		
	}
	
	private void populate(){

		Domain d;
		Variable v;
		Predicate p;

		for(PredicateAdaptor pa : par.getList()){

			d = dr.findById(pa.getDomain_id());
			v = vr.findById(pa.getVariable_id());
			p = this.findById(pa.getPredicate_id());

			if(p != null)
				p.put(v, d);
		}

	}
	
	public Predicate findById(long id){
		for(Predicate p:this.predicates)
			if(p.getId() == id)
				return p;
		return null;
	}
}
